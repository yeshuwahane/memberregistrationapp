# Member Registration App

The **Member Registration App** is an Android application that allows users to register members and view their details. The app is designed using modern Android development practices, leveraging **Clean Architecture** to maintain scalability, maintainability, and testability.

<p align="center">
<img src="https://raw.githubusercontent.com/yeshuwahane/memberregistrationapp/refs/heads/main/screenshot1.png" width="250"/>
<img src="https://github.com/yeshuwahane/memberregistrationapp/blob/main/screenshot3.png" width="250"/>
<img src="https://github.com/yeshuwahane/memberregistrationapp/blob/main/screenshot2.png" width="250"/>

</p>


## 🛠 Tech Stack

### 1. **Kotlin**
   - Language used for Android development.

### 2. **Jetpack Compose**
   - For building declarative, modern UI components.

### 3. **Room Database**
   - Used for local storage to persist member data.

### 4. **Hilt (Dependency Injection)**
   - Simplifies dependency injection throughout the application.

### 5. **Coroutines & Flow**
   - For asynchronous programming and state management.

### 6. **Clean Architecture**
   - Divided into three distinct layers:
     - **Presentation Layer**: UI and ViewModels.
     - **Domain Layer**: Business logic with UseCases.
     - **Data Layer**: Repository pattern with Room for local data access.


---

## 🏗 Clean Architecture Overview

This project follows **Clean Architecture**, a design philosophy that divides the codebase into layers with clear separation of concerns:

### 1. **Presentation Layer**:
   - Contains UI components built with Jetpack Compose.
   - Uses `ViewModel`s to manage UI state and handle user interactions.

### 2. **Domain Layer**:
   - Contains the core business logic, such as `UseCases` to encapsulate specific functionality.
   - The Domain layer is independent of other layers, making it reusable and testable.

### 3. **Data Layer**:
   - Manages data sources (local database using Room).
   - Implements `Repository` interfaces defined in the Domain layer to handle data operations.

---

## 📂 Project Structure

