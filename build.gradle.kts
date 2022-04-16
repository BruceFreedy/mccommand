val kotlin_version = "1.6.10"
plugins { kotlin("jvm") version "1.6.10" }

allprojects { repositories { mavenCentral() } }

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    }
}

