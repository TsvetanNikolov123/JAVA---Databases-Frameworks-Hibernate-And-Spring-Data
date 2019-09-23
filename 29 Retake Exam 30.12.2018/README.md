29 Database Frameworks – Spring Data Retake Exam
================================================

Hiberspring Inc.
================

**Hiberspring Incorporation** is a new non-profit organization which has
products of almost any type.  
By some rare circumstances, though, it became the monopoly of the garbage bag
business part of the market. Anyways … Since they are a non-profit organization,
they had to find a non-profit charitable database specialist for their database
application. Guess what, you fit the description perfectly.

1.Functionality Overview
----------------------

The application should be able to easily **import** hard-formatted data from
**XML** and **JSON** and **support functionality** for also **exporting** the
imported data. The application is called – **Hiberspring Inc**.

Look at the pictures below to see what must happen:

-   Home page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65451984-f1f6b680-de48-11e9-8b92-a36e66e243a9.png" alt="alt text" width="800" height=""></kbd>

-   Import JSON page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65451991-f622d400-de48-11e9-85ce-1870f42ebdf0.png" alt="alt text" width="800" height=""></kbd>

-   Import XML page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452000-fae78800-de48-11e9-98f5-71d8d1849926.png" alt="alt text" width="800" height=""></kbd>

-   Import Towns page after reading the **towns.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452005-fe7b0f00-de48-11e9-975c-76397b6b82c3.png" alt="alt text" width="800" height=""></kbd>

-   Import Branches page after reading the **branches.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452013-0175ff80-de49-11e9-83ba-dc4e5c6e639b.png" alt="alt text" width="800" height=""></kbd>

-   Import Employee Cards page after reading the **employee_cards.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452020-05098680-de49-11e9-9c2f-94938eee2b26.png" alt="alt text" width="800" height=""></kbd>

-   Import Products page after reading **products.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452027-089d0d80-de49-11e9-8231-8e6b479dd4f7.png" alt="alt text" width="800" height=""></kbd>

-   Import Employees page after reading **employees.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452033-0c309480-de49-11e9-88e3-67874aaf8401.png" alt="alt text" width="800" height=""></kbd>

-   Import JSON page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452043-0fc41b80-de49-11e9-99fb-34b04f514404.png" alt="alt text" width="800" height=""></kbd>

-   Import XML page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452051-1488cf80-de49-11e9-852f-fecd5dbc36c6.png" alt="alt text" width="800" height=""></kbd>

-   Home page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452058-18b4ed00-de49-11e9-9fc5-eb1a56864f96.png" alt="alt text" width="800" height=""></kbd>

-   Export Productive Employees page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452067-1d79a100-de49-11e9-827d-8d45787c4825.png" alt="alt text" width="800" height=""></kbd>

2.Project Skeleton Overview
-------------------------

You will be given a **Skeleton**, containing a **certain architecture(MVC)**
with **several classes**, some of which – completely empty. The **Skeleton**
will include the **files** with which you will **seed** the **database**.

3.Model Definition
----------------

You can see here what properties each model has:

#### Employee

-   **Id** – an **integer**.

-   **First Name** – a **string**.

-   **Last Name** – a **string**.

-   **Position** – a **string**.

-   **Card** – an **EmployeeCard**, could be any **EmployeeCard**. Must be
    **UNIQUE though**.

-   **Branch** – a **Branch**, could be any **Branch**.

#### EmployeeCard

-   **Id** – an **integer**.

-   **Number** – a **string**. Should be **UNIQUE**.

#### Branch

-   **Id** – an **integer**.

-   **Name** – a **string**.

-   **Town** – a **Town**, could be any **Town**.

#### Product

-   **Id** – an **integer**.

-   **Name** – a **string**.

-   **Clients** – an **integer**.

-   **Branch** – a **Branch**, could be any **Branch**.

#### Town

-   **Id** – an **integer**

-   **Name** – a **string**.

-   **Population** – an **integer**.

**All data** is **REQUIRED**, unless it is explicitly said that it **null** is
**allowed**.

4.Data Import
-----------

So here comes the **Importing** of **data** and the **populating** of the
**database**. You have to **import** data from **JSON** and **XML** files.

Implement the needed **DTOs** for the imports.

Make sure all fields have been entered, otherwise the import **entity** data
**should NOT be considered valid**.

You will also have to print a simple message indicating if the data has been
imported successfully or there was an error.

In case of **SUCCESS** the message format is “**Successfully imported
{entityClassName} {entityField}.**”. The **entityField** may vary, from **card
number** to **employee full name**, to just **name**.

In case of **ERROR** you always print “**Error: Invalid data.**”.

#### Importing from JSON format

#### Towns

##### Input

| **towns.json**                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
    	{ "name" : "Sofia", "population" : 2001050 },
    	{ "name" : "Kairo", "population" : 5432000 },
    	{ "name" : "New York", "population" : 11563790 },
    	{ "name" : "Tokyo", "population" : 27634593 },
    	{ "name" : "Moscow", "population" : 4523120 },
    	{ "name" : "Rome", "population" : 3021333 },
    	{ "name" : "Madrid", "population" : 7403213 },
    	{ "name" : "Paris", "population" : 8900043 },
    	{ "name" : "Zanzibar" },
    	{ "name" : "Rio de Janeiro", "population" : 6345231 },
          . . .
    ]
   
##### Output

    Successfully imported Town Sofia.
    Successfully imported Town Kairo.
    Successfully imported Town New York.
    Successfully imported Town Tokyo.
    Successfully imported Town Moscow.
    Successfully imported Town Rome.
    Successfully imported Town Madrid.
    Successfully imported Town Paris.
    Error: Invalid data.
    Successfully imported Town Rio de Janeiro.
    . . .

#### Branches

##### Input

| **branches.json**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
    	{ "name" : "Sofia Western Branch", "town" : "Sofia" },
    	{ "name" : "Tokyo Main Branch", "town" : "Tokyo" },
    	{ "name" : "Headquarters", "town" : "Sofia" },
    	{ "town" : "New York" },
    	{ "name" : "Kairo Central Branch", "town" : "Kairo" },
    	{ "name" : "Tokyo Underground Branch", "town" : "Tokyo" },
    	{ "name" : "USA Main Branch", "town" : "Washington DC" },
    	{ "name" : "Sofia Eastern Branch", "town" : "Sofia" },
    	{ "name" : "Central Branch of New York" },
    	{ "name" : "Central Park Branch", "town" : "New York" },
    	. . . 
    ]

##### Output

    Successfully imported Branch Sofia Western Branch.
    Successfully imported Branch Tokyo Main Branch.
    Successfully imported Branch Headquarters.
    Error: Invalid data.
    Successfully imported Branch Kairo Central Branch.
    Successfully imported Branch Tokyo Underground Branch.
    Successfully imported Branch USA Main Branch.
    Successfully imported Branch Sofia Eastern Branch.
    Error: Invalid data.
    Successfully imported Branch Central Park Branch.
    . . .


#### <br>EmployeeCards

##### Input

| **employee_cards.json**                                                                                                                                                                                                                                   |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
    	{ "number" : "zi4n5-y41Pq-ugz5v-3vrNH-Dv21y" },
    	{ "number" : "UAIP0-0UVao-3axBt-vWF8c-45paZ" },
    	{ "number" : "65RrK-NRzLZ-pJLZN-Chp3q-tovmA" },
    	{ "number" : "DXKwE-pprkA-dLT9g-bGnbp-1304U" },
    	{ "number" : "3mQuf-dGsVC-v5RhD-esuzu-0XcXp" },
    	. . . 
    ]

##### Output

    Successfully imported Employee Card zi4n5-y41Pq-ugz5v-3vrNH-Dv21y.
    Successfully imported Employee Card UAIP0-0UVao-3axBt-vWF8c-45paZ.
    Successfully imported Employee Card 65RrK-NRzLZ-pJLZN-Chp3q-tovmA.
    Successfully imported Employee Card DXKwE-pprkA-dLT9g-bGnbp-1304U.
    Successfully imported Employee Card 3mQuf-dGsVC-v5RhD-esuzu-0XcXp.
    . . .


#### Importing from XML format

The other **2 tables** must be populated with data in **XML** format.

#### Products

##### Input

| **products.xml**                                                                                                                                                                                                                                                                                                                                                                              |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
      <?xml version="1.0" encoding="utf-8"?>
        <products>
          <product name="Hydrogen Car Engine" clients="20000">
            <branch>Tokyo Main Branch</branch>
          </product>
          <product name="McDonalds Burger" clients="5001023">
            <branch>Central Park Branch</branch>
          </product>
          <product name="Garbage Bag" clients="102849">
            <branch>Headquarters</branch>
          </product>
          ...
        </products>

##### Output

    Successfully imported Product Hydrogen Car Engine.
    Successfully imported Product McDonalds Burger.
    Successfully imported Product Garbage Bag.
    . . .


#### Employees

##### Input

| **employees.xml**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <employees>
      <employee first-name="John" last-name="Winchester" position="Security Manager">
        <card>zi4n5-y41Pq-ugz5v-3vrNH-Dv21y</card>
        <branch>USA Main Branch</branch>
      </employee>
      <employee first-name="Leeroy" last-name="Gips" position="Security Manager">
        <card>3mQuf-dGsVC-v5RhD-esuzu-0XcXp</card>
        <branch>Kairo Central Branch</branch>
      </employee>
      <employee first-name="Rick" last-name="Sanchez" position="Head Scientist">
        <card>65RrK-NRzLZ-pJLZN-Chp3q-tovmA</card>
        <branch>Headquarters</branch>
      </employee>
      <employee first-name="Tony" last-name="Dolfin" position="Cleaner">
        <card>a45xz-dkgw1-zadv1-aXXXc-491Az</card>
      </employee>
      . . .
    </employees>


##### Output

    Successfully imported Employee John Winchester.
    Successfully imported Employee Leeroy Gips.
    Successfully imported Employee Rick Sanchez.
    Error: Invalid data.
    . . .


Data Export
-----------

Get ready to export the data you’ve imported in the previous task. Here you will
have some pretty complex database querying. Export the data in the formats
specified below.

#### Productive Employees

**Extract all Employees**, who are **working** in a **Branch**, which has **at
least one product**.

-   Extract the **Employee’s full name** (**first name** + **‘ ’** + **last
    name**), the **Employee’s position**, and the **Employee’s Card’s Number**.

-   Order the data by **full name** in **alphabetical order**, and then by
    **length** of **position** in **descending order**.

-   The format is described below:

**Name: {employee1Name}**

**Position: {employee1Position}**

**Card Number: {employee1CardNumber}**

**-------------------------**

**Name: {employee2Name}**

**Position: {employee2Position}**

**Card Number: {employee2CardNumber}**

**-------------------------**

**…**

<kbd><img src="https://user-images.githubusercontent.com/32310938/65452087-25394580-de49-11e9-8e8f-41e4302f4245.png" alt="alt text" width="600" height=""></kbd>

<br/>

### Solution: <a title="Hiberspring Inc" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/29%20Retake%20Exam%2030.12.2018/Hiberspring%20Inc">Hiberspring Inc</a>

---