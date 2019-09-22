10 Exercises: Introduction to Hibernate
=======================================

---
---

This document defines the exercise assignments for the [“Databases Frameworks”
course \@
SoftUni](https://softuni.bg/trainings/1635/databases-frameworks-hibernate-and-spring-data-june-2017).

---

1 Setup
-------

Use the **provided skeleton** to create **soft_uni** database.

1.  Change the **port**, **username** and **password** accordingly to your
    settings.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65393061-af6ba600-dd84-11e9-8939-7345febe0c39.png" alt="alt text" width="800" height=""></kbd>

1.  **Create** EntityManagerFactory and **run** your program.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65393063-b1ce0000-dd84-11e9-86df-2c39596af2dd.png" alt="alt text" width="800" height=""></kbd>

1.  Fill the database into Workbench by **executing** the provided **.sql**
    script.

2 Remove Objects
----------------

Use the **soft_uni** database. Persist **all towns** from the database. Detach
those whose name length is **more than 5 symbols**. Then transform the **names**
of all attached towns **to lowercase** and **save them to the database**.

3 Contains Employee
-------------------

Use the **soft_uni** database. Write a program that checks if a given employee
name **is contained in the database.**

### Example

| **Input**     | **Output** |
|---------------|------------|
| Svetlin Nakov | Yes        |
| John Doe      | No         |

4 Employees with Salary Over 50 000
-----------------------------------

Write a program that gets the first name of all employees who have salary over
**50 000**.

### Example:

| **Output**                   |
|------------------------------|
| Terri <br/> Jean <br/> Ken … |

5 Employees from Department
---------------------------

Extract all employees from the **Research and Development** department. Order
them by **salary** (in ascending order), then by **id** (in asc order). Print
only their **first name**, **last name**, **department name** and **salary**.

### Example:

| **Output**                                                                                                                                                                                                                                                                                                                                                                                                                                         |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Diane Margheim from Research and Development - \$40900.00 <br/> Gigi Matthew from Research and Development - \$40900.00 <br/> Michael Raheem from Research and Development - \$42500.00 <br/> Svetlin Nakov from Research and Development - \$48000.00 <br/> Martin Kulov from Research and Development - \$48000.00 <br/> George Denchev from Research and Development - \$48000.00 <br/> Dylan Miller from Research and Development - \$50500.00 |

6 Adding a New Address and Updating Employee
--------------------------------------------

Create a new address with **text** "**Vitoshka 15**". Set that address to an
**employee** with a **last name**, given as an input.

7 Addresses with Employee Count
-------------------------------

Find all addresses, **ordered** by the **number of employees** who live there
(**descending**), then by **town id** (**ascending**). Take only the **first 10
addresses** and print their **address text**, **town name** and **employee
count**.

### Example

| **Output**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 163 Nishava Str, ent A, apt. 1, Sofia - 3 employees <br/> 7726 Driftwood Drive, Monroe - 2 employees <br/> 2427 Notre Dame Ave., Redmond - 1 employees <br/> 3066 Wallace Dr., Redmond - 1 employees <br/> 101 Candy Rd., Redmond - 1 employees <br/> 2482 Buckingham Dr., Redmond - 1 employees <br/> 3768 Door Way, Redmond - 1 employees <br/> 1275 West Street, Redmond - 1 employees <br/> 3397 Rancho View Drive, Redmond - 1 employees <br/> 2383 Pepper Drive, Redmond - 1 employees |

8 Get Employee with Project
---------------------------

Get an **employee by his/her id**. Print only his/her **first name**, **last
name**, **job title** and **projects** (only their names). The projects should
be **ordered by name** (ascending). The output should be printed in the format
given in the example.

### Example

<img src="https://user-images.githubusercontent.com/32310938/65393120-8dbeee80-dd85-11e9-8572-95eb5396f91c.png" alt="alt text" width="500" height="">

9 Find Latest 10 Projects
-------------------------

Write a program that prints the **last 10 started projects**. Print **their
name, description, start and end date** and **sort them by name**
lexicographically. For the output, check the format from the example.

### Example

<img src="https://user-images.githubusercontent.com/32310938/65393131-a0d1be80-dd85-11e9-933e-1134e691cf4b.png" alt="alt text" width="600" height="">

10 Increase Salaries
--------------------

Write a program that increases the salaries of all employees, who are in the
**Engineering**, **Tool Design**, **Marketing** or **Information Services**
departments by **12%**. Then **print the first name, the last name and the
salary** for the employees, whose salary was increased.

### Example

| **Output**                                                                                                                          |
|-------------------------------------------------------------------------------------------------------------------------------------|
| Kevin Brown (\$15120.00) <br/> Rob Walters (\$33376.00) <br/> Thierry D'Hers (\$28000.00) <br/> Ashvini Sharma (\$36400.00) <br/> … |

11 Remove Towns
---------------

Write a program that **deletes a town**, which name is given as an input. The
program should **delete all addresses** that are in the given town. Print on the
console the **number of addresses** that were **deleted**. Check the example for
the output format.

### Example

| **Input** | **Output**                      |
|-----------|---------------------------------|
| Sofia     | 1 address in Sofia deleted      |
| Seattle   | 44 addresses in Seattle deleted |

12 Find Employees by First Name
-------------------------------

Write a program that finds **all employees**, whose **first name starts with a
pattern** given as an input from the console. Print their **first and last
names**, their **job title** and **salary** in the format given in the example
below.

### Example

| **Input** | **Output**                                                                                                                                                                                                                                                                                                                                                                     |
|-----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| SA        | Sariya Harnpadoungsataya - Marketing Specialist - (\$14400.00) <br/> Sandra Reategui Alayo - Production Technician - (\$9500.00) <br/> Sairaj Uddin - Scheduling Assistant - (\$16000.00) <br/> Samantha Smith - Production Technician - (\$14000.00) <br/> Sameer Tejani - Production Technician - (\$11000.00) <br/> Sandeep Kaliyath - Production Technician - (\$15000.00) |

13 Employees Maximum Salaries
-----------------------------

Write a program that finds the **max salary** for each **department**. Filter
the departments, which max salaries **are not in the range** between 30000 and
70000.

### Example

| **Output**                                      |
|-------------------------------------------------|
| Tool Design - 29800.00 <br/> Sales - 72100.00 … |

<br/>

### Solution: <a title="Exercises: Introduction to Hibernate" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/10%20EXERCISE%20INTRODUCTION%20TO%20HIBERNATE/IntroductionToHibernate/src/main">Exercises: Introduction to Hibernate</a>

---