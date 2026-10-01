# Task Tracker

Task Tracker is an Android application built with Kotlin that helps users organize and manage tasks based on deadlines, estimated completion time, urgency, and additional task details.

The application uses **Room/SQLite** for persistent local storage and follows Android architecture patterns using **ViewModel and LiveData** to manage application state and keep the UI synchronized with stored data.

## Features

* Create tasks with:

  * Task name
  * Due date
  * Estimated completion time
  * People involved
  * Location
  * Notes
  * Urgency status
* Persistent local storage using Room and SQLite
* Task prioritization by urgency
* Task detail view
* Mark tasks as completed
* Calculate total estimated hours across tasks
* Reactive UI updates using LiveData
* Navigation between application screens
* Automated Android instrumentation tests

## Application Workflow

### Task Dashboard

The home screen displays the user's tasks in a scrollable list and shows the total estimated hours required to complete them.

Tasks are automatically organized by urgency so higher-priority tasks can be identified quickly.

### Create a Task

Users can create a task and provide information including:

* Task name
* Due date
* Estimated hours
* People involved
* Location
* Notes
* Urgency

### View Task Details

Selecting a task opens a detailed view containing its stored information. Users can mark tasks as completed from the task detail screen.

## Architecture

The application separates the UI, application state, and database access using Android architecture components.

```text
UI Fragments
     │
     ▼
TasksDataViewModel
     │
     ▼
TaskInfoDao
     │
     ▼
Room Database
     │
     ▼
SQLite
```

### Key Components

#### Fragments

* `HomeFragment` — Displays the task list and total estimated hours
* `AddTaskFragment` — Handles task creation and input validation
* `ViewTaskFragment` — Displays task details and handles task completion
* `SettingsFragment` — Application settings
* `HelpFragment` — Application help information

#### ViewModel

`TasksDataViewModel` manages task-related application state and coordinates database operations.

It uses Android lifecycle-aware components to keep UI data synchronized with the underlying database.

#### Database Layer

* `TaskDatabase` — Provides the Room database instance
* `TaskInfoDao` — Defines database operations for inserting, updating, deleting, retrieving, and sorting task records
* `Task` — Represents the database entity stored in the `tasks` table

#### UI Components

* RecyclerView for displaying task records
* View Binding and Data Binding for connecting UI components to application logic
* Android Navigation Component for screen navigation

## Database

Task Tracker uses the **Room Persistence Library** on top of SQLite for local data persistence.

Each task contains the following information:

| Field      | Description                     |
| ---------- | ------------------------------- |
| `taskId`   | Auto-generated task identifier  |
| `taskName` | Name of the task                |
| `dueDate`  | Task deadline                   |
| `hours`    | Estimated completion time       |
| `people`   | People associated with the task |
| `location` | Task location                   |
| `notes`    | Additional task information     |
| `urgency`  | Task urgency status             |

The DAO provides operations for:

* Inserting tasks
* Updating tasks
* Deleting tasks
* Retrieving all tasks
* Retrieving individual tasks
* Sorting tasks by urgency
* Calculating total estimated hours
* Deleting all tasks

## Testing

The project includes Android instrumentation tests using **JUnit, Espresso, and Room's in-memory database**.

### Database Tests

`TaskDaoTest` verifies database functionality including:

* Inserting task records
* Retrieving stored tasks
* Persisting and retrieving multiple task records

### UI Tests

`RecycleTest` verifies application behavior including:

* Home screen visibility
* RecyclerView rendering
* Selecting a task
* Navigating to the task detail screen
* Returning to the task list

The project also uses an Espresso `IdlingResource` to coordinate asynchronous test execution.

## Tech Stack

| Category     | Technologies                           |
| ------------ | -------------------------------------- |
| Language     | Kotlin                                 |
| Platform     | Android                                |
| IDE          | Android Studio                         |
| Database     | SQLite, Room                           |
| Architecture | ViewModel, LiveData, Flow              |
| UI           | XML, RecyclerView, Material Components |
| Navigation   | Android Navigation Component           |
| Testing      | JUnit, Espresso                        |
| Build System | Gradle, Kotlin DSL                     |
| Minimum SDK  | API 34                                 |
| Target SDK   | API 34                                 |

## Project Structure

```text
Task-Tracker/
├── app/
│   └── src/
│       ├── androidTest/
│       │   └── ...                 # Instrumentation and UI tests
│       │
│       ├── main/
│       │   ├── java/
│       │   │   └── .../
│       │   │       ├── AddTaskFragment.kt
│       │   │       ├── HomeFragment.kt
│       │   │       ├── MainActivity.kt
│       │   │       ├── Task.kt
│       │   │       ├── TaskDatabase.kt
│       │   │       ├── TaskInfoDao.kt
│       │   │       ├── TasksDataViewModel.kt
│       │   │       ├── ViewTaskFragment.kt
│       │   │       └── RecycleAdatper.kt
│       │   │
│       │   │   └── res/
│       │   │       ├── layout/
│       │   │       ├── navigation/
│       │   │       └── values/
│       │   │
│       │   └── test/
│       │       └── ...
│       │
│       ├── build.gradle.kts
│       └── proguard-rules.pro
│
└── README.md
```

## Getting Started

### Prerequisites

* Android Studio
* Android SDK 34
* Android device or emulator running API 34 or later

### Clone the Repository

```bash
git clone https://github.com/omarf72/Task-Tracker.git
cd Task-Tracker
```

### Run the Application

1. Open the project in Android Studio.
2. Allow Gradle to synchronize the project.
3. Start an Android API 34+ emulator or connect an Android device.
4. Build and run the application.

### Run Tests

Run instrumentation tests from Android Studio or use Gradle:

```bash
./gradlew connectedAndroidTest
```

## Development Highlights

This project provided experience developing an Android application from the UI layer through persistent data storage.

Key areas of development included:

* Designing a relational data model for task records
* Implementing CRUD operations through a Room DAO
* Managing application state with ViewModel and LiveData
* Using Kotlin for Android application development
* Building dynamic task lists with RecyclerView
* Implementing navigation between application screens
* Validating user input before storing task records
* Debugging application and database behavior
* Writing instrumentation tests for database and UI functionality



