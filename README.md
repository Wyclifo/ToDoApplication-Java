
# ToDoApplication

A Java desktop application built with Java Swing for creating, managing, and viewing ToDo tasks. The project uses a data-access layer to support different storage implementations, including SQL database and text-file storage.

## Features

- **Create ToDo Tasks** — Enter a task name, description, start time, and end time.
- **Date and Time Handling** — Parse task dates using the `dd/MM/yyyy HH:mm` format.
- **Task Listing** — Display saved tasks in a list.
- **Task Viewing** — Select a task to view its details.
- **Multiple Data Sources** — Configure SQL and text-file connectors through a centralized configuration class.
- **Error Handling** — Handle data-source failures so one connector failure does not necessarily prevent the application from continuing.
- **Swing GUI** — Desktop user interface developed using Java Swing.

## Technologies Used

- Java (Java 23 project configuration)
- Java Swing
- Apache NetBeans IDE
- JDBC / SQL database integration
- Text-file storage
- Git and GitHub

## Project Structure

```text
ToDoApplication/
├── src/
│   └── com/
│       └── mycompany/
│           └── todoapplication/
│               ├── DataAccess/
│               │   ├── GlobalConfig.java
│               │   ├── IDataConnection.java
│               │   ├── SqlConnector.java
│               │   └── TextConnector.java
                    └── TextConnectorProcessor.java
│               ├── TodoApplicationUI/
│               │   └── CreateToDoForm.java

│               ├── ToDo.java
│               └── ToDoApplication.java
├── README.md
└── pom.xml
```

*Note: The exact project structure may vary depending on the files and build configuration in your local project and the project lifecycle aditing and modification.*

## Requirements

- Java Development Kit (JDK) compatible with the project's configured Java release.
- Apache NetBeans IDE or another Java IDE.
- A configured SQL database if SQL storage is enabled.
- Git for version control.

## Getting Started

### 1. Clone the Repository

Replace `YOUR-USERNAME` with your GitHub username.

```bash
git clone https://github.com/Wyclifo/ToDoApplication-Java
```

### 2. Open in NetBeans

1. Launch Apache NetBeans.
2. Select **File → Open Project**.
3. Select the cloned `ToDoApplication` project.
4. Wait for NetBeans to resolve the project dependencies.

### 3. Configure Data Storage

The application initializes its configured data sources in `GlobalConfig.java`.

Review the database connection settings in `SqlConnector.java` before enabling SQL storage. Ensure the database server, database name, credentials, and required JDBC driver are configured correctly.

Text-file storage also requires a valid file path and appropriate read/write permissions.

### 4. Run the Application

Open `ToDoApplication.java` and run the project from NetBeans. The application's entry point initializes the configured data sources and opens the ToDo form.

## Date and Time Format

Enter task start and end times using the following format:

```text
dd/MM/yyyy HH:mm
```

Example:

```text
25/10/2026 14:30
```

## Data Access Design

The project separates the user interface from data storage using a data-access layer.

- `IDataConnection.java` defines the operations supported by data connectors.
- `SqlConnector.java` handles SQL-related persistence operations.
- `TextConnector.java` handles text-file persistence operations.
- `GlobalConfig.java` manages the configured connectors.
- `CreateToDoForm.java` provides the user interface for entering and viewing tasks.

The actual storage behavior depends on the implementation and configuration of each connector.

## Error Handling and Limitations

The application should handle failures from individual data sources without terminating unexpectedly. However, each connector must implement its operations correctly.

SQL persistence requires a completed implementation of the relevant database methods. If any SQL methods remain unimplemented, SQL saving or reading may fail until those methods are completed.

## Future Improvements

- Complete SQL database read and write operations.
- Improve database connection management.
- Add task editing and deletion.
- Add task completion status and priority.
- Improve input validation and date/time validation.
- Add unit and integration tests.
- Improve the user interface and usability.
- Add automated builds and testing.

## Version Control

To commit and push changes to GitHub:

```bash
git add .
git commit -m "Update ToDo application"
git push
```

## License

No license has been specified yet. Add a suitable license before distributing or reusing the project publicly.
