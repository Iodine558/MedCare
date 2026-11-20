# Agent Instructions & Project Guidelines

This file contains instructions, coding conventions, and architectural guidelines for AI agents working on the MedCare Android application.

## Overview
MedCare is an Android application built with **Jetpack Compose** and **Material 3**.

## Project Structure
- `com.example.medcare`
  - `ui.patient`: Patient features & screens (`PatientHomeScreen`, `BookingScreen`, `LabResultsScreen`, `PatientProfileScreen`)
  - `ui.doctor`: Doctor features & screens (`DoctorExamScreen`, `DoctorPatientRecordsScreen`, `DoctorPrescriptionScreen`, `DoctorReportsScreen`)
  - `ui.admin`: Admin features & screens (`AdminAccountsScreen`, `AdminAuditLogScreen`, `AdminSecurityScreen`)
  - `ui.login`: Authentication & Login screens (`LoginScreen`)

## UI & Coding Guidelines
- **UI Framework:** Jetpack Compose with Material 3 (`androidx.compose.material3.*`).
- **Theming:** Prefer `MaterialTheme.colorScheme` tokens over hardcoded hex values.
- **Accessibility:** Always provide explicit, localized `contentDescription` for interactive icons and controls.
- **Interactivity:** Use `Surface` or `IconButton` for clickable icon containers to ensure proper touch target bounds and ripple effects.

---
*Add custom agent instructions and constructions below:*

