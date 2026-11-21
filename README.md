# MedCare

<p align="center">
  <strong>A modern Android healthcare management interface for patients, doctors, and administrators.</strong>
</p>

<p align="center">
  <a href="#overview">Overview</a> •
  <a href="#features">Features</a> •
  <a href="#technology">Technology</a> •
  <a href="#getting-started">Getting started</a>
</p>

## Overview

MedCare is an Android application for managing healthcare workflows and electronic medical record experiences. It provides role-based interfaces for patients, doctors, and administrators, with a responsive UI built using Kotlin and Jetpack Compose.

The current repository focuses on the application experience and navigation flows. Authentication, external health-system integrations, and persistent backend data are represented by prototype UI behavior and can be connected to production services as the project evolves.

## Features

### Patient experience

- Patient home dashboard
- Appointment booking flow
- Laboratory and clinical test results
- Personal profile and account actions
- In-app healthcare assistant entry point

### Doctor workspace

- Patient record access
- Examination workflow
- Prescription and clinical service workflow
- Reports and schedule views
- Doctor profile and session management

### Administrator workspace

- Account management
- Audit log views
- Security controls
- Administrator profile and session management

### Shared experience

- Role-aware login screen
- Material 3 navigation and components
- Light and dark theme resources
- Responsive Compose layouts
- Accessibility-conscious interactive controls

## Technology

- **Language:** Kotlin
- **Platform:** Android
- **UI:** Jetpack Compose
- **Design system:** Material 3
- **Build system:** Gradle with Kotlin DSL
- **Minimum Android version:** API 24
- **Compile and target SDK:** API 37
- **Testing:** JUnit and AndroidX instrumentation tests

## Project structure

```text
app/src/main/java/com/example/medcare/
├── ui/
│   ├── admin/       # Administrator screens and navigation
│   ├── doctor/      # Doctor screens and navigation
│   ├── login/       # Authentication interface
│   ├── patient/     # Patient screens and navigation
│   └── theme/       # Compose theme and typography
└── MainActivity.kt  # Application entry point
```

## Getting started

### Requirements

- Android Studio with Android SDK support
- JDK 11 or later
- Android SDK platform 37

### Build and run

1. Clone the repository:

   ```bash
   git clone https://github.com/Iodine558/MedCare.git
   cd MedCare
   ```

2. Open the project in Android Studio and allow Gradle to sync.

3. Run the `app` configuration on an emulator or Android device running API 24 or higher.

You can also build the debug APK from the command line:

```bash
./gradlew assembleDebug
```

## Testing

Run the unit tests with:

```bash
./gradlew test
```

Run instrumented tests on a connected device or emulator with:

```bash
./gradlew connectedAndroidTest
```

## License

MedCare is distributed under the [MIT License](LICENSE).
