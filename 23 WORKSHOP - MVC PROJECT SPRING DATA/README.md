23 Workshop - MVC Project: Spring MVC + Spring Data 
===================================================

Colonial Council Bank
=====================

After the success of the Colonial Journey, the Council has decided to establish
a bank – Colonial Council Bank. You have been employed by the Council to finish
the database layer, which supports basic functionality like importing JSON and
XML data and exporting some results.

23.01 Functionality Overview
----------------------------

The Council has hired you as their application developer, to implement the
**database layer**. The application should be able to easily **import**
hard-formatted data from **XML** and **JSON** and **support functionality** for
also **exporting** the imported data. The application is called – **ccb**.

Look at the pictures below to see what must happen:

-   Home page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65441886-daf99980-de33-11e9-9015-0fe3a3ff6740.png" alt="alt text" width="900" height=""></kbd>

-   Import JSON page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442008-15633680-de34-11e9-934f-27900b63ed99.png" alt="alt text" width="900" height=""></kbd>

-   Import XML page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442038-23b15280-de34-11e9-8fff-ede4b57d2e63.png" alt="alt text" width="900" height=""></kbd>

-   Import Branches page after reading the **branches.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442089-3f1c5d80-de34-11e9-9703-75d5011bc9ac.png" alt="alt text" width="900" height=""></kbd>

-   Import Employees page after reading the **employees.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442102-45123e80-de34-11e9-91ea-c3f08cc5fc0b.png" alt="alt text" width="900" height=""></kbd>

-   Import Clients page after reading the **clients.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442120-4b081f80-de34-11e9-803f-d4d3d2437db1.png" alt="alt text" width="900" height=""></kbd>

-   Import Bank Accounts page after reading **bank-accounts.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442135-53605a80-de34-11e9-8ba0-796db94f3d60.png" alt="alt text" width="900" height=""></kbd>

-   Import Cards page after reading **cards.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442153-59eed200-de34-11e9-94dc-411a64bec3d3.png" alt="alt text" width="900" height=""></kbd>

-   Import JSON page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442167-5fe4b300-de34-11e9-9d23-f6f44aea24c3.png" alt="alt text" width="900" height=""></kbd>

-   Import XML page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442181-6541fd80-de34-11e9-9cc2-1d71a4c37e38.png" alt="alt text" width="900" height=""></kbd>

-   Home page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442199-6b37de80-de34-11e9-9772-1e189782926b.png" alt="alt text" width="900" height=""></kbd>

-   Export Top Employees page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442222-725eec80-de34-11e9-887e-f9f26b4a32ea.png" alt="alt text" width="900" height=""></kbd>

-   Export Family Guy page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65442229-7723a080-de34-11e9-8466-bfe5a53035f0.png" alt="alt text" width="900" height=""></kbd>

23.02 Project Skeleton Overview
-------------------------------

You will be given a **Skeleton**, containing a **certain architecture(MVC)**
with **several classes**, some of which – completely empty. The **Skeleton**
will include the **files** with which you will **seed** the **database**.

23.03 Model Definition
----------------------

There are 5 main models that the **ccb** database application should contain in
its functionality.

Design them in the **most appropriate** way, considering the following **data
constraints**:

### Branch

-   **id** – **integer** number, **primary identification field**.

-   **name** – a **string** (**required**).

### Employee

-   **id** – **integer** number, **primary identification field**.

-   **first_name** – a **string** (**required**).

-   **last_name** – a **string** (**required**).

-   **salary** – a **decimal** data type.

-   **started_on** – a **Date**.

-   **branch** – a **Branch** entity (**required**).

-   **clients** – a **collection** of **Client** entity.

### Clients

-   **id** – **integer** number, **primary identification field**.

-   **full_name** – a **string** (**required**).

-   **age** – an **integer** number.

-   **bank_account** – a **Bank Account** entity (**One**).

### Bank Account

-   **id** – **integer** number, **primary identification field**.

-   **account_number** – a **string** (**required**).

-   **balance** – a **decimal** data type.

-   **client** – a **Client** entity (**One**).

-   **cards** – a **collection** of **Card** entity.

### Card

-   **id** – **integer** number, **primary identification field**.

-   **card_number** – a **string** (**required**).

-   **card_status** – a **string** (**required**).

-   **bank_account** – a **Bank Account** entity.

**NOTE**: Name the entities and their class members, **exactly** in the **format
stated** above. Do not name them in snake case with the dashes, of course. But
if a field is specified as **bank_account**, you are to name it **bankAccount**.

#### Relationships

The Council decided to give you a little hint about the more complex
relationships in the database, so that you can implement it correctly.

One **Employee** may have only one **Branch**, and one **Branch** may have many
**Employees**.

One **Employee** may have many **Clients**, and one **Client** may be appointed
to many **Employees**.

A **Client** can have only one **Bank Account**, and one **Bank Account** can
have only one **Client**.

One **Card** can have only one **Bank Account**, and one **Bank Account** can
have many **Cards**.

23.04 Data Import
-----------------

Use the provided **JSON** and **XML** files to populate the database with data.
Import all the information from those files into the database.

**You are** not allowed **to modify the provided JSON and XML files.**

**ANY INCORRECT** data should be **ignored** and a message “**Error: Incorrect
Data!**” should be printed.

-   **NOTE**: An incorrect data input is an input which is **missing required
    fields**.

-   There are **no other validation criteria**.

**ANY SUCCESSFUL** data import should **result** in a message “**Successfully
imported {entityClass} – {entityField}.**”.

The **entityField** depends on the **entityClass**:

-   For **Branch** – **{name}**.

-   For **Employee** – a string **composed** in the following format –
    “**{first_name} {last_name}**”.

-   For **Client** – **{full_name}**.

-   For **BankAccount** – **{account_number}**.

-   For **Card** – **{card_number}**.

### JSON Import

#### branches (branches.json)

| **branches.json**                                                                                      |
|--------------------------------------------------------------------------------------------------------|
    [
    	{ "name" : "Anniversary Branch" },
    	{ "name" : "Becker Branch" },
          . . .
    ]

---

    Successfully imported Branch - Anniversary Branch.
    Successfully imported Branch - Becker Branch.
    . . .



#### Employees (employees.json)

| **employees.json**                                                                                                                                                                                                                                                |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
    	{ 
    		"full_name" : "Milty Dyett", 
    		"salary" : 213270.78,
    		"started_on" : "2017-06-10",
    		"branch_name" : "Mendota Branch",
     	
    	},
    	{ 
    		"full_name" : "Ermentrude Crenshaw", 
    		"salary" : 641140.25,
    		"started_on" : "2017-11-26",
    		"branch_name" : "Grasskamp Branch",
    	},
          . . .
    ]

---

    Successfully imported Employee - Milty Dyett.
    Successfully imported Employee - Ermentrude Crenshaw.
    . . .

#### Clients (clients.json)

| **clients.json**                                                                                                |
|-----------------------------------------------------------------------------------------------------------------|
    [
    	{ 
    		"first_name" : "Adorne", 
    		"last_name" : "Bewly", 
    		"age" : 34,
    		"appointed_employee" : "Milty Dyett"
    	},
          . . .
    ]

---

    Successfully imported Client - Adorne Bewly.
    . . .


### XML Import

The **ccb** have prepared some XML data for you to import too. Don’t worry, it’s
not too much.

#### Bank Accounts (bank-accounts.xml)

| **bank-accounts.xml**                                                                                                                                                                                                         |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <bank-accounts>
        <bank-account client="Elyn Grimditch">
            <account-number>84999053-X</account-number>
            <balance>439216.96</balance>
        </bank-account>
        ...
    </bank-accounts>

---

    Successfully imported Bank Account - 84999053-X.
    . . .


#### Cards (cards.xml)

| **cards.xml**                                                                                                                                                                                                                                                                                                                                                                                                           |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <cards>
        <card status="Active" account-number="45313950-8">
            <card-number>CR31 2172 7000 5807</card-number>
        </card>
        <card status="Active" account-number="45313950-8">
            <card-number>KZ69 306U DAMP BELG</card-number>
        </card>
        <card status="Active" account-number="90687224-1">
            <card-number>MR58 1652 6071 3846</card-number>
        </card>
        ...
    </cards>

---

    Successfully imported Card - CR31 2172 7000 5807.

23.05 Data Export
-----------------

Get ready to export the data you’ve imported in the previous task. Here you will
have some pretty complex database querying. Export the data in the formats
specified below.

#### Top Employees 

**Export all employees** which have **any clients** in them:

-   Extract from the database, the **employees** and their **clients**.

-   **Order** them **descending** by **count of clients**, and **ascending** by
    **employee id**.

#### Family Guy 

**Export** the **client** with the **most cards** in his **bank account**.

-   Export the **client’s full name**, **age, bank_account** and his **cards**.

-   For **each** of his **cards**, **export** the **card_number** and the
    **status**.

<br/>

### Solution: <a title="Colonial Council Bank" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/23%20WORKSHOP%20-%20MVC%20PROJECT%20SPRING%20DATA/ColonialCouncilBank">Colonial Council Bank</a>

---