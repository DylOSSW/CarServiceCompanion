# CarServiceCompanion

**Author:** Dylan Holmwood and Kristers Martukans
**Student Number:** D21124331 and D21124318 
**Date:** 20, April 2024  
**Module:** GUI Design and Database Connectivity (COMP4604)  
**Lecturer:** Lejla Rovcanin  

## Description

This project implements a simple web application for ordering sandwiches online. Users can customize their sandwiches by selecting bread, filling, toppings, and condiments. The order details are processed using PHP and stored in a MariaDB database using SQL.

## Table of Contents
1. [Homepage (index.html)](#homepage)
2. [Order Confirmation (process_order.php)](#order-confirmation)
3. [Styles (styles.css)](#styles)
4. [Technologies Used](#technologies-used)
5. [File Structure](#file-structure)
6. [Usage](#usage)
7. [Database Setup](#database-setup)
8. [Known Issues](#known-issues)
9. [Acknowledgments](#acknowledgments)
10. [Contact Information](#contact-information)
11. [Project Status](#project-status)

## Homepage (index.html)

The `index.html` file serves as the homepage for TUD Sandwich Shop. Users can submit sandwich orders through a form. The form captures details such as customer name, choice of bread, filling, toppings, and condiments.

## Order Confirmation (process_order.php)

The `process_order.php` file handles form submissions from `index.html`. It retrieves user preferences, calculates the order total using PHP, and stores the details in a MariaDB database using an SQL statement.

## Styles (styles.css)

The `styles.css` file provides styling for HTML pages, ensuring a visually appealing and responsive design.

### Technologies Used
- HTML: Used for structuring the webpage and capturing user input.
- CSS: Responsible for styling and ensuring a user-friendly interface.
- PHP: Powers the server-side logic for processing orders.
- MariaDB: A relational database management system storing order details.
- SQL: Utilized to create and manage the database schema.

### File Structure
|-- index.html
|-- process_order.php
|-- styles.css
|-- tud_logo.png

### Database Setup
1. Create a MariaDB database named `TUD_Sandwich_Shop`.
2. Execute the SQL script in `database.sql` to set up necessary tables.
3. Use the following SQL statement to create the table and necessary fields:
   -- Table structure for the 'orders' table
   CREATE TABLE orders (
       id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255),
       bread VARCHAR(50),
       filling VARCHAR(50),
       topping VARCHAR(50),
       condiment VARCHAR(50),
       price DECIMAL(5, 2)
   );

## Usage

1. Open `index.html` in a web browser.
2. Complete the sandwich order form.
3. Submit the form to place an order.

## Known Issues

- Orders with special characters may not be processed correctly.
- Users cannot select more than one topping/condiment (option to select more should be added).
- User cannot see how much the sandwich will cost until submit the form.


## Acknowledgments

- Thanks to Lejla Rovcanin k for guidance.

## Contact Information

For questions or issues, contact D21124331@mytudublin.ie or D21124318@mytudublin.ie

## Project Status

This project is actively maintained.
