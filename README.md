# Household Energy Tracker

A simple Java console application developed as an Object-Oriented Programming coursework project.

## About

Household Energy Tracker is a small console-based application for managing household appliances and tracking their energy usage.

The project was created primarily to practise and understand fundamental Object-Oriented Programming (OOP) concepts in Java. It is not intended to be a production-ready energy monitoring system.

The application does not use a database or external storage. Data is kept in memory while the program is running, and the application can be used as a simple energy-usage calculator.

## Features

- Add and manage household appliances
- Support different types of appliances
- Record energy usage
- Calculate energy consumption
- Generate basic household energy summaries
- Remove appliances
- Store data temporarily in memory
- Console-based interaction

## OOP Concepts Demonstrated

This project focuses on applying common OOP principles, including:

- **Classes and Objects**
- **Encapsulation**
- **Inheritance**
- **Polymorphism**
- **Abstraction**
- **Composition**
- **Collections**

## Project Structure

The project contains classes representing different parts of the household energy system, such as:

- `Appliance` – Base representation of an appliance
- `CoolingAppliance` – Represents cooling-related appliances
- `LightAppliance` – Represents lighting appliances
- `EnergyUsageRecord` – Stores energy usage information
- `Household` – Manages appliances and energy records
- `HETMain` – Main entry point for the console application

## Technologies

- Java
- Java Collections Framework
- Console input/output

## Data Storage

This application **does not use a database**.

All appliance and energy usage information is stored temporarily in memory and is lost when the application exits.

## Purpose

This project was created as coursework to gain practical experience with Java and Object-Oriented Programming concepts.

It is intentionally kept simple and focuses more on demonstrating OOP design and implementation than on building a complete real-world energy management system.

## How to Run

1. Clone the repository.
2. Open the project in a Java IDE such as IntelliJ IDEA, Eclipse, or VS Code.
3. Make sure Java is installed and configured.
4. Run `HETMain.java`.
5. Follow the instructions displayed in the console.

## Future Improvements

Possible future improvements include:

- Saving data to files
- Adding a database
- Creating a graphical user interface
- Adding more appliance types
- Adding electricity cost calculations
- Generating more detailed energy reports
- Adding unit tests

## Project Status

This is a **coursework/learning project** created to practise Object-Oriented Programming in Java.
