# Expense Reimbursement System (ERS)

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement

## Technologies Used

* Java 8
* HTML
* CSS
* JavaScript
* Javalin
* JDBC
* SQL
* RDS
* Maven
* AJAX
* Selenium
* Junit 

## Features

List of features ready and TODOs for future development
* Employees can login, logout, submit reimbursement requests, and view their submitted reimbursement requests.
* Managers can login, logout, view all reimbursement requests submitted by employees, approve/deny requests, and 
  filter requests by status.
* Users msut login before accessing any data, if the user is not logged in the application automatically redirects user to the 
  login page where the user can login. Also, the user can create an account if needed.

To-do list:
* Integrate JavaMail API to send login information to new employees.
* Use Hibenrate to implement DAO layers to improve the performance of the app when retreiving data from the database.

## Getting Started

- Clone this repository using `$ git clone https://github.com/Misael-Mendoza/Expense-Reimbursement-System.git`
- Open your local repository using Spring tool suite 4
- Run the MainDriver.java class
- Open `http://localhost:9012/html/index.html` in your browser.

## Usage

> Once the applications is running, login either with a manager account or an employee account. If you are an employee, you will be redirected to a page where you will be able to see your submitted reimbursement requests and all the details for each requests (including status, time at which it was resolved, the username of the resolver, and more). If you want to submit a new request click the "Create" button, and fill the presented form. If you logged in using a manager account, you will be redirected to a page where you will be able to see all of the requests from every employee. If you want to resolve a particular request, click on on the reimbursement, and a fill the form. Then to accept the changes click the "Accept" button. Then you can click the "Go Back" button to navigate back to the reimbursement center.
