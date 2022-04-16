rootProject.name = "mccommand"

val rootName = rootProject.name

include(
    "$rootName-api",
    "$rootName-core",
    "$rootName-publish",
)