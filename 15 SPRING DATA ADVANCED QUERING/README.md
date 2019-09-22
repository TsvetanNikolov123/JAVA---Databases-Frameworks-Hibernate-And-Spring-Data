15 Lab: Spring Data Advanced Querying
=====================================

---
---

This document defines the lab assignments for the [“Databases Frameworks” course
at Software
University](https://softuni.bg/courses/databases-advanced-hibernate).

You are **given** a simpler implementation of the **Shampoo Company**. Now it’s
time to start writing some query methods to retrieve data.  
**Before you start, insert the data from the “shampoo-company-insert.sql”
file!**

---

15.01 Select Shampoos by Size
-----------------------------

Create a method that selects all shampoos with a **given size**, **ordered by
shampoo id.**

### Example:

| **Input** | **Output**                                                                                                                                                                                                                                                                                                                                                                   |
|-----------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MEDIUM    | Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv. <br/> Volume & Fullness Lavender MEDIUM 5.50lv. <br/> Rose Shine & Hydration MEDIUM 6.50lv. <br/> Color Protection & Radiance MEDIUM 6.75lv. <br/> Heavenly Long Long-Hair MEDIUM 7.50lv. <br/> Sea Buckthorn Vital MEDIUM 6.50lv. <br/> Fresh it Up! MEDIUM 7.65lv. <br/> Nectar Nutrition MEDIUM 6.85lv. |

15.02 Select Shampoos by Size or Label
--------------------------------------

Create a method that selects all shampoos with a **given size or label id**.
Sort the result **ascending by price**.

### Example:

| **Input** | **Output**                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|-----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MEDIUM    | Volume & Fullness Lavender MEDIUM 5.50lv. <br/> Intense-Charm Brunette SMALL 5.50lv. <br/> Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv. <br/> Rose Shine & Hydration MEDIUM 6.50lv. <br/> Sea Buckthorn Vital MEDIUM 6.50lv. <br/> Color Protection & Radiance MEDIUM 6.75lv. <br/> Nectar Nutrition MEDIUM 6.85lv. <br/> Heavenly Long Long-Hair MEDIUM 7.50lv. <br/> Fresh it Up! MEDIUM 7.65lv. <br/> Active-Caffeine SMALL 7.80lv. |
| 10        |                                                                                                                                                                                                                                                                                                                                                                                                                                                             |

15.03 Select Shampoos by Price
------------------------------

Create a method that selects all shampoos, which price is **higher than a given
price**. Sort the result **descending by price**.

### Example:

| **Input** | **Output**                                                                                                                                                                                                                                                                                                                                                                                                      |
|-----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 5         | Superfruit Nutrition LARGE 13.80lv. <br/> Cotton Fresh LARGE 13.60lv. <br/> Color Protection & Radiance LARGE 11.50lv. <br/> Rose Shine & Hydration LARGE 10.70lv. <br/> Nectar Nutrition LARGE 10.50lv. <br/> Keratin Strong SMALL 8.80lv. <br/> Superfruit Nutrition SMALL 8.80lv. <br/> Cotton Fresh SMALL 8.80lv. <br/> Keratin Strong LARGE 8.80lv. <br/> Volume & Fullness Lavender LARGE 8.50lv. <br/> … |

15.04 Select Ingredients by Name
--------------------------------

Create a method that selects all **ingredients**, which **name starts with given
letters**.

### Example:

| **Input** | **Output**                                                |
|-----------|-----------------------------------------------------------|
| M         | Macadamia Oil <br/> Mineral-Collagen <br/> Micro Crystals |

15.05 Select Ingredients by Names
---------------------------------

Create a method that selects all **ingredients**, which are **contained in a
given list**. Sort the result **ascending by price**.

### Example:

| **Input**                        | **Output**                       |
|----------------------------------|----------------------------------|
| Lavender <br/> Herbs <br/> Apple | Apple <br/> Lavender <br/> Herbs |

15.06 Count Shampoos by Price
-----------------------------

Create a method that **counts all shampoos** with **price lower than a given
price**.

### Example:

| **Input** | **Output** |
|-----------|------------|
| 8.50      | 15         |

JPQL Querying
=============

15.07 Select Shampoos by Ingredients
------------------------------------

Create a method that selects all **shampoos with ingredients** included in a
**given list**.

### Example:

| **Input**                    | **Output**                                                                                                                                                                                       |
|------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Berry <br/> Mineral-Collagen | Color Protection & Radiance <br/> Fresh it Up! <br/> Nectar Nutrition <br/> Superfruit Nutrition <br/> Color Protection & Radiance <br/> Nectar Nutrition <br/> Superfruit Nutrition <br/> . . . |

15.08 Select Shampoos by Ingredients Count
------------------------------------------

Create a method that selects all **shampoos with ingredients less than a given
number**.

### Example:

| **Input** | **Output**                                                                                                      |
|-----------|-----------------------------------------------------------------------------------------------------------------|
| 2         | Moroccan Argan Oil & Macadamia <br/> Volume & Fullness Lavender <br/> Sea Buckthorn Vital <br/> Active-Caffeine |

15.09 Select Ingredient Name and Shampoo Brand By Name
------------------------------------------------------

Create a method that selects **all shampoo names and their ingredients prices**.
Use named query.

| **Input**    | **Output** |
|--------------|------------|
| Silk Comb    | 1.80       |
| Fresh it up! | 1.40       |

15.10 Delete Ingredients by name
--------------------------------

Create a method that **deletes ingredients by a given name**. Use named query.

15.11 Update Ingredients by price
---------------------------------

Create a method that **increases the price of all ingredients by 10%**. Use
named query.

15.12 Update Ingredients by Names
---------------------------------

Create a method that **updates the price** of all ingredients, which names are
in a given list.

<br/>

### Solution: <a title="Lab Solutions" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/blob/master/15%20SPRING%20DATA%20ADVANCED%20QUERING/AdvancedQuerying/src/main/java/advancedquerying/controller/AppController.java">Lab Solutions</a>

---