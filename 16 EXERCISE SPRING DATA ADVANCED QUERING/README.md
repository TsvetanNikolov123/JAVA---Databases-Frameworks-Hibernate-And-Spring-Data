16 Exercises: Spring Data Advanced Quering
==========================================

---
---

This document defines the exercise assignments for the [“Databases Frameworks”
course \@ SoftUni](https://softuni.bg/courses/databases-advanced-hibernate).

For the following tasks use the **bookshop_system** database from the previous
exercise. Make sure it has proper connections between the tables and it is
populated with any sample data.

---

16.01 Books Titles by Age Restriction
-------------------------------------

Write a program that prints **the titles of all books**, for which the **age
restriction** matches the given input (minor, teen or adult). **Ignore casing**
of the input.

### Example

| **Input** | **Output**                                                                      |
|-----------|---------------------------------------------------------------------------------|
| miNor     | A che punto Ã¨ la note <br/> After Many a Summer Dies the Swan <br/> Ah <br/> … |
| teEN      | All Passion Spent <br/> Wide Sea <br/> Antic Hay <br/> …                        |

16.02 Golden Books
------------------

Write a program that prints **the titles of the golden edition books**, which
have **less than 5000 copies**.

### Example

| **Output**                                                                                 |
|--------------------------------------------------------------------------------------------|
| Behold the Man <br/> Bury My Heart at Wounded Knee <br/> The Cricket on the Hearth <br/> … |

16.03 Books by Price
--------------------

Write a program that prints **the titles and prices of books** with **price
lower than 5** and **higher than 40**.

### Example

| **Output**                                                                                                                                         |
|----------------------------------------------------------------------------------------------------------------------------------------------------|
| A che punto Ã¨ la note - \$45.78 <br/> All the King's Men - \$45.60 <br/> An Evil Cradling - \$3.30 <br/> Beyond the Mexique Bay - \$45.45 <br/> … |

16.04 Not Released Books
------------------------

Write a program that prints **the titles** of all books that are **NOT
released** in a given year.

### Example

| **Input** | **Output**                                                                           |
|-----------|--------------------------------------------------------------------------------------|
| 2000      | Absalom <br/> A che punto Ã¨ la note <br/> After Many a Summer Dies the Swan <br/> … |
| 1998      | A che punto Ã¨ la note <br/> Ah <br/> Wilderness! <br/> …                            |

16.05 Books Released Before Date
--------------------------------

Write a program that prints **the title, the edition type and the price** of
books, which are **released before a given date**. The date will be in the
**format dd-MM-yyyy**.

### Example

| **Input**  | **Output**                                                                                                              |
|------------|-------------------------------------------------------------------------------------------------------------------------|
| 12-04-1992 | All Passion Spent <br/> Bury My Heart at Wounded Knee <br/> A Catskill Eagle <br/> …                                    |
| 30-12-1989 | Bury My Heart at Wounded Knee <br/> Consider the Lilies <br/> The Curious Incident of the Dog in the Night-Time <br/> … |

16.06 Authors Search
--------------------

Write a program that prints **the names** of those authors, whose **first name
ends with a given string**.

### Example

| **Input** | **Output**                                                    |
|-----------|---------------------------------------------------------------|
| e         | George Powell <br/> Jane Ortiz <br/> Julie Washington <br/> … |
| dy        | Randy Morales <br/> Randy Graham                              |

16.07 Books Search
------------------

Write a program that prints **the titles of books**, which **contain a given
string** (regardless of the casing).

### Example

| **Input** | **Output**                                                               |
|-----------|--------------------------------------------------------------------------|
| sK        | A Catskill Eagle <br/> The Daffodil Sky <br/> The Skull Beneath the Skin |
| WOR       | Great Work of Time <br/> Terrible Swift Sword                            |

16.08 Book Titles Search
------------------------

Write a program that prints **the titles of books**, which are **written by
authors**, whose **last name starts with a given string**.

### Example

| **Input** | **Output**                                                                                                                                      |
|-----------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| R         | A Time of Gifts (Amanda Rice) <br/> To Sail Beyond the Sunset (Amanda Rice) <br/> To Say Nothing of the Dog (Amanda Rice)                       |
| gr        | What's Become of Waring (Randy Graham) <br/> Vanity Fair (Randy Graham) <br/> Dominations (Chris Graham) <br/> Eyeless in Gaza (Brenda Griffin) |

16.09 Count Books
-----------------

Write a program that prints **the number of books**, whose **title is longer
than a given number**.

### Example

| **Input** | **Output** | **Comments**                                          |
|-----------|------------|-------------------------------------------------------|
| 12        | 178        | There are 178 books with longer title than 12 symbols |
| 40        | 2          | There are 2 books with longer title than 40 symbols   |

16.10 Total Book Copies
-----------------------

Write a program that prints **the total number of book copies by author**. Order
the results **descending by total book copies**.

### Example

| **Output**                                                                                                     |
|----------------------------------------------------------------------------------------------------------------|
| Amanda Rice – 87819 <br/> Amy Porter – 29366 <br/> Christina Jordan – 18708 <br/> Earl Bennett – 12978 <br/> … |

16.11 Reduced Book
------------------

Write a program that prints **information** (**title**, **edition type**, **age
restriction** and **price**) for a book **by given title**. When retrieving the
book information **select only those fields** and **do NOT include any other
information** in the returned result.

### Example

| **Input**         | **Output**                         |
|-------------------|------------------------------------|
| Тhrones           | Thrones PROMO MINOR 21.41          |
| Things Fall Apart | Things Fall Apart GOLD ADULT 40.02 |

### Hints

You must **create a projection** of the book class omitting the not required
fields.

1.  Create an **interface ReducedBook** with properties for **title**, **edition
    type**, **age restriction** and **price**.

2.  In the books repository create **query method** that would return
    **ReducedBook** by given title.

3.  Use that method in the **BookService class.**

4.  Use the **BookService** to retrieve instance of that object and print its
    information.

16.12 \* Increase Book Copies
-----------------------------

Write a program that **increases the copies of all books released after a given
date with a given number**. Print the total amount of book copies that were
added.

### Input

-   On the **first line** – date in the format **dd-MMM-yyyy.** If a book is
    released after that date (exclusively), increase its book copies with the
    provided number from the second line of the input.

-   On the **second line** – number of **book copies** each book should be
    increased with.

### Output

-   **Total number of books** that was added to the database.

### Example

| **Input**             | **Output** | **Comments**                                                                     |
|-----------------------|------------|----------------------------------------------------------------------------------|
| 12 Oct 2005 <br/> 100 | 6100       | 61 books are released after 12 Oct 2005, so total of 6100 book copies were added |
| 06 Jun 2013 <br/> 44  | 572        | 13 books are released after 6 Jun 2013, so total of 572 book copies were added   |

16.13 \* Remove Books
---------------------

Write a program that **removes from the database** those **books**, which
**copies are lower than a given number**. Print the **number of books that were
deleted** from the database.

### Example

| **Input** | **Output**            |
|-----------|-----------------------|
| 300       | 4 books were deleted  |
| 4200      | 34 books were deleted |

16.14 \* Stored Procedure
-------------------------

Using HeidiSQL (or other similar tool) **create a stored procedure**, which
receives an **author’s first and last name** and returns the **total amount of
books the author has written**. Then write a **program** that **receives an
author’s name** and prints the **total number of books** the author has written
by **using the stored procedure** you’ve just created.

### Example

| **Input**        | **Output**                                  |
|------------------|---------------------------------------------|
| Amanda Rice      | Amanda Rice has written 4 books             |
| Christina Jordan | Christina Jordan has written 1 book         |
| Wanda Morales    | Wanda Morales has not written any books yet |
<br/>

### Solution: <a title="All Solutions" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/blob/master/16%20EXERCISE%20SPRING%20DATA%20ADVANCED%20QUERING/SpringDataAdvanced/src/main/java/bookshopsystemapp/controller/BookshopController.java">All Solutions</a>

---