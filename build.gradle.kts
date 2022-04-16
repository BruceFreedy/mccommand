plugins {
    kotlin("jvm") version "1.6.10"
}

allprojects { repositories { mavenCentral() } }

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

