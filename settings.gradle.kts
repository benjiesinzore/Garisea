pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Garisea"
include(":app")
include(":data")
include(":presentation")
include(":presentation:views")
//include(":presentation:utils")
include(":data:datasets")
