# Java CLI Task Manager

## Introduction

Java CLI Task Manager is a simple command-line application for managing personal tasks. The tool allows users to add, view, update, and delete tasks directly from the terminal. This repository demonstrates core programming concepts in Java, such as file I/O, object-oriented design, and CLI interaction.

## Features

- Add new tasks with a title and description.
- List all existing tasks in a readable format.
- Mark tasks as completed or pending.
- Update the content of existing tasks.
- Delete tasks by specifying their ID.
- Persistent storage of tasks using a MySQL Database.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Command-line interface (Terminal, Command Prompt, etc.)

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

## Usage

1. Run the application from the terminal:

    ```bash
    java TaskManager
    ```

2. Follow the interactive prompts to manage your tasks. Common actions include:

    - **Add Task:** Enter task title and description when prompted.
    - **List Tasks:** View all tasks with status and details.
    - **Update Task:** Select a task by ID and provide new details.
    - **Complete/Uncomplete Task:** Change the completion status of a task.
    - **Delete Task:** Remove a task by specifying its ID.
    - **Exit:** Quit the application.

### Example Session

```text
Welcome to Java CLI Task Manager!
1. Add task
2. List tasks
3. Update task
4. Complete task
5. Delete task
6. Exit
Select an option:
```

Tasks are stored persistently in a Database, ensuring data is retained between sessions. Each operation will prompt for further details as needed.

---

This repository provides a foundational example for building more complex CLI tools in Java, suitable for educational purposes or personal use.
