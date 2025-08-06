# Nimble

Nimble is a simple note-taking Android application built with Kotlin and Jetpack Compose. The project showcases a basic Clean Architecture style setup with distinct data, domain, and presentation layers.

## Features
- Compose-based user interface with a bottom navigation bar.
- Example screens for personal, work, and reminder notes.
- Placeholder data sources demonstrating local and remote layers.

## Getting Started
1. Install [Android Studio](https://developer.android.com/studio) or ensure that the Android SDK and JDK are available.
2. Clone this repository.
3. Open the `app/android` directory in Android Studio **or** run the Gradle wrapper to build:
   ```bash
   ./gradlew assembleDebug
   ```
4. Execute tests with:
   ```bash
   ./gradlew test
   ```

## Project Structure
```
app/android/app/src
├── main
│   ├── java/com/itsniaz/nimble
│   │   ├── data           # Models, repositories and data sources
│   │   ├── di             # Dependency injection configuration
│   │   ├── ui             # Composables and navigation
│   │   ├── util           # Utility classes and constants
│   │   └── viewmodel      # ViewModel layer
│   └── res               # Android resources
```

## License
This project is provided as-is for educational purposes.
