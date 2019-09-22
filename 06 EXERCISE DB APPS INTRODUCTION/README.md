06 Exercises: Introduction to DB Apps
=====================================

---
---

This document defines the exercise assignments for the [“Databases Frameworks”
course \@ SoftUni](https://softuni.bg/courses/databases-advanced-hibernate).

---

01 Initial Setup 
----------------

Create a **new database** called “**MinionsDB”**, where we will keep information
about our minions and villains.

For each minion you must keep information about its **name**, **age** and
**town**. Each town has **name** and **information** about the country it is
located in. Villains have **name** and **evilness factor** (**good, bad, evil,
super evil**). Each minion can serve to several villains and each villain can
have several minions to serve him. Fill all the tables with at least 5 records
each.

Write a program that connects to your **localhost** server.

02 Get Villains’ Names
----------------------

Write a program that prints on the console **all villains’ names** and their
**number of minions**. Get only the villains who have more than 3 minions.
**Order** them by number of minions in **descending order**.

### Example

| **Output**                         |
|------------------------------------|
| Gru 6 <br/> Victor 4 <br/> Jilly 4 |

03 Get Minion Names
-------------------

Write a program that prints on the console **all minion names** and their
**age** for given **villain id.** For the output, use the formats given in the
examples.

### Example

| **Input** | **Output**                                                         |   | **Input** | **Output**                                        |   | **Input** | **Output**                               |
|-----------|--------------------------------------------------------------------|---|-----------|---------------------------------------------------|---|-----------|------------------------------------------|
| 1         | Villain: Gru <br/> 1. Bob 13 <br/> 2. Kevin 14 <br/> 3. Steward 19 |   | 3         | Villain: Victor <br/> 1. Bob 13 <br/> 2. Simon 22 |   | 2         | Villain: Victor Jr. <br/> \<no minions\> |
| **Input** | **Output**                                                         |   |           |                                                   |   |           |                                          |
| 10        | No villain with ID 10 exists in the database.                      |   |           |                                                   |   |           |                                          |

04 Add Minion
-------------

Write a program that reads information about a minion and its villain and **adds
it to the database**. In case the town of the minion is not in the database,
insert it as well. In case the villain is not present in the database, add him
too with default evilness factor of “evil”. Finally, set the new minion to be
servant of the villain. Print appropriate messages after each operation – see
the examples.

**\*Bonus task:** Make sure all operations are executed successfully. In case of
an error do not change the database.

### Example

| **Input**                                        | **Output**                                                                                                                              |
|--------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Minion: Bob 14 Berlin <br/> Villain: Gru         | Successfully added Robert to be minion of Gru.                                                                                          |
| Minion: Cathleen 20 Liverpool <br/> Villain: Gru | Town Liverpool was added to the database. <br/> Successfully added Cathleen to be minion of Gru.                                        |
| Minion: Mars 23 Sofia <br/> Villain: Poppy       | Villain Poppy was added to the database. <br/> Successfully added Mars to be minion of Poppy                                            |
| Minion: Carry 20 Eindhoven <br/> Villain: Jimmy  | Town Eindhoven was added to the database. <br/> Villain Jimmy was added to the database. Successfully added Carry to be minion of Jimmy |

05 Change Town Names Casing
---------------------------

Write a program that **changes all town names to uppercase** for a given
country. **Print the number of towns that were changed** in the format provided
in examples. On the next line **print** the **names that were changed**,
separated by coma and a space.

### Example

| **Input** | **Output**                                               |
|-----------|----------------------------------------------------------|
| Bulgaria  | 3 town names were affected. <br/> [SOFIA, VARNA, BURGAS] |
| Germany   | No town names were affected.                             |

06 \*Remove Villain
-------------------

Write a program that receives an **ID** of a villain, **deletes him from the
database** and **releases his minions** from serving him. As an output print the
name of the villain and the number of minions released. Make sure all operations
go as planned, **otherwise do not make any changes** to the database. For the
output use the format given in the examples.

### Example

| **Input** | **Output**                                  |
|-----------|---------------------------------------------|
| 1         | Gru was deleted <br/> 6 minions released    |
| 3         | Victor was deleted <br/> 0 minions released |
| 101       | No such villain was found                   |

07 Print All Minion Names
-------------------------

Write a program that **prints all minion names** from the minions table **in
order** first record, last record, first + 1, last – 1, first + 2, last – 2…
first + n, last – n.

| 1 | 3 | 5 | 7 | 9 | 10 | 8 | 6 | 4 | 2 |
|---|---|---|---|---|----|---|---|---|---|


### Example

| **Original Order**                                                            | **Output**                                                                    |
|-------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| Bob <br/> Kevin <br/> Steward <br/> Jimmy <br/> Vicky <br/> Becky <br/> Jully | Bob <br/> Jully <br/> Kevin <br/> Becky <br/> Steward <br/> Vicky <br/> Jimmy |

08 Increase Minions Age
-----------------------

Read from the console minion IDs, separated by space. **Increment the age** of
those minions **by 1** and make their **names title case**. Finally, **print**
the **names** and the **ages** of **all minions** that are in the database. See
the examples below.

### Example

| **minions** |                                                      |         |           |                                                      |
|-------------|------------------------------------------------------|---------|-----------|------------------------------------------------------|
| **Id**      | **name**                                             | **age** |           |                                                      |
| 1           | bob                                                  | 14      |           |                                                      |
| 2           | steward                                              | 22      |           |                                                      |
| 3           | kevin                                                | 13      |           |                                                      |
| 4           | jimmy                                                | 49      |           |                                                      |
| 5           | vicky jackson                                        | 26      |           |                                                      |
| **Input**   | **Output**                                           |         | **Input** | **Output**                                           |
| 2 1 4       | Bob 15 Steward 23 kevin 13 Jimmy 50 vicky jackson 26 |         | 5         | bob 14 steward 22 kevin 13 jimmy 49 Vicky Jackson 27 |

09 Increase Age Stored Procedure
--------------------------------

Create a stored procedure **usp_get_older** (**directly in the database** using
**MySQL Workbench** or any other similar tool) that receives a **minion_id** and
**increases the minion’s years by 1**. Write a program that **uses that stored
procedure to increase the age** of a minion, whose **id** will be given as an
input from the console. After that **print the name and the age** of that
minion.

### Example

| **minions** |                  |         |
|-------------|------------------|---------|
| **Id**      | **name**         | **age** |
| 1           | bob              | 14      |
| 2           | steward          | 22      |
| 3           | kevin            | 13      |
| 4           | jimmy            | 49      |
| 5           | vicky jackson    | 26      |
| **Input**   | **Output**       |         |
| 1           | bob 15           |         |
| 3           | kevin 14         |         |
| 5           | vicky jackson 27 |         |

<br/>

### Solution: <a title="All Tasks Solutions" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/06%20EXERCISE%20DB%20APPS%20INTRODUCTION/src/main/java/app">All Tasks Solutions</a>

---