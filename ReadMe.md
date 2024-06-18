# Getting Started with Spring Boot on TPCF

This README file provides a structured guide for setting up, deploying, and testing a Spring Boot application on Tanzu Platform For Cloud Foundry (TPCF) using Java 17 and Gradle. It includes references to essential tools, links to resources, and instructions for both local development and cloud deployment.

## Prerequisites

- Java 17
- Gradle
- cf CLI (Tanzu Platform For Cloud Foundry Command Line Interface)
- Access to TPCF environment

## Installing Java 17 and Gradle

1. **Java 17 Installation:**
    - Download and install Java 17 from the official Oracle JDK or OpenJDK distribution.
    - Set up JAVA_HOME environment variable to point to your Java 17 installation.

2. **Gradle Installation:**
    - Download and install Gradle from https://gradle.org/install/.
    - Set up GRADLE_HOME environment variable and add Gradle's bin directory to your PATH.

## Setting up a Spring Boot Application

1. **Create a Spring Boot Project:**
    - Visit [start.spring.io](https://start.spring.io/) to generate a new Spring Boot project with dependencies:
        - Web
        - Actuator
    - Download and extract the generated project.

2. **Create a Manifest File (`manifest.yml`):**
   ```yaml
   applications:
     - name: your-app-name
       memory: 1G
       disk_quota: 1G
       buildpacks:
         - java_buildpack_offline
       path: ./app.jar
       env:
         JBP_CONFIG_OPEN_JDK_JRE: '{ jre: { version: 17.+ } }'
## Deploying to TPCF

### Step-by-Step Deployment Guide

1. **Install TPCF CLI:**

    - Download and install the TPCF CLI from [here](https://github.com/cloudfoundry/cli/releases).

2. **Build Your Application:**

    - Open a terminal and navigate to your Spring Boot project directory.

    - Build your application using Gradle:
      ```bash
      gradle build
      ```

3. **Deploy Your Application:**

    - Use the following command to push your application to TPCF:
      ```bash
      cf push
      ```

   This command uses the `manifest.yml` file in your project directory to configure the deployment settings.

4. **Accessing Your Application:**

    - After successful deployment, TPCF will assign a route to your application.

    - To find your application's route, use the command:
      ```bash
      cf apps
      ```

    - Access your application in a web browser using the assigned route (e.g., `http://your-app-name.cfapps.io`).

### Example Manifest File (`manifest.yml`)

```yaml
applications:
  - name: your-app-name
    memory: 1G
    disk_quota: 1G
    buildpacks:
      - java_buildpack_offline
    path: ./app.jar
    env:
      JBP_CONFIG_OPEN_JDK_JRE: '{ jre: { version: 17.+ } }'
