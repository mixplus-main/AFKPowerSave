allprojects {
    version = project.property("mod_version")!!
    group = project.property("maven_group")!!
}

subprojects {
    repositories {
        maven("https://maven.isxander.dev/releases") {
            name = "Xander Maven"
        }

        maven("https://maven.terraformersmc.com/") {
            name = "Terraformers"
        }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(21)
    }
}