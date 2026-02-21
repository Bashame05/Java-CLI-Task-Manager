# Java CLI Task Manager

## Introduction

Java CLI Task Manager is a simple command-line application for managing personal tasks. The tool allows users to add, view, update, and delete tasks directly from the terminal. This repository demonstrates core programming concepts in Java, DB interaction, object-oriented design, and CLI interaction.

## Features

- Add new tasks with a title and description.
- List all existing tasks in a readable format.
- Mark tasks as completed or pending.
- Delete tasks by specifying their ID.
- Persistent storage of tasks using a MySQL Database.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Command-line interface (Terminal, Command Prompt, etc.)

## Project Structure

The project follows a layered architecture:
```text
taskmanagerapp/
 ├── TaskManager.java      -> CLI & user interaction
 ├── Task.java             -> Model class
 ├── STATUS.java           -> Enum for task status

taskmanagerdb/
 ├── DBConnection.java     -> Database connection handler
 ├── TaskManagerDAO.java   -> Data Access Layer (CRUD operations)
 ├── schema.sql            -> Database Schema
```
## Environment Variables

Create a `.env` file in the project root:
```text
DB_URL=jdbc:mysql://localhost:3306/taskmanager
DB_USER=root
DB_PASSWORD=your_password
```
This project uses dotenv to securely load database credentials.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Bashame05/Java-CLI-Task-Manager.git
    ```

2. Change into the project directory:

    ```bash
    cd Java-CLI-Task-Manager
    ```

3. Compile the Java files:

    ```bash
    javac TaskManager.java
    ```
    
## Database Setup

1.Open MySQL

2.Run the schema.sql file:
```sql
SOURCE schema.sql;
```
## Usage

1. Run the application from the terminal:

    ```bash
    java TaskManager
    ```

2. Follow the interactive prompts to manage your tasks. Common actions include:

    - **Add Task:** Enter task title and description when prompted.
    - **List Tasks:** View all tasks with status and details.
    - **Complete/Uncomplete Task:** Change the completion status of a task.
    - **Delete Task:** Remove a task by specifying its ID.
    - **Exit:** Quit the application.

### Example Session

```text
Welcome to Java CLI Task Manager!
1. Add task
2. View tasks
3. Mark as done
5. Remove  task
6. Exit
Select an option:
```

Tasks are stored persistently in a Database, ensuring data is retained between sessions. Each operation will prompt for further details as needed.

---

This repository provides a foundational example for building more complex CLI tools in Java, suitable for educational purposes or personal use.
