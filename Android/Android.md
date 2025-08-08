# Study Bro Android Port Plan

This document outlines the high-level steps required to port the iOS "Study Bro" app to an Android application built with Kotlin and Jetpack Compose.

## 1. Project Setup
- Create a Kotlin/Jetpack Compose project.
- Add `google-services.json` and apply the `com.google.gms.google-services` plugin.
- Include Firebase dependencies: Authentication, Firestore, Storage, and Messaging.

## 2. Data Models
- Translate each Swift struct in `IOS/Study Bro/Models` to Kotlin `data class` files.
- Mirror all fields, default values, and Firestore document mappings.
- Verify Firebase serialization with `@PropertyName` and nullable types.

## 3. Repositories and Managers
- **AuthService**: Wrap FirebaseAuth, Google sign-in, and Apple sign-in alternatives.
- **UserManager**: Manage user profiles, avatar uploads (Firebase Storage), FCM token updates, and streak calculations.
- **NotesManager**, **TaskManager**, **StudySetManager**: CRUD operations with Firestore collections.
- **GamificationManager**: Combine Firestore with local storage (DataStore/SharedPreferences) for XP, gems, hearts, achievements, and friends.
- **NotificationManager**: FCM registration, notification channels, and local notifications.
- **GoogleManager**, **StorageManager**, **TextManager**: Token handling, file uploads, and text utilities.

## 4. ViewModels
- Convert SwiftUI ViewModels into Android ViewModels using Kotlin coroutines and `StateFlow`.
- Example: `ChatBotViewModel` performs HTTP requests to the HuggingFace endpoint and streams responses to the UI.
- Ensure each ViewModel is lifecycle-aware and exposes immutable state flows.

## 5. Jetpack Compose UI
- Authentication screens: Sign Up, Log In, and Apple/Google buttons.
- Main tabs: Home, Study Session, Tasks, Learn (notes/flashcards), Chatbot, Account.
- Supporting screens: Calendar, Gamification, Stats, Social (friends/notifications), Settings.
- Configure navigation using Jetpack Navigation components.

## 6. Study Session & Pomodoro Timer
- Implement a ViewModel for timer logic (start/pause/resume, meditation sequences).
- Use WorkManager or foreground services to keep timers active in the background.
- Integrate local notifications for session end or break reminders.

## 7. Persistence & Preferences
- Choose DataStore or SharedPreferences for app settings (dark mode, welcome screens, etc.).
- Store local gamification stats and sync periodically with Firestore.

## 8. Notifications
- Register FCM token and subscribe to topics or friend channels.
- Use Android's `NotificationManager` for local alerts.
- Mirror relevant logic from the iOS `NotificationManager`.

## 9. App Theme
- Convert the color palette defined in `Utilities/AppTheme.swift` to a Compose `MaterialTheme`.
- Define typography and shapes to match the iOS styling.

## 10. Testing & Release
- Add unit tests for repositories and ViewModels (JUnit + coroutines test libraries).
- Add UI tests using `ComposeTestRule`.
- Configure signing (debug/release), versioning, and build flavors.

---

This plan serves as a checklist for converting the existing iOS implementation into a fully functional Android app.
