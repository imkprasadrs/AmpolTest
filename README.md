# Ampol Test

**Table of Contents**

- [Technology stack](#technology-stack)
- [Architecture](#architecture)
- [Design patterns](#design-patterns)
- [Installation](#installation)
- [Testing](#testing)
- [Note](#note)

## Technology Stack
The following are the tech stack used for this project:
- Jetpack Compose ( Showing UI)
- Kotlin
- Retrofit & Gson (Networking)
- Junit & Mockk( Unit testing)
- Hilt ( Dependency Injection)

## Architecture
Ampol app is structured in a mix of clean architecture and MVVM pattern.

The whole project is clearly separated in layers - Presentation, Business logic and Data layer.

## Design Patterns

This app make use of the following patterns:
 - Dependency Inversion pattern which helps to avoid coupling
 - MVVM is used in UI layer with the help of Jetpack compose

## Installation
- 
All the dependencies are managed using buildSrc.
The project is Gradle based, and so all the dependencies are defined in .gradle file with the help of buildSrc.


## Testing
Unit testing part is not added due to lack of time.

## Note
Due to lack of time, I couldn't able to implement all the features
- pending:
  1:List all recent transactions
  2:Unit test

It tool me around 3-4hrs for adding this features including debugging