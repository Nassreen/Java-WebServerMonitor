# Web Server Availability Monitor Readme

The Web Server Availability Monitor is a Java console application designed to ensure the continuous accessibility of a specified URL. This utility periodically checks the availability of the designated URL and meticulously logs the results in a local file


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

In crucial web server setups, continuous accessibility is essential. The Web Server Availability Monitor offers a primitive solution by assessing the accessibility of a specified URL and maintains a simple log to facilitate ongoing monitoring, which could be enhanced and improved in the upcoming MVP upgrade.

## Features

- **Automatic Monitoring**: The application automatically initiates availability checks at regular intervals Every 30 seconds.
- **Comprehensive Logging**: Availability results are meticulously logged in the `availability_log.txt` file, enabling in-depth analysis.

- **Termination Control**: The user can halt the monitoring process at any time by pressing Enter key.


## Getting Started

### Installation

Before you begin, make sure to have the following software installed:

- [Git](https://git-scm.com/downloads)
- [IntelliJ IDEA](https://www.jetbrains.com/help/idea/installation-guide.html) or another IDE  "Integrated Development Environment."
- [Java](https://www.oracle.com/java/technologies/downloads/)

#### Git Configuration

After installing Git, ensure that:
- Environment variables are set.
- Git BASH is installed.
- Git is integrated into the shell (context menu).
- Configure your user information using the following commands:

             git config --global user.name "Max Mustermann"
             git config --global user.email m.musterman@muster.de



### Repository

This is the repository for the project:
[Java-WebServerMonitor] (https://github.com/Nassreen/Java-WebServerMonitor.git).

## Usage

1. Start the application and provide a URL to a specific HTML page followed by Enter.
2. The application will automatically check the URL availability every 30 seconds and log the results in the `availability_log.txt` file.
3. The program will display the monitoring message, and you can press any key to stop the program.

## Contributing

This project welcomes contributions. Feel free to fork the repository, make your enhancements, and create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
