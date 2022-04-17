buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    }
}
plugins {
    `maven-publish`
}
apply(plugin = "com.github.johnrengelman.shadow")

val rootName = "mccommand"
val repoName = "brucefreedy"

dependencies {
    api(project(":$rootName-core"))
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    mergeServiceFiles()
    archiveFileName.set("mccommand.jar")
    archiveClassifier.set("")
}


publishing {
    publications {
        create<MavenPublication>("mccommand") {
            groupId = "io.github.$repoName"
            artifactId = rootName
            version = "1.0.1"
            artifact(tasks["shadowJar"])
        }
    }
    repositories {
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
            credentials {
                val prop = org.jetbrains.kotlin.konan.properties.Properties()
                prop.load(rootProject.file("env.properties").inputStream())
                username = (prop["gpr.user"] ?: System.getenv("gpr.user"))?.toString()
                password = (prop["gpr.key"] ?: System.getenv("gpr.key"))?.toString()
            }
        }
    }
/*
    repositories {
        maven {
            name = "mccommand"
            url = uri("https://maven.pkg.github.com/$repoName/$rootName")
            credentials {
                val prop = org.jetbrains.kotlin.konan.properties.Properties()
                prop.load(rootProject.file("env.properties").inputStream())
                username = (prop["gpr.user"] ?: System.getenv("gpr.user"))?.toString()
                password = (prop["gpr.key"] ?: System.getenv("gpr.key"))?.toString()
            }
        }
    }
*/
}
