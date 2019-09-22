07 Lab: Workshop – MiniORM Part 1
=================================

---
---

This document defines the exercise assignments for the ["DB Advanced" course \@
Software](https://softuni.bg/courses/databases-advanced-hibernate) University.

By following the guides of this document you will be able to create your custom
ORM with basic functionality (insert, update and retrieve single or set of
objects). It will have options to work with already created tables in a database
or create new tables if such are not present yet.

---

0 Setup
-------

Create a new Maven project in IntelliJ.

<img src="https://user-images.githubusercontent.com/32310938/65392318-31a39c80-dd7c-11e9-88d2-593e83a226dd.png" alt="alt text" width="600" height="">

Maven is a software development tool that helps you manage your projects’s
build, setting it up project and it’s dependencies.

Fill in the fields as shown in the screenshot below and click “Next”

<img src="https://user-images.githubusercontent.com/32310938/65392323-42eca900-dd7c-11e9-93d8-f4ddee938aac.png" alt="alt text" width="600" height="">

Select desired project location and click “Next” again.

Initially, no database driver is imported. Do that using Maven by adding a
dependency in the “**pom.xml**” file.

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.6</version>
        </dependency>
    </dependencies>

1 Create Entities
-----------------

In the means of ORMs, database objects are mapped to object-oriented
implementations called “**entities**”. They are objects that analogically to
database tables, for e.g. users, hold fields containing user’s main
characteristics – **id, username**, **first_name**, **last_name**, **age** and
etc.

In the “java” folder create a package called **entities** where will every one
of our entities be. Now let’s **create class User** with fields and properties
(**id, username, password, age, registrationDate**). Create a **constructor**
that **sets all fields except id – it’s auto incremented on database level**.
Order of the parameters in the constructor must be **the same as the sequence of
columns in the table in the database.** Add Getters and Setters for all fields.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392326-50a22e80-dd7c-11e9-8322-23aede858a1e.png" alt="alt text" width="500" height=""></kbd>

2 Create Database Connection
----------------------------

Unlike all previous tasks, it’s time to start separating our logic into classes.

Create new package “**orm**” and **class Connector** in it that generates
connection with our database. In order to achieve this, we would require the
following parameters:

-   **Username** – database username

-   **Password** – database password

-   **Database Name** – the current database for the project. We need to create
    one manually.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392335-69aadf80-dd7c-11e9-99e6-cbd46c9e97e3.png" alt="alt text" width="900" height=""></kbd>"

3 Create Database Context
-------------------------

It’s time to create an **interface** that will define the operations we can
perform with the database. Name your interface **DbContext** and defined the
following methods in it.

-   **boolean persist(E entity)** – it will insert or update entity depending if
    it is attached to the context

-   **Iterable\<E\> find(Class\<E\> table)** – returns collection of all entity
    objects of type **E**

-   **Iterable\<E\> find(Class\<E\> table, String where)** – returns collection
    of all entity objects of type **T** matching the criteria given in
    “**where**”

-   **E findFirst(Class\<E\> table)** – returns the first entity object of type
    **E**

-   **E findFirst(Class\<E\> table, String where)** – returns the first entity
    object of type **E** matching the criteria given in “where”

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392340-77f8fb80-dd7c-11e9-8353-340e9a6a3b57.png" alt="alt text" width="500" height=""></kbd>

4 Create Entity Manager
-----------------------

Enough with the preparation it’s time to write the core of our Mini ORM. That
would be the **EntityManager** class that will be responsible for inserting,
updating and retrieving entity objects. That class would implement methods of
the **DbContext interface**. It will require a **Connection** object that would
be initialized with a given connection string.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392344-847d5400-dd7c-11e9-808a-5b068febd42c.png" alt="alt text" width="500" height=""></kbd>

5 Persist Object in the Database
--------------------------------

The logic behind the persist method is pretty simple. First the method should
**check** if the given **object** to be persisted **is not contained** in the
database and if not **add it**, otherwise **update its properties with the new
values**. The method returns whether the object was **successfully persisted**
in the database or not.

But how can we check if the user that we are trying to persist is new to the
database or have to update it? We can do that by checking the value of it’s
**id** field and if it’s not empty that means we’re trying to insert it. But the
method works with a generic type – **E** and we don’t have direct access to it’s
getter methods – for example **getId**.

In order to minimize concretics and work with other entities in the future(not
only **User**) we have to access the field some other way. One thing that can
help us is **Annotations**.

Create 3 annotations **Entity**, **Column** and **Id.**

<img src="https://user-images.githubusercontent.com/32310938/65392443-b7741780-dd7d-11e9-9515-655af051029c.png" alt="alt text" width="450" height="">

**Annotate entities and their corresponding fields.** In the **Entity**
annotation specify the name of the database table you want to be mapped –
**users** and in **Column** – the corresponding table column name to the java
field.

We are going to need a new additional method **getId(Class entity)** in the
**EntityManager** class. It will return the **id** field via reflection:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392481-176abe00-dd7e-11e9-981f-44513e64141b.png" alt="alt text" width="900" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392487-27829d80-dd7e-11e9-9c03-d0aebe341222.png" alt="alt text" width="500" height=""></kbd>

If returned value is null we need to do an insert, otherwise update. So far the
persist method should look like this:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392487-27829d80-dd7e-11e9-9c03-d0aebe341222.png" alt="alt text" width="500" height=""></kbd>

We need to implement 2 more methods:

-   **private boolean doInsert(E entity, Field primary)**

-   **private boolean doUpdate(E entity, Field primary)**

Both methods would prepare query statements and execute them.

The difference between them is when you insert new entity you should **set its
id**. The **Id** is generated on database level. Both methods return whether the
entity was successfully persisted.

Here are some tips for the Insert method:

-   Get the table name you will be inserting into

-   Start joining the components of your query – **INSERT** clause, table name +
    fields, **VALUES** and the corresponding values for the insertion

    **HINT**: Iterate over entity’s fields

-   Prepare and execute statement via the connection

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392513-6dd7fc80-dd7e-11e9-9839-8b9f81742628.png" alt="alt text" width="700" height=""></kbd>

And some tips for the update method:

-   Get the table name you will be updating into

-   Start joining the components of your query – **UPDATE** clause, table name,
    **SET**, **WHERE** and the given predicate

    **HINT**: Iterate over entity’s fields and add “id = {entity’s id value}” to
    **WHERE** clause

-   Prepare and execute statement via the connection

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392517-76c8ce00-dd7e-11e9-81a7-bb21d6c4fccf.png" alt="alt text" width="700" height=""></kbd>

6 Fetching Results
------------------

Finally, when we have persisted our entities (objects) in the database let ‘s
implement functionality to **get them out of the database and persist them in
the operating memory**. We would implement just several methods. That would be
**all Find methods from the DbContext**.

Here are some tips of how to implement **public E findFirst(Class\<E\> table,
String where)** the other ones are similar and they would be on you.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392519-7defdc00-dd7e-11e9-94fd-b271a9c1e27f.png" alt="alt text" width="600" height=""></kbd>

Here you can see that we used a new method **fillEntity**. That method receives
a **ResultSet** object, **retrieves information from the current row** of the
reader and fills the data. Create two methods:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392522-8a743480-dd7e-11e9-8343-04582496e3fe.png" alt="alt text" width="600" height=""></kbd>

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392525-8ea05200-dd7e-11e9-9bb1-5a7c64a6ec5f.png" alt="alt text" width="700" height=""></kbd>

Both methods cooperate closely. **FillEntity** calls for **fillField** and
passes the entity which fields have to be filled, current field, the
**ResultSet** object from which we will get information and field’s **Column**
annotation name, which will give us access to the value in the **ResultSet**.

7 Test Framework
----------------

If you came to this point you are done with building the **first part** of our
MiniORM. Now let’s test it to make sure it works as expected. Create several
users and persist them in the database. Then update some of the properties of
the users (e.g., change password or increase age or some other change). Remember
you need to use the persist method to commit changes of the object to the
database. Make sure the data is always updated in the database. Here is some
example of usage:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392528-965ff680-dd7e-11e9-903c-5b5c560f892d.png" alt="alt text" width="800" height=""></kbd>

8 Fetch Users
-------------

Insert several users in the database and **print the usernames and passwords**
of those who are **registered after 2010** year and are **at least 18 years
old**.

Lab: Workshop – MiniORM Part 2
==============================

This document defines the lab assignments for the ["DB Advanced" course \@
Software](https://softuni.bg/courses/databases-advanced-hibernate) University.

Since you’ve come to this point it is considered that you have fully finished
Part 1 of our Mini ORM. By following the guidelines of this document you will
add more functionality to the framework like create, delete and so on.

One of the things our framework cannot do to this moment is to create a table.
In big applications schema manipulation is done with a default configuration of
the framework, **depending on our development**. What does that mean?

When we have our app **running** and users actively **using** it, we
rarely(almost never) want to lose or drop our data. Thus why complex ORMs like
Hibernate or Entity, look for **changes in the models**(e.g. **User**)
constantly and if set **update the structure** of the tables.

1 Create Table
--------------

Creation of the tables will be done by the **EntityManager** object that we’ve
already implemented. It should be able to parse the fields in our models to
table columns – set appropriate data type, name(from **Column** annotation) and
constraints.

Begin by creating such method **doCreate(Class entity)**:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392946-66ffb880-dd83-11e9-9f01-87bd0a1afb2e.png" alt="alt text" width="500" height=""></kbd>"

The method has several simple steps that has to perform:

-   Get the table name that should be created

-   Start building a query

-   **Scan model’s declared fields** and **map** them to annotated names and
    **MySQL data types**

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392947-70892080-dd83-11e9-986d-8da1de85f4be.png" alt="alt text" width="600" height=""></kbd>

Data types mapping is very similar to the **fillField** method. You can do it by
creating a helper method **getDBType(Field field)** and use it in the iteration
of the entity’s fields.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392951-7848c500-dd83-11e9-8691-61627ea1bf7f.png" alt="alt text" width="400" height=""></kbd>

### Hints

For example java **int** or **Integer** type is mapped to the “**INT**” SQL
type, String to “**VARCHAR(…)**” and so on.

Consider when you should check the need of table creation. Sometimes we might
need a simple alter and just add fields to already existing tables. If we drop
and create new table we might lose important information about already existing
users, no matter if the new fields are left blank after alter.

2 Test Create
-------------

Create a new custom entity and try to persist it with the **EntityManager**

3 Alter Table
-------------

In most cases when our application is running, we need to just **ALTER** the
tables and add new model fields.

A new private method is needed:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392956-839bf080-dd83-11e9-9a75-50263b41d304.png" alt="alt text" width="600" height=""></kbd>

And a helper one to let us know if the field that we will be trying to insert
doesn’t exist already:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65392957-8565b400-dd83-11e9-8efc-2d09b119c7fb.png" alt="alt text" width="700" height=""></kbd>

Information about the columns of a table can be retrieved from the
**information_schema** of the database server. It is an object where each MySQL
instance stores information about all the other databases that the MySQL server
maintains. Its is also referred to as the data dictionary and system catalog.

### Hints

-   Get information about existing tables and their columns from
    **information_schema**

-   Use the **ResultSet** class to check if retrieved fields by **COLUMN_NAME**

4 Test Alter
------------

Add new fields to already existing entity class(you can use the one made from
3.) and try to persist a new object.

5 Delete 
--------

Try implementing the last CRUD operation – the delete.

### Hints

Create a method that receives database column and delete criteria as parameters,
very similar to the find methods and delete records matching given criteria.

<br/>

### Solution: <a title="MiniORM" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/07%20WORKSHOP%20CREATING%20CUSTOM%20ORM/Mini-ORM/src/main/java/app">MiniORM</a>

---