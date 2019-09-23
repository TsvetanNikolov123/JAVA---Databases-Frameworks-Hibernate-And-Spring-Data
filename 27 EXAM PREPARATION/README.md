Databases Advanced Exam 
========================
Most Wanted(MVC)
================

Racing has become an essential part of some people’s life. It’s the energy that
flows through their veins. However, some races get out of control creating
massive traffic disasters, which forced the Laws to create The ARPU – Anti-Race
Police Unit… A specialized unit, which does not spare even a penny, when it
comes to stopping races. Their performance tuned cars are on par with most
racers’ cars and they aren’t afraid of crashing them.

1.Functionality Overview
----------------------

The ARPU has hired you as their database developer, to implement a **database
application**. The application should be able to easily **import**
hard-formatted data from **XML** and **JSON** and **support functionality** for
also **exporting** into the imported data. The application is called – **Most
Wanted**.

Look at the pictures below to see what must happen:

-   Home page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448074-a6400f00-de40-11e9-9858-815b26d4c7ee.png" alt="alt text" width="900" height=""></kbd>

-   Import JSON page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448165-da1b3480-de40-11e9-8224-cf9eb4580d33.png" alt="alt text" width="900" height=""></kbd>

-   Import XML page before importing anything:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448185-e606f680-de40-11e9-85c2-21d1fe97973d.png" alt="alt text" width="900" height=""></kbd>

-   Import Towns page after reading the **towns.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448207-f6b76c80-de40-11e9-88dd-b55d3cc48b5d.png" alt="alt text" width="900" height=""></kbd>"

-   Import Districts page after reading the **districts.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448229-020a9800-de41-11e9-9c32-7913fa1f818a.png" alt="alt text" width="900" height=""></kbd>

-   Import Racers page after reading the **racers.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448245-0c2c9680-de41-11e9-9d2e-9c60699cb9d5.png" alt="alt text" width="900" height=""></kbd>

-   Import Cars page after reading the **cars.json** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448265-18b0ef00-de41-11e9-9dad-340f12ebcc16.png" alt="alt text" width="900" height=""></kbd>

-   Import Race Entries page after reading the **race-entries.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448286-249cb100-de41-11e9-8595-0d1e0131ecb7.png" alt="alt text" width="900" height=""></kbd>

-   Import Races page after reading the **races.xml** file:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448300-2ebeaf80-de41-11e9-9af2-2bae476f35cc.png" alt="alt text" width="900" height=""></kbd>

-   Import JSON page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448323-38481780-de41-11e9-807b-9e9522407f68.png" alt="alt text" width="900" height=""></kbd>

-   Import XML page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448340-3ed68f00-de41-11e9-9aed-e1bc6939af3e.png" alt="alt text" width="900" height=""></kbd>

-   Home page after importing the given data:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448359-485ff700-de41-11e9-8e3d-74254e1dce44.png" alt="alt text" width="900" height=""></kbd>

-   Export Racing Towns page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448730-2e72e400-de42-11e9-86ed-8538986e6892.png" alt="alt text" width="900" height=""></kbd>

-   Export Racing Cars page:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448734-303ca780-de42-11e9-90da-194cc61a0b22.png" alt="alt text" width="900" height=""></kbd>

2.Project Skeleton Overview
-------------------------

You will be given a **Skeleton**, containing a **certain architecture** with
**several classes**, some of which – completely empty. The **Skeleton** will
include the **files** with which you will **seed** the **database**.

3.Model Definition
----------------

There are 6 main models that the **Most Wanted** database application should
contain in its functionality.

Design them in the **most appropriate** way, considering the following **data
constraints**:

### Town

-   **id** – **integer** number, **primary identification field**.

-   **name** – a **string** (**required, unique**).

### District

-   **id** – **integer** number, **primary identification field**.

-   **name** – a **string** (**required, unique**).

-   **town** – a **Town** entity.

### Racer

-   **id** – **integer** number, **primary identification field**.

-   **name** – a **string** (**required, unique**).

-   **age** – an **integer** number.

-   **bounty** – a **decimal** data type.

-   **homeTown** – a **Town** entity.

-   **cars** – a collection of **Car** entity.

### Car

-   **id** – **integer** number, **primary identification field**.

-   **brand** – a **string** (**required**).

-   **model** – a **string** (**required**).

-   **price** – a **decimal** data type.

-   **yearOfProduction** – an **integer** number (**required**).

-   **maxSpeed** – a **floating-point** data type.

-   **zeroToSixty** – a **floating-point** data type.

-   **racer** – a **Racer** entity.

### Race

-   **id** – **integer** number, **primary identification field**.

-   **laps** – **integer** number (**required**, **default** – **0**)

-   **district** – a **District** entity (**required**).

-   **entries** – a collection of **RaceEntry** entity.

### RaceEntry

-   **id** – **integer** number, **primary identification field**.

-   **hasFinished** – a **boolean** value.

-   **finishTime** – a **floating-point** data type.

-   **car** – a **Car** entity.

-   **racer** – a **Racer** entity.

You are also given an E/R Diagram for better understanding of the database:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448742-33d02e80-de42-11e9-8cee-95e27f53d74c.png" alt="alt text" width="900" height=""></kbd>

4.Data Import 
-------------

Use the provided **JSON** and **XML** files to populate the database with data.
Import all the information from those files into the database.

**You are** not allowed **to modify the provided JSON and XML files.**

**ANY UNALLOWED DUPLICATE** data should be **ignored** and a message “**Error:
Duplicate Data!**” should be printed.

**ANY INCORRECT** data should be **ignored** and a message “**Error: Incorrect
Data!**” should be printed.

**ANY SUCCESSFUL** data import should **result** in a message “**Successfully
imported {entityClass} – {entityField}.**”.

The **entityField** depends on the **entityClass**:

-   For **Towns**, **Districts**, **Racers** – **{name}**.

-   For **Cars** – a string **composed** in the following format – “**{brand}
    {model} \@ {yearOfProduction}**”

-   For **Race**, **RaceEntry** – **{id}**;

### JSON Import (10 pts)

#### Towns (towns.json)

| **towns.json**                                                                       |
|--------------------------------------------------------------------------------------|
    [
    	{ "name" : "München" },
    	{ "name" : "Maastricht" },
          . . .
    ]
---
    Successfully imported Town - München.
    Successfully imported Town - Maastricht.
    . . .



#### Districts (districts.json)

| **districts.json**                                                                                           |
|--------------------------------------------------------------------------------------------------------------|
    [
    	{ "name" : "Larry", "townName" : "Maastricht" },
    	{ "name" : "Transport", "townName" : "München" },
          . . .
    ]
---
    Successfully imported District - Larry.
    Successfully imported District - Transport.
    . . .


#### Racers (racers.json)

| **racers.json**                                                                                      |
|------------------------------------------------------------------------------------------------------|
    [
    	{ 
    		"name" : "Clarence Callahan", 
    		"age" : 34,
    		"bounty" : 164177.22,
    		"townName" : "Troyes"
    	},
          . . .
    ]
---
    Successfully imported Racer - Clarence Callahan.
    . . .


#### Cars (cars.json)

| **cars.json**                                                                                                                                                               |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    [
    	{ 
    		"brand" : "Volvo", 
    		"model" : "C70", 
    		"price" : 487452.02, 
    		"yearOfProduction" : 2010, 
    		"maxSpeed" : 161.6, 
    		"zeroToSixty" : 2.24, 
    		"racerName" : "Brigit Speller"
    	},
          . . .
    ]
---
    Successfully imported Car - Volvo C70 @ 2010.
    . . .


### XML Import

The ARPU are not very smart, so their data seeds are quite messed up.  
You will need to **import** the **RaceEntries** first, and then import all
**Races** with their **entries**.

#### Race Entries (race-entries.xml)

| **race-entries.xml**                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <race-entries>
        <race-entry has-finished="true" finish-time="741.12" car-id="269">
            <racer> Max Philpott</racer>
        </race-entry>
        <race-entry has-finished="false" finish-time="822.96" car-id="242">
            <racer> Wylie Gareisr</racer>
        </race-entry>
        <race-entry has-finished="true" finish-time="156.57" car-id="220">
            <racer> Murial Jedrzejewicz</racer>
        </race-entry>
        ...
    </race-entries>
---
    Successfully imported RaceEntry - 1.
    Successfully imported RaceEntry - 2.
    Successfully imported RaceEntry - 3.
    . . .



#### Races (races.xml)

| **races.xml**                                                                                                                                                                                                  |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    <?xml version="1.0" encoding="utf-8"?>
    <races>
        <race>
            <laps>4</laps>
            <district-name>Jackson</district-name>
            <entries>
                <entry id="10">
                <entry id="9">
            </entries>
        </race>
        ...
    </races>
---
    Successfully imported Race - 1.
    . . .


5.Data Export 
------------

Get ready to export the data you’ve imported in the previous task. Here you will
have some pretty complex database querying.

#### Racing Towns

**Export all towns** which have **any racers** in them:

-   **Export** only the **town name** (as **name**) and **count of racers** (as
    **racers**).

-   **Order** them **descending**, by **count** of **racers** they have, and
    then by **town name alphabetically**.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448882-7a258d80-de42-11e9-9efb-105251dfe4e9.png" alt="alt text" width="600" height=""></kbd>

#### Racing Cars 

**Export all racers** which **have any cars**:

-   **Export** the racer’s **name**, **age** (but **ONLY** if it is **NOT
    NULL**), **list** of **cars**.

    -   In case the **racer’s age** property is **NULL**, do **NOT** include it.

-   The **cars** should be **strings** in the following format: “**{brand}
    {model} {yearOfProduction}**”.

-   **Order** them **descending**, by **count** of **cars** they have, and then
    by **racer name alphabetically**.

<kbd><img src="https://user-images.githubusercontent.com/32310938/65448737-32066b00-de42-11e9-992c-605473e46f6a.png" alt="alt text" width="600" height=""></kbd>

<br/>

### Solution: <a title="Most Wanted(MVC)" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/27%20EXAM%20PREPARATION/MostWanted">Most Wanted(MVC)</a>

---