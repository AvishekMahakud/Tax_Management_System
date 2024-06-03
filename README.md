# Tax_Management_System

## Overview
The Tax Management System is a Spring Boot application designed to manage employee tax calculations based on predefined tax slabs. The system takes into account the employee's date of joining (DOJ) while calculating the total salary and applies additional cess for higher salary brackets.

## Key Features
- **Tax Calculation**: Automatically calculates tax based on yearly salary with different tax slabs.
- **Cess Calculation**: Applies an additional 2% cess for salaries exceeding a certain threshold.
- **Date of Joining Consideration**: Adjusts total salary calculations based on the employee's DOJ, excluding partial months.
- **REST API**: Provides a RESTful API for managing employees and their tax details.
- **Validation**: Ensures all inputs are valid and in the correct format.

## Tax Slabs
- **No Tax**: Yearly salary <= 250,000
- **5% Tax**: Yearly salary > 250,000 and <= 500,000
- **10% Tax**: Yearly salary > 500,000 and <= 1,000,000
- **20% Tax**: Yearly salary > 1,000,000

## Calculation Rules
- **Total Salary**: Calculated as `Salary * Number of months`.
- **Loss of Pay per Day**: Calculated as `Salary / 30`.
- **Cess**: An additional 2% cess for amounts exceeding 2,500,000.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.3 or higher
- H2 DB (or any relational database can be taken with some property changes)

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/Tax_Management_System.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Tax_Management_System
    ```
3. Configure the database connection in `application.properties`:
    ```properties
    spring.datasource.url=<Your DB specific url>
    spring.datasource.username=<your username>
    spring.datasource.password=<your password>
    ```
4. Build the project:
    ```sh
    mvn clean install
    ```
5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage
- **Endpoints**:
    - `POST [/tms/employee/register](http://localhost:9090/tms/employee/register)`: Register a new employee.
    - `GET [/tms/employee/calculate/tax](http://localhost:9090/tms/employee/calculate/tax)`: Calculate tax details for all employees.

## Contributing
Contributions are welcome! Please fork the repository and submit pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any questions or suggestions, feel free to reach out at avishekmahakud@gmail.com.
