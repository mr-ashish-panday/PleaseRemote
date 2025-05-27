# RemoteArmz Command Center

A modern Android application built with Kotlin and Jetpack Compose.

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.remotearmz.commandcenter/
│   │   │       ├── data/        # Data layer (repositories, data sources)
│   │   │       ├── domain/      # Domain layer (use cases, models)
│   │   │       ├── ui/          # UI layer (screens, components)
│   │   │       ├── di/          # Dependency injection modules
│   │   │       └── utils/       # Utility classes
│   │   ├── res/                # Resources
│   │   └── AndroidManifest.xml
```

## Code Style

1. **Naming Conventions**
   - Use camelCase for variables and functions
   - Use PascalCase for classes and interfaces
   - Use UPPER_SNAKE_CASE for constants
   - Use meaningful and descriptive names

2. **Kotlin Conventions**
   - Use `val` instead of `var` whenever possible
   - Use Kotlin idioms (e.g., `let`, `apply`, `with`)
   - Follow Kotlin's official style guide

3. **Architecture**
   - Clean Architecture principles
   - MVVM pattern with Jetpack Compose
   - Dependency Injection with Hilt

4. **Dependencies**
   - All dependencies are managed in `build.gradle`
   - Version numbers are aligned using BOMs where possible
   - Dependencies are grouped logically

## Development Guidelines

1. **State Management**
   - Use Jetpack Compose's StateFlow for UI state
   - Keep UI state in ViewModel
   - Use sealed classes for UI events

2. **Error Handling**
   - Use Result wrapper for API calls
   - Handle errors at the appropriate layer
   - Show user-friendly error messages

3. **Testing**
   - Write unit tests for business logic
   - Write UI tests for critical flows
   - Use MockK for mocking

## Build Configuration

- Minimum SDK: 24
- Target SDK: 34
- Java/Kotlin compatibility: 11
- Compose version: 2023.10.01

## Setup Instructions

1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Run on emulator or physical device
