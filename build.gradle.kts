plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jspecify:jspecify:1.0.0")
    annotationProcessor("org.checkerframework:checker:3.21.0")
    implementation("org.checkerframework:checker-qual:3.21.0")

}
tasks.withType<JavaCompile> {
    // Add the export argument to allow access to internal modules
    options.forkOptions.jvmArgs!!.addAll(listOf(
        "--add-exports", "jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
        "-processor", "org.checkerframework.checker.nullness.NullnessChecker"
    ))
}
tasks.test {
    useJUnitPlatform()
}

