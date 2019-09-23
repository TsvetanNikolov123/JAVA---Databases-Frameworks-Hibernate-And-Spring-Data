Database Frameworks – Spring Data Exam 
=======================================
Alara Restaurant
================

On the planet Alara, one of the first colonists and great friend of yours,
decided to establish a restaurant. The restaurant is named after the planet –
Alara Restaurant. You have been asked by your mate to finish the database layer,
which supports basic functionality like importing JSON and XML data and
exporting some results.

1.Functionality Overview
------------------------

After finishing the Colonial Council Bank application, your friend has asked you
to implement the **database layer**. The application should be able to easily
**import** hard-formatted data from **XML** and **JSON** and **support
functionality** for also **exporting** the imported data. The application is
called – **Alara Restaurant**.

Look at the pictures below to see what must happen:

-   Home page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449582-f1a7ec80-de43-11e9-9858-0ec0494890da.png" alt="alt text" width="800" height=""></kbd>

-   Import JSON page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449587-f4a2dd00-de43-11e9-88d3-0cb02d6c6c8c.png" alt="alt text" width="800" height=""></kbd>

-   Import XML page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449589-f79dcd80-de43-11e9-84f5-a98440e8ad0c.png" alt="alt text" width="800" height=""></kbd>

-   Import Employees page after reading the **employees.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449594-fa98be00-de43-11e9-9ede-9e42771fe0f3.png" alt="alt text" width="800" height=""></kbd>

-   Import Items page after reading the **items.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449610-fd93ae80-de43-11e9-8ced-81093bce753e.png" alt="alt text" width="800" height=""></kbd>

-   Import Orders page after reading **orders.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449614-01273580-de44-11e9-9b94-d563d63e4b0c.png" alt="alt text" width="800" height=""></kbd>

-   Import JSON page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449623-04babc80-de44-11e9-8899-08540de628bc.png" alt="alt text" width="800" height=""></kbd>

-   Import XML page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449631-084e4380-de44-11e9-87fc-acab21838b6e.png" alt="alt text" width="800" height=""></kbd>

-   Home page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449638-0be1ca80-de44-11e9-93b0-1bb5018b60c8.png" alt="alt text" width="800" height=""></kbd>

-   Export Orders finished by the Burger Flippers page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449645-100de800-de44-11e9-914f-b32f82041527.png" alt="alt text" width="800" height=""></kbd>

-   Export Categories by count of items page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449647-13a16f00-de44-11e9-9d05-5d02b6736ba0.png" alt="alt text" width="800" height=""></kbd>

**NOTE**: You will be able to finish the **first** export task after importing
both of the JSON files.

2.Project Skeleton Overview
-------------------------

You will be given a **Skeleton**, containing a **certain architecture(MVC)**
with **several classes**, some of which – completely empty. The **Skeleton**
will include the **files** with which you will **seed** the **database**.

3.Model Definition
----------------

Every employee has a **position** and **orders**, which they need to process.
Every **order** has a **customer**, **order date** and a **list of items**.
Every item has a **category**, a **name** and a **price**. **Categories** have a
**list of items**.

The application needs to store the following data:

### Employee

-   **id** – integer, **Primary Key**

-   **name** – text with **min length 3** and **max length 30** (**required**)

-   **age** – integer **in the range [15, 80]** (**required**)

-   **position** – the employee’s **position** (**required**)

-   **orders** – the **orders** the employee has processed

### Position

-   **id** – integer, **Primary Key**

-   **name** – text with **min length 3** and **max length 30** (**required,
    unique**)

-   **employees** – Collection of type **Employee**

### Category

-   **id** – integer, **Primary Key**

-   **name –** text with **min length 3** and **max length 30** (**required**)

-   **items** – collection of type **Item**

### Item

-   **id** – integer, **Primary Key**

-   **name** – text with **min length 3** and **max length 30** (**required,
    unique**)

-   **category** – the item’s **category** (**required**)

-   **price** – decimal (**non-negative, minimum value: 0.01**, **required**)

-   **orderItems** – collection of type **OrderItem**

### Order

-   **id** – integer, **Primary Key**

-   **customer** – text (**required**)

-   **dateTime** – date and time of the order (**required**)

-   **type – OrderType** enumeration with possible values: “**ForHere**,
    **ToGo** (default: **ForHere**)” (**required**)

-   **employee** – The employee who will process the order (**required**)

-   **orderItems** – collection of type **OrderItem**

### OrderItem

-   **id** – integer, **Primary Key**

-   **order** – the item’s **order** (**required**)

-   **item** – the order’s **item** (**required**)

-   **quantity** – the quantity of the **item** in the **order** (**required**,
    **non-negative** and **non-zero**)

Your friend has given you an E/R Diagram for better understanding of the
database:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449661-17cd8c80-de44-11e9-96b4-eb1bd1454bba.png" alt="alt text" width="900" height=""></kbd>

4.Data Import
-----------

Use the provided **JSON** and **XML** files to populate the database with data.
Import all the information from those files into the database.

**You are** not allowed **to modify the provided JSON and XML files.**

**If a record does not meet the requirements from the first section, print an
error message:**

| **Error message**    |
|----------------------|
| Invalid data format. |

### JSON Import 

#### Import Employees

Using the file **employees.json**, import the data from that file into the
database. Print information about each imported object in the format described
below.

##### Constraints

-   If any validation errors occur (such as if their **name or position are too
    long/short** or their **age** is out of range) proceed as described above

-   If a position **doesn’t exist yet** (and the position and rest of employee
    data is **valid**), **create it**.

-   If an employee is **invalid**, **do not** import their **position**.

##### Example

| **employees.json**                                                                                                                                                                                                                                                                                                                                                                      |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
      {
        "name": "N",
        "age": 20,
        "position": "Invalid"
      },
      {
        "name": "Too Young",
        "age": 14,
        "position": "Invalid"
      },
      {
        "name": "Too Old",
        "age": 81,
        "position": "Invalid"
      },
      {
        "name": "Invalid Position",
        "age": 20,
        "position": ""
      },
      {
        "name": "InvalidPosition",
        "age": 20,
        "position": "Invaliddddddddddddddddddddddddd"
      },
      {
        "name": "Magda Bjork",
        "age": 44,
        "position": "CEO"
      },
    …

| **Output**                                                                                                                                                                                                                                                                                                                                                                              |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Record Magda Bjork successfully imported.
    …

#### Import Items

Using the file **items.json**, import the data from that file into the database.
Print information about each imported object in the format described below.

##### Constraints

-   If any validation errors occur (such as invalid item name or invalid
    category name), **ignore** the entity and **print an error message**.

-   If an item with the same name **already exists**, **ignore** the entity and
    **do not import it**.

-   If an item’s category **doesn’t exist**, **create it** along with the item.

##### Example

| **items.json**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
      {
        "name": "Hamburger",
        "price": 0.00,
        "category": "Invalid"
      },
      {
        "name": "Hamburger",
        "price": -5.00,
        "category": "Invalid"
      },
      {
        "name": "x",
        "price": 1.00,
        "category": "Invalid"
      },
      {
        "name": "Invaliddddddddddddddddddddddddd",
        "price": 1.00,
        "category": "Invalid"
      },
      {
        "name": "Invalid",
        "price": 1.00,
        "category": "x"
      },
      {
        "name": "Invalid",
        "price": 1.00,
        "category": "Invaliddddddddddddddddddddddddd"
      },
      {
        "name": "Hamburger",
        "price": 5.00,
        "category": "Beef"
      },
      {
        "name": "Hamburger",
        "price": 1.00,
        "category": "Beef"
      },
      {
        "name": "Cheeseburger",
        "price": 6.00,
        "category": "Beef"
      },
    …


| **Output**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Invalid data format.
    Record Hamburger successfully imported.
    Invalid data format.
    Record Cheeseburger successfully imported.


### XML Import 

#### Import Orders

Using the file **orders.xml**, import the data from the file into the database.
Print information about each imported object in the format described below.

If any of the model requirements is violated continue with the next entity.

##### Constraints

-   The order dates will be in the format “**dd/MM/yyyy HH:mm**”.

-   If the order’s **employee** doesn’t exist, **do not** import the order.

-   If **any** of the **order’s items** do not exist, **do not** import the
    order.

-   Every employee will have a **unique name**

##### Example

| **orders.xml**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <orders>
      <order>
        <customer>Garry</customer>
        <employee>Maxwell Shanahan</employee>
        <date-time>21/08/2017 13:22</date-time>
        <type>ForHere</type>
        <items>
          <item>
            <name>Quarter Pounder</name>
            <quantity>2</quantity>
          </item>
          <item>
            <name>Premium chicken sandwich</name>
            <quantity>2</quantity>
          </item>
          <item>
            <name>Chicken Tenders</name>
            <quantity>4</quantity>
          </item>
          <item>
            <name>Just Lettuce</name>
            <quantity>4</quantity>
          </item>
        </items>
      </order>
    ...
    </orders>


| **Output**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    Order for Garry on 21/08/2017 13:22 added

5.Data Export
------------

Get ready to export the data you’ve imported in the previous task. Here you will
have some pretty complex database querying. Export the data in the formats
specified below.

#### Categories by count of items

**Export all categories** by count of **items**:

-   Extract from the database, **categories’ names** and **items** in the
    categories with their **name** and **price.**

-   **Order** them **descending** by **count of items** in each category, and if
    two or more categories have same number of items, order them **descending**
    by **sum of the items’ prices** in each category.

-   The format is described below**:**

    **Category: {category1Name}**

    **--- Item Name: {item1Name}**

    **--- Item Price: {item1Price}**

    **--- Item Name: {item2Name}**

    **--- Item Price: {item2Price}**

    **--- Item Name: {item3Name}**

    **--- Item Price: {item3Price}**

    **…**

    **Category: {category2Name}**

    **--- Item Name: {item1Name}**

    **--- Item Price: {item1Price}**

    **…**

<kbd><img src="https://user-images.githubusercontent.com/32310938/65449668-1ef49a80-de44-11e9-8da6-70606dee7a64.png" alt="alt text" width="600" height=""></kbd>

#### Orders finished by the Burger Flippers

**Export all orders** which are finished by the **Burger Flippers**:

-   Extract from the database, **employees’ names**, **orders’ customers** and
    **items** in the orders with their **name**, **price** and **quantity**.

-   **Order** them by **employee name**, and by **order id**.

-   The format is described below**:**

    **Name: {employee1Name}**

    **Orders:**

    **Customer: {customerName}**

    **Items:**

    **Name: {item1Name}**

    **Price: {item1Price}**

    **Quantity: {item1Quantity}**

    **Name: {item2Name}**

    **Price: {item2Price}**

    **Quantity: {item2Quantity}**

    **Name: {employee2Name}**

    **Orders:**

    **Customer: {customerName}**

    **Items:**

    **…**

    <kbd><img src="https://user-images.githubusercontent.com/32310938/65449675-22882180-de44-11e9-8db7-ba7a58eb343c.png" alt="alt text" width="600" height=""></kbd>

<br/>

### Solution: <a title="Alara Restaurant" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/28%20EXAM/AlaraRestaurant">Alara Restaurant</a>

---