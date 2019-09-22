18 Exercises: Spring Data Auto Mapping Objects
==============================================

---
---

This document defines the exercise assignments for the [“Databases Frameworks”
course \@ SoftUni](https://softuni.bg/courses/databases-advanced-hibernate).

---

SoftUni Game Store
==================

The game store is a platform, where the users can buy games. Your task is to
create a console application for the store.

Data Models
-----------

Create the required **entities**. Use appropriate **data types**.

-   The system contains information about **users** and **games**.

-   Users can **register** in the system. After successful registration, the
    user has **email, password, full name, list of games** and information
    whether he/she is an **administrator or not**.

-   The **first registered user** becomes also an **administrator**. You can
    manually mark users as admins in the database.

-   A **game** has **title**, **trailer** (YouTube Video Id), **image
    thumbnail** (URL), **size**, **price, description** and **release date**

-   Users can buy games and make **orders.** Each order has a **single buyer
    (user)** and one or many products.

Functionality
--------------

-   **All users** can view all games.

-   **All users** can view details of each game.

-   **Logged-in users** can logout.

-   **Logged in users** can add/remove games from their shopping cart.

-   **Logged in users** can buy games that are added to the shopping cart and
    those games are added to the profile of the user and cannot be bought for
    second time.

-   **Administrators** can add, edit or delete games.

-   Basic user **can not** add, edit or delete game.

1 Design the Database
-------------------

Design **entity classes** and create a **database** to hold the **users**,
**games** and **orders**.

2 Implement User Registration, Login and Logout
---------------------------------------------

The guest users can register and log in.

-   **RegisterUser\|\<email\>\|\<password\>\|\<confirmPassword\>\|\<fullName\>**
    - This command adds new user to the database in case of valid parameters.
    Otherwise, prints appropriate message informing why the user cannot be
    registered. The requirements for valid parameters are:

    -   **Email** – must contain **\@ sign** and a **period**. It must be
        unique.

    -   **Password** – length must be **at least 6 symbols** and must contain at
        least **1 uppercase**, **1 lowercase** letter and **1 digit**.

    -   **Confirm Password** – must **match** the provided password.

-   **LoginUser\|\<email\>\|\<password\>** - This command sets the current
    logged in user if it exists. Otherwise, prints an appropriate message.

Logged in user can logout.

-   **Logout** – This command logs out the user from the system. If there is no
    logged in user, print appropriate message.

### Example

| **Input**                                                                                                                         | **Output**                                                                                    |
|-----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| RegisterUser&#124;<ivan@ivan.com>&#124;Ivan12&#124;Ivan12&#124;Ivan <br/> LoginUser&#124;<ivan@ivan.com>&#124;Ivan12 <br/> Logout | Ivan was registered <br/> Successfully logged in Ivan <br/> User Ivan successfully logged out |
| RegisterUser&#124;ivangmail.com&#124;Ivan12&#124;Ivan12&#124;Ivan                                                                 | Incorrect email.                                                                              |
| LoginUser&#124;<ivan@ivan.com>&#124;Ivan                                                                                          | Incorrect username / password                                                                 |
| LogoutUser                                                                                                                        | Cannot log out. No user was logged in.                                                        |

3 Implement Managing Games
--------------------------

As an admin, you have the option to **add/edit/delete games to the catalog**.

-   **AddGame\|\<title\>\|\<price\>\|\<size\>\|\<trailer\>\|\<thubnailURL\>\|\<description\>\|\<releaseDate\>**

-   **EditGame\|\<id\>\|\<values\> -** A game should be edited in case of valid
    id. Otherwise, print appropriate message.

A game should be added/edited only to the catalog, if it matches the following
criteria:

-   **Title** – has to begin with an **uppercase letter** and must have length
    between **3 and 100 symbols** (inclusively).

-   **Price** – must be a **positive number** with precision up to **2 digits**
    after the floating point.

-   **Size** – must be a **positive number** with precision up to **1 digit**
    after the floating point.

-   **Trailer** – only videos from YouTube are allowed. Only their **ID**, which
    is a string of exactly **11 characters,** should be saved to the database.

    For example, if the URL to the trailer is
    **https://www.youtube.com/watch?v=edYCtaNueQY**, the required part that must
    be saved into the database is **edYCtaNueQY**. That would be always the last
    11 characters from the provided URL.

-   **Thumbnail URL** – it should be a plain text starting with **http://**,
    **https://** or **null**

-   **Description** – must be at least 20 symbols

-   **DeleteGame\|\<id\> -** A game should be deleted in case of valid id.
    Otherwise, print an appropriate message.

### Example

| **Input**                                                                                                                                                                                                                                                                                                                                                                           | **Output**                                                     |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| AddGame&#124;Overwatch&#124;100.00&#124;15.5&#124;FqnKB22pOC0&#124; <br/> https://us.battle.net/forums/static/images/social-thumbs/overwatch.png&#124;Overwatch is a team-based multiplayer online first-person shooter video game developed and published by Blizzard Entertainment.&#124;24-05-2016 <br/> EditGame&#124;1&#124;price=80.00&#124;size=12.0 <br/> DeleteGame&#124;1 | Added Overwatch&#124; Edited Overwatch&#124; Deleted Overwatch |

4 Implement View Games 
----------------------

Implement a view for retrieving different information about the games.

-   **AllGame** - print **titles and price** of all games.

-   **DetailsGame\|\<gameTitle\>** - print details for а single game.

-   **OwnedGames** – print the games bought by the **currently logged in user**.

### Example

| **Input**                 | **Output**                                                                                                                                                                                                            |
|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| AllGame                   | Overwatch 80.00 <br/> Assassin’s Creed 70.00 <br/> Tomb Raider 80.00 <br/> ...                                                                                                                                        |
| DetailGame&#124;Overwatch | Title: Overwatch <br/> Price: 80.00 <br/> Description: Overwatch is a team-based multiplayer online first-person shooter video game developed and published by Blizzard Entertainment. <br/> Release date: 24-05-2016 |
| OwnedGame                 | Overwatch <br/> Assassin's Creed <br/> …                                                                                                                                                                              |

5 Implement Shopping Cart\*
---------------------------

Each user should be able to buy a game.

-   **AddItem\|\<gameTitle\> -** add game to shopping cart.

-   **RemoveItem\|\<gameTitle\> -** remove game from shopping cart.

-   **BuyItem –** buy all games from shopping cart.

-   A user can **buy** a game **only once**!

-   If he owns a game, he **shouldn't be able to add** it to the shopping cart.

### Example

| **Input**                                                                                         | **Output**                                                                                                                             |
|---------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| AddItem&#124;Overwatch <br/> RemoveItem&#124;Overwatch <br/> AddItem&#124;Overwatch <br/> BuyItem | Overwatch added to cart. <br/> Overwatch removed from cart. <br/> Overwatch added to cart. <br/> Successfully bought games: -Overwatch |
<br/>

### Solution: <a title="SoftUni Game Store" href="https://github.com/TsvetanNikolov123/JAVA---Databases-Frameworks-Hibernate-And-Spring-Data/tree/master/18%20EXERCISE%20SPRING%20DATA%20AUTO%20MAPPING%20OBJECTS/GameStore/src/main/java/gamestore">SoftUni Game Store</a>

---