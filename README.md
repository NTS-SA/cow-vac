# ☕🚀 WS para devolver la cantidad de animales terneros,terneras, bovino y bubalinos vacunados por propietario/establecimiento del acta confirmada

## 🏁 How To Start

1. Install Java 8: `brew cask install corretto8`
2. Set it as your default JVM: `export JAVA_HOME='/Library/Java/JavaVirtualMachines/amazon-corretto-8.jdk/Contents/Home'`
3. Clone this repository: `git clone https://github.com/CodelyTV/java-ddd-skeleton`.
4. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar): `make build`
    2. Run the tests and plugins verification tasks: `make test`
5. Start developing!

## How Run
java -jar -Dserver.port=8088 -Dsigor.environment=TESTING cow-vac-1.0.0-beta.jar vac_api api

## ☝️ How to update dependencies

* Gradle (current version: 5.6 - [releases](https://gradle.org/releases/)):
`./gradlew wrapper --gradle-version=5.6 --distribution-type=bin` or modifying the [gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties#L3)
* JUnit (current version: 5.5.1 - [releases](https://junit.org/junit5/docs/snapshot/release-notes/index.html)):
[`build.gradle:11`](build.gradle#L11-L12)

## 💡 Related repositories

### ☕ Java

* 📂 [Java Basic Skeleton](https://github.com/CodelyTV/java-basic-skeleton)
* ⚛ [Java OOP Examples](https://github.com/CodelyTV/java-oop-examples)
* 🧱 [Java SOLID Examples](https://github.com/CodelyTV/java-solid-examples)
* 🥦 [Java DDD Example](https://github.com/CodelyTV/java-ddd-example)


