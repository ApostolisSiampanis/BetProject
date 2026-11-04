# Bet Project

## [University of Piraeus](https://www.unipi.gr/en/home/) | [Department of Informatics](https://cs.unipi.gr/en/)
**MSc course**: Advanced Topics of Object - Oriented Programming (Java)

**Semester**: 1

**Project Completion Year**: 2025

## Description

BetProject is a Java-based console application designed to simulate the betting experience for football and basketball matches. The application enables users to place bets across various categories, offering a well-rounded sports betting platform. It includes a range of classes to manage diverse bet types, such as `Bet`, `BasketballBet`, and `FootballBet`, and employs a `GameEmulator` to generate random match results. Built with a strong focus on object-oriented programming principles, the project incorporates design patterns and leverages Java's Stream API for efficient data processing and calculations.

## Features

- Simulates betting on football and basketball matches
- Supports multiple betting categories
- Random outcome generation for matches using the GameEmulator
- Customer categories (Standard, Gold and Platinum)
- Calculates the total stake and gains of every customer
- Prints the results to the console and saves them to `bet-results.txt`
- Object-oriented design with well-defined classes and interfaces
- Uses design patterns to structure the application effectively

## Design Highlights

- **Singleton (enum):** `BetOrganization` and `GameEmulator` are implemented as enum singletons, so only one instance of each exists.
- **Sealed classes and interfaces:** `Bet` is a sealed abstract class that permits only `FootballBet` and `BasketballBet`, and `IGiveBetList` is a sealed interface that permits only `Customer`.
- **Inheritance:** `GoldCustomer` and `PlatinumCustomer` are final subclasses of `Customer`.
- **Stream API:** Used to process bets and calculate the gains of each customer.
- **Mock data:** `MockData` creates sample customers and bets to run the simulation.

## Technologies Used

- Java (with sealed classes, Java 17 or later)
- Java Stream API

## Project Structure

```
/src
    /Main
        BetMain.java            # Entry point
        BetOrganization.java    # Manages customers, bets and results (singleton)
        GameEmulator.java       # Generates random match results (singleton)
    /bet
        Bet.java                # Sealed abstract bet
        FootballBet.java
        BasketballBet.java
    /customer
        Customer.java
        CustomerBet.java
        CustomerCategory.java
        GoldCustomer.java
        PlatinumCustomer.java
        IGiveBetList.java
    /data
        MockData.java           # Sample customers and bets
/docs
    Assignment.pdf
    Documentation.pdf
```

## Setup Instructions

1. Clone the repository:

    ```bash
    git clone https://github.com/ApostolisSiampanis/BetProject.git
    cd BetProject
    ```

2. Compile and run with a JDK 17 or later:

    ```bash
    javac -d out $(find src -name "*.java")
    java -cp out Main.BetMain
    ```

    You can also open the project in IntelliJ IDEA and run `BetMain`.

## Documentation

-  Full project details can be found in the [Project Documentation](./docs/Documentation.pdf)
-  The assignment description is available in [Assignment.pdf](./docs/Assignment.pdf)

## Acknowledgments
This project was developed as part of the "Advanced Topics of Object - Oriented Programming (Java)" MSc course at the University of Piraeus. Contributions and feedback are always welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
