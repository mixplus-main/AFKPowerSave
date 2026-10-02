# AFK PowerSave

A Fabric client-side mod that reduces Minecraft rendering load while you are AFK.

AFK PowerSave changes rendering-related settings and disables selected visual rendering during AFK mode, while keeping game/server simulation running.

## Features

* Automatically detects AFK status
* Configurable AFK activation time
* Configurable AFK FPS
* Configurable Render Distance
* Disable particle rendering
* Hide dropped items
* Hide entities
* Disable entity shadows
* Hide block entities
* Disable clouds
* Disable weather
* Disable sky
* Disable block damage rendering
* Disable block outline rendering
* Disable terrain rendering

## Configuration

Configuration can be changed through **Mod Menu**.

### AFK

* Enable
* FPS
* Render Distance
* Apply Time

### Render

* Disable Particles
* Hide Dropped Items
* Hide Entities
* Disable Entity Shadows
* Hide Block Entities
* Disable Clouds
* Disable Weather
* Disable Sky
* Disable Block Damage
* Disable Block Outline
* Disable Terrain

## Installation

### Requirements

* Minecraft Java Edition 1.21.8
* Fabric Loader
* Fabric API
* YetAnotherConfigLib (YACL)
* Mod Menu (optional, for configuration)

### Install

1. Install Fabric Loader for Minecraft 1.21.8.
2. Install the required dependencies.
3. Put `AFK-PowerSave.jar` into your `mods` folder.
4. Start Minecraft.

## How It Works

When you stop providing input for the configured amount of time, AFK PowerSave enters AFK mode.

During AFK mode, selected rendering operations are disabled to reduce client rendering workload.

When you interact with the game again, the previous settings are restored.

The goal is to reduce client-side rendering load without intentionally stopping server-side gameplay or game simulation.

## Development

Built with:

* Java 21
* Fabric
* Fabric Loom
* YetAnotherConfigLib

## License

See the repository license for details.
