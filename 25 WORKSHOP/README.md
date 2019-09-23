Workshop: Creating large DB Part 1
==================================

This exercise is part of the [“Databases Frameworks” course \@
SoftUni](https://softuni.bg/courses/databases-advanced-hibernate).

Judge System
------------

For the following assignment**,** we are going to simulate the Judge System
database. Its concept is most probably familiar to you: we have **contests**
grouped in **categories** and **subcategories**. Each contest has different
amount of **problems** to be solved. Solving is done by users **submitting**
solutions, which go under **tests** to check if they are correct or not. Each
user gets different amount of **points** according to the correctness of his
solution. Based on this, a **maximum points submission** is formed – user’s best
submission.

In the first part of the assignment we are going to **model the database**.
Follow the instructions to properly set table relations and design the entities,
which will be persisted.

### 1. Categories


Currently the contests category hierarchy in our well-known Judge System
looks like this:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65446581-53b12380-de3d-11e9-8839-07b7a54912a0.png" alt="alt text" width="250" height=""></kbd>

Each category can be **nested** in another to achieve better organization.
Therefore, when we implement the category entity we will have a
**self-relationship**. Categories will be mandatorily named, but not
necessarily unique. For example, the DB Fundamentals in both C\# and Java
Development categories have the **same subcategories**, but **different
contests and problems**:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65446584-56137d80-de3d-11e9-839f-365b37c14c09.png" alt="alt text" width="250" height=""></kbd>

Each category has:

-   Id

-   Category to which it **belongs**

-   Collection of **subcategories**

-   Collection of **contests**

Design the category entity as described.

### 2. Contests 

Contests are placed in certain categories. We consider that **the same
contest cannot be placed in various categories** regardless name
duplication. For example, the **Databases Basics** subcategory in both
**C\#** or **Java Development categories** has same contests – Data
Definition and Data Types, Basic CRUD and so on, but **the problems in them
differ**, therefore we consider them **different**. Each contest has:

-   **Id**

-   **Name**

-   **Category**

-   Collection of **problems** – many problems can belong to one contest and
    vice versa

-   Collection of **contestants** – many users can practice same contests

-   Collection of **maximum results per contest**

The maximum results per contest will be a collection containing the maximum
results for the users who have practiced the contest. A **maximum result for
a user per contest will be calculated by the sum of all problems score for
each user.** It will be an entity keeping information about the user, who
made the result, the contest in which the result is made, the average
performance of submissions and the points sum.

**E.g.:** For a contest containing 3 problems, a user has submitted 10
times. The maximum result is formed by **getting the maximum result
submission for each problem**, **summing the points scored** from those
submissions and **calculating the average performance** from the same
submissions.

### 3. Problems

The problems which will be solved are the main part in our mini application.
Each problem has:

-   **Id**

-   **Name**

-   Collection of **submissions**

-   Collection of **contestants** – the user who have practiced the problem

-   **Contest** to which the problem belongs

-   Collection of **user maximum results for a problem**

The **maximum results per user for a problem** are a very important
optimization for us. The entity can be, of course, skipped but let’s look
after the following scenario: A user submits his solution for the current
problem. If we want to calculate the maximum results for the problem, we
must traverse every single submission for the problem in the database and
check if the current score is the maximum. This will not only be **slow**,
but **very slow**. Therefore, we can solve the situation by keeping another
entity – **user maximum result per problem** and skip the whole traversing
of the database. This entity will give us information about the **user**,
the **problem** and the **submission**, which gave maximum score. With that,
we will check for information in smaller table in our data source, and not
go through all submissions – we will always have one that will be the
maximum we need.

### 4. Strategies

The strategies for a contest is the ways for solving problems in it. For
example:

In a programming basics exam we can submit code with by:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65446590-5b70c800-de3d-11e9-9399-196c3a316f38.png" alt="alt text" width="600" height=""></kbd>

And during the MySQL course we could submit solutions by:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65446594-5ca1f500-de3d-11e9-8b7d-b6dc38bf2492.png" alt="alt text" width="600" height=""></kbd>

Each strategy has a **name** and **contests** which use it. Many contests can
use the same strategy.

### 5. Submissions 

Submissions hold the solutions results that the users in the system submit.
Each submission keeps information about the **user** who has submitted, the
**used strategy** to solve the problem, the **performance** of the solution
in milliseconds, **points** which have been achieved by the solution and the
**problem**.

### 6. Users

A used is the person registered in the Judge System. Each user has an
**id**, **unique username**, collections of **submissions**, **maximum
results for problems**, **maximum results for contests**, **contests** in
which the user has participated and **problems** solved.

### 7. Database Schema

If you’ve modelled the entities and their relations correctly, the database
schema should look like this:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65446601-5f9ce580-de3d-11e9-84ed-aab349c2fca5.png" alt="alt text" width="900" height=""></kbd>

In the next part of the workshop we will add validation to our entities,
implement services and controllers and add some functionalities.

---
---

Workshop: Creating large DB Part 2
==================================
---

In the previous assignment we modelled the **structure** of our Judge System
Database. Now it’s time to start writing some functionality logic and validation
using that schema. For now, your database should have the following structure:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65447486-4f860580-de3f-11e9-91b4-b1518a94b182.png" alt="alt text" width="900" height=""></kbd>

Download the skeleton from the course instance if you haven’t completed it in
the previous lecture.

### 8. Categories

Start by inserting the **categories first from the categories.json file**. Have
in mind that a category cannot be inserted without it’s super category existing;

**HINT**: Create categories in the database recursively starting from the top
category. If categories share the same super category, just add the new one to
the subcategories of the existing one.

### 9. Strategies 

Proceed by inserting strategies. They are held in the **strategies.json** file.

### 10. Contests Creation

All contests will be persisted from the **contests.json** file. Each contest
belongs to certain category and allows many strategies to be used. Get each
contest’s category from the database and assign it to it. Then, add the
permitted strategies to each contest’s collection of strategy and persist the
contest entity.

### 11. Contest Enrollment

Import the **users.json** file. Write the functionality to allow users to
**enroll** to contests. **Once a user has enrolled to a contest**, he can solve
the problems in it, otherwise the application **should not allow** problems to
be visible to him.

Contest enrollment is done by passing **contest** and **user id** to an
enrolling logic. Consider that a user **cannot start practicing a contest that
doesn’t exist or is not logged in**. If he is already enrolled to it, return an
adequate message “**Used already has enrolled to contest**”.

#### **HINT**: 

You can begin by creating an **UserParticipation** java object that will
represent our user-contest pair from the database. Use the newly created object
to map the xml file to the database. From this object, you can get information
about the **user’s id**, **get him from the database** and **add the contest to
his participations collection**, again by the contest id from the same object
and persist the user.

### 12. Problem Solving

We’ve cleared that once a user has enrolled to a contest, he has access to the
contest’s problems. Look at the way we’ve designed our **user**, **contest** and
**problem** entity:

Each problem entity keeps information about the max results obtained for each
user;

<kbd><img src="https://user-images.githubusercontent.com/32310938/65447493-54e35000-de3f-11e9-9451-6989d912d464.png" alt="alt text" width="600" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65447499-5876d700-de3f-11e9-84cc-f4da3c6a277b.png" alt="alt text" width="600" height=""></kbd>

The same goes for our users, except that they’re optimized to give us info about
the maximum results they have achieved for each contest and problem, so we don’t
traverse entities unnecessary

<kbd><img src="https://user-images.githubusercontent.com/32310938/65447502-59a80400-de3f-11e9-8599-a930efbc9201.png" alt="alt text" width="600" height=""></kbd>

With this having in mind, once a user submits a **submission, his maximum result
for the problem and contest must be updated.**

#### Submitting

Submitting is done **only if the user has access to the problem**, in other
words - **is a contestant in the problem’s contest**. Each submission gives
certain amount of points, which increase his maximum results accordingly if
needed – **only if the current submission is a new maximum one** for the
user to the current problem. If so, the **UserMaximumResultPerContest** for
the corresponding problem is updated and with that the user’s maximum result
for the contest.

#### HINT: 

Each submission keeps information about the problem id and the user who made it.
Get the user from the database and check if he is a contestant in the problem’s
contest. If so, add the submission to the database and proceed to step 6,
otherwise throw an adequate message like “**User is not contestant in
contest!**”

### 13. Result Update

Our entities keep information about the maximum results made with/towards them.

Once a user submits, his maximum results for the problem to which he submits a
solution should be updated **only if** the new scored result is a maximum to
this point.

**HINTS**: After each submission made for user, update the
**UserMaximumResultForProblem** entity **if the new result from the submission
is higher than the already existing one**. This means that the initial submit
towards a problem is considered a maximum and the comparison starts from there.
With each update on the **UserMaximumResultForProblem**, update the
**UserMaximumResultForContest** if the new result is a top one for the contest.
A result is a top one for the contest only if the points scored are higher than
the maximum points scored to this point. **If there is a draw**, a maximum
result is considered **the one with submission with best code performance**.

### 14. Bonus Tasks

#### Validation Rules

Add validation to each entity that we’ve created according to the following
description:

#### Category 

-   **Name** – cannot be null; length must be more than 4 symbols; must start
    with capital letter

#### Contest

-   **Name** - cannot be null; length must be more than 4 symbols; must start
    with capital letter

-   **Category** – cannot be null; All contests are placed in certain categories

#### Problem

-   **Name** - must be longer than 3 symbols; must start with capital letter

-   **Contest** – cannot be null

#### Strategy

-   **Name** – cannot be null; must start with capital letter; is **unique**

#### Submission

-   **Code performance** – cannot be null; precision up to 3 digits after
    decimal point

-   **Points** – cannot be null

-   **Problem** – null is not allowed

-   **Used strategy** – cannot be strategy that is not allowed by the contest;
    cannot be null

-   **User** – null is not allowed

#### Register

Write extra functionality so users can register in the system by giving the
following information:

-   **Password** – longer than **5 symbols**, containing at least **one special
    symbol** and **digit. Modify the user entity to add password**

-   **Username** – longer than 4 symbols, **not starting or ending with special
    symbols. Write register logic according to the following criteria:**

-   Users will have to input their password twice to confirm it. In case the
    passwords differ, they should not be able to login

-   Apply validation to the entity’s fields. Give adequate exception messages if
    validation fails.

-   Store the new user if all above steps are passed

#### Login 

After a user has **registered successfully**, he should be able to
**login**, **if he already hasn’t**. Keep his credentials in an Application
context, like previous exercises. He should be able to do the following
actions in the assignment **only if he has logged in**.

<br/>

### Solution: <a title="Judge System" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/25%20WORKSHOP/JudgeSystem">Judge System</a>

---