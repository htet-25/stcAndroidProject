# STC Android Project

This is a mobile Android application developed for **Save the Children** (STC) to assist with data collection, form submissions, and field-level data management. The app is built using **Java** for Android and follows standard Android development practices.

## 🎯 Project Objective

To provide an offline-capable, user-friendly mobile application for field staff to input, view, and manage data related to STC program activities such as child health monitoring or community outreach.

## 📱 Features

- Dynamic form inputs with validation
- Multiple data entry screens
- Local data storage using SQLite
- Simple navigation between input and review screens
- Custom styling and localization support
- Form-based data saving and resetting
- Logging and simple debug features for testing

## 🛠 Tech Stack

- **Java** – Android application logic
- **Android SDK** – Native development
- **SQLite** – Local data storage
- **XML** – Layout and UI components
- **Android Studio** – Recommended IDE

## 📁 Project Structure
stcAndroidProject/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/stc/
│           │       ├── MainActivity.java
│           │       ├── FormActivity.java
│           │       └── DBHelper.java
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml
│               │   └── activity_form.xml
│               └── values/
│                   └── strings.xml
└── README.md

## 🚀 How to Run

### Prerequisites

- Android Studio installed
- Android Emulator or physical device (API 21+ recommended)

### Steps

1. Clone the repository:

```bash
git clone https://github.com/htet-25/stcAndroidProject.git
	2.	Open the project in Android Studio
	3.	Sync Gradle (if needed) and build the project
	4.	Run the app on an emulator or connected device

Ensure the app has the following permissions (declared in AndroidManifest.xml):
	•	INTERNET
	•	WRITE_EXTERNAL_STORAGE (if required for data export)
🔧 Future Enhancements
	•	REST API integration for remote sync
	•	User login and authentication
	•	Multi-language support
	•	Cloud backup
	•	UI improvements with Jetpack Compose
👤 Author

Htet Aung Naing
📍 Toronto, Canada
📧 hanmaple92@gmail.com
[🔗 GitHub Profile](https://github.com/htet-25)
