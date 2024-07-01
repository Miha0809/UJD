USERNAME=adminpg
PASSWORD=example

# Lab 1
Basic SQL query in the PostgreSQL

## Tasks


### Basic select queries on the DB
1. Find all information about all books
2. Find id and title of all books
3. Find titles of all books, but returns them as list of names (instead of titles)
4. Find all the books that was published after 2003
5. Find all the books that was published after 2000 but before 2004
6. Find all order lines. Join theirs information with books details.
7. Calculate total number of customers
8. For each book, calculate how much books was sold. Display book id and total count of books sold.
9. Calculate spendings for each customer. Display Customer name (first and last) and total price payed for all purchases.
10. For each book show countries where it was seled. Display book title, author name, country name and total number of sales. Sort descending based on total sales. 

### Creating/updating/deleting resources (additional)
Lets create "students" database. We must store:
- department
  - id
  - name
- information about student
  - id
  - first name
  - last name
  - department id (connected to the department)

1. Create new database. use this database for next steps
2. Create new table for departments
3. Create new table for student
4. Create 2-3 departments
5. create 2-3 student and assign department for them
6. Create view wich will ilustrate how much student are assigned to the department at the moment
7. Create index for the student name, so searching students by last name or first name will be fast
