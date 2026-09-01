#! /bin/bash
set -e

cd ${CYBER_DOJO_SANDBOX}

CLASSES=.:`ls /junit/*.jar | tr '\n' ':'`

# Each [test] press starts two JVMs, one to compile and one to run the tests,
# and starting them is most of the wait rather than a part of it. The image holds
# an AOT cache for each, recorded when it was built, holding the classes that JVM
# loads in the form the JVM wants them; reading one back costs a fraction of
# loading them again. There is one cache per JVM because a cache is validated
# against the classpath of the JVM reading it, and these two have nothing in
# common. Nothing is lost when a cache is missing or unusable: the JVM says so
# and loads the classes itself, and the run is only slower.
#
# Your own classes are in neither cache, so editing them cannot invalidate one.
# javac's options are spelled -J here because that is how javac passes an option
# to the JVM running it rather than to the compiler.
#
# The collector is named rather than left to the JVM to choose. Replaying an AOT
# cache under the collector it picks by default crashes it outright, often enough
# to see in a handful of runs, and a JVM that lives for a fraction of a second
# has nothing to gain from a concurrent collector in any case.
JAVAC_JVM_OPTS=()
JAVAC_JVM_OPTS+=(-J-XX:TieredStopAtLevel=1)      # a run is milliseconds; later tiers never repay
JAVAC_JVM_OPTS+=(-J-XX:+UseSerialGC)             # see above
JAVAC_JVM_OPTS+=(-J-XX:AOTCache=/aot/javac.aot)  # the compiler's own classes

TEST_JVM_OPTS=()
TEST_JVM_OPTS+=(-XX:TieredStopAtLevel=1)              # as above, for the JVM running the tests
TEST_JVM_OPTS+=(-XX:+UseSerialGC)                     # as above
TEST_JVM_OPTS+=(-XX:AOTCache=/aot/junit-console.aot)  # JUnit's classes

# Every .java file is compiled, however deep it sits, so a file you add is
# checked whether or not anything else refers to it yet. One that will not
# compile stops the run and says why, rather than being passed over in silence.
SOURCES=$(find . -name '*.java')

# -d . puts each class file where its package says it belongs, rather than beside
# its source. A class in a subdirectory is then where the test runner looks for
# it, including one whose file declares no package at all.
if javac "${JAVAC_JVM_OPTS[@]}" -d . -Xlint:preview -Xlint:unchecked -Xlint:deprecation -cp $CLASSES $SOURCES; then
  java \
    "${TEST_JVM_OPTS[@]}" \
    -jar /junit/junit-platform-console-standalone-6.0.3.jar \
    execute \
    --class-path . \
    --disable-banner \
    --disable-ansi-colors \
    --details=tree \
    --details-theme=ascii \
    --scan-class-path
else
  exit 1
fi
