# MinimapServer
[![Documentation](https://img.shields.io/badge/-documentation-blue)](https://ewpratten.retrylife.ca/MinimapServer) ![Build plugin](https://github.com/Ewpratten/MinimapServer/workflows/Build%20plugin/badge.svg)

MinimapServer is an open-source re-implementation of [xaero96](https://www.curseforge.com/members/xaero96/projects)'s [Minimap API](https://www.spigotmc.org/resources/minimapapi.35354/) for his popular *[Xaero's Minimap](https://www.curseforge.com/minecraft/mc-mods/xaeros-minimap)* and *[Xaero's World Map](https://www.curseforge.com/minecraft/mc-mods/xaeros-world-map)* Minecraft mods.

This library / plugin is **not** cross-compatible with the original *Minimap API*, but implements most of the same features, and a nearly-identical networking system.

## Usage

The public-facing aspect of MinimapServer is contained in two core classes:

 - [`Waypoint`](https://ewpratten.retrylife.ca/MinimapServer/ca/retrylife/mc/plugins/minimap_server/api/Waypoint.html) - For creating in-world waypoints
 - [`MinimapAPI`](https://ewpratten.retrylife.ca/MinimapServer/ca/retrylife/mc/plugins/minimap_server/api/MinimapAPI.html) - For sending data to clients

## installation

**Step 1.** Add the RetryLife maven server to your `build.gradle` file:

```groovy
repositories {
    maven { 
        name = "GitHubPackages_MinimapServer"
        url 'https://maven.pkg.github.com/ewpratten/MinimapServer'
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }
    maven { url 'https://gpr.retrylife.ca/ewpratten/MinimapServer' }
}
```

**Step 2.** Add this library as a dependency:

```groovy
dependencies {
    implementation 'ca.retrylife.mc.plugins:minimap-server:0.1.1-1.16.3-SNAPSHOT'
    implementation 'ca.retrylife.mc.plugins:minimap-server:0.1.1-1.16.3-SNAPSHOT:sources'
    implementation 'ca.retrylife.mc.plugins:minimap-server:0.1.1-1.16.3-SNAPSHOT:javadoc'
}
```

