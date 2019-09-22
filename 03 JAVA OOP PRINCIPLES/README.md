03 Lab: Interfaces and Abstraction
==================================

Problems for exercises and homework for the
[.](https://softuni.bg/courses/java-oop-advanced)

03.01 Shapes Drawing
--------------------

Build hierarchy of interfaces and classes:

<img src="https://user-images.githubusercontent.com/32310938/65385732-af46b880-dd3a-11e9-8eb0-966e9a60ca40.png" alt="alt text" width="600" height="">

You should be able to use the class like this:

| Main.java                                                                                                                                                                                                                                                                                                                                                                                                  |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            queue.add(Integer.parseInt(scanner.nextLine()));
        }
    
        Drawable circle = new Circle(queue.poll(), queue.poll(), queue.poll());
        Drawable rect = new Rectangle(queue.poll(), queue.poll());
    
        circle.draw();
        rect.draw();
    }


### Examples

<img src="https://user-images.githubusercontent.com/32310938/65385783-36942c00-dd3b-11e9-8fe7-3bae4df818ec.png" alt="alt text" width="300" height="">

### Solution

For circle drawing you can use this algorithm:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65385810-8a9f1080-dd3b-11e9-8791-c3e73cbdfefd.png" alt="alt text" width="600" height=""></kbd>

For rectangle drawing algorithm will be:

<kbd><img src="https://user-images.githubusercontent.com/32310938/65385811-8b37a700-dd3b-11e9-88c8-defd4bebe183.png" alt="alt text" width="450" height=""></kbd>

<br/>

### Solution: <a title="" href=""></a>

---
03.02 Car Shop
--------------

Build hierarchy from classes and interfaces for this UML diagram

<img src="https://user-images.githubusercontent.com/32310938/65386163-8c1f0780-dd40-11e9-910b-e038c7a9dc3f.png" alt="alt text" width="600" height="">

Your hierarchy have to be used with this code

| Main.java                                                                                                                                                                                                                                                                                     |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    public static void main(String[] args) {
        Car seat = new Seat("Leon", gray", 110, "Spain");
    
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                seat.getModel(),
                seat.getColor(),
                seat.getHorsePower()));
        System.out.println(seat.toString());
    }


### Examples

| **Input** | **Output**                                                                            |
|-----------|---------------------------------------------------------------------------------------|
|           | Leon is gray and have 110 horse power This is Leon produced in Spain and have 4 tires |

### Sample Solution

<kbd><img src="https://user-images.githubusercontent.com/32310938/65386185-c2f51d80-dd40-11e9-9f79-e8ad9da0fedf.png" alt="alt text" width="400" height=""></kbd>
<br/>

### Solution: <a title="" href=""></a>

---
03.03 Car Shop Extend
---------------------

Extend previous problem:

<img src="https://user-images.githubusercontent.com/32310938/65386397-e66d9780-dd43-11e9-9386-fbd428e453d8.png" alt="alt text" width="600" height="">

Your hierarchy have to be used with this code

| Main.java                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("Leon", "Gray", 110, "Spain", 3, 99.9);
    
        printCarInfo(seat);
        printCarInfo(audi);
    }
    
    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }


### Examples

| **Input** | **Output**                                                                            |
|-----------|---------------------------------------------------------------------------------------|
|           | Leon is gray and have 110 horse power This is Leon produced in Spain and have 4 tires |
<br/>

### Solution: <a title="" href=""></a>

---
03.04 Say Hello
---------------

Build hierarchy from classes and interfaces for this UML diagram

<img src="https://user-images.githubusercontent.com/32310938/65386426-48c69800-dd44-11e9-9a54-4359ea969859.png" alt="alt text" width="800" height="">

Your hierarchy have to be used with this code

| Main.java                                                                                                                                                                                                                                                                                                                                             |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
    
        
        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));
    
        for (Person person : persons) {
            print(person);
        }
    }
    
    private static void print(Person person) {
        person.sayHello();
    }


### Examples

| **Input** | **Output**                            |
|-----------|---------------------------------------|
|           | Здравей <br/> Hello <br/> Djydjybydjy |
<br/>

### Solution: <a title="" href=""></a>

---
04.05 Say Hello Extend
----------------------

Build hierarchy from classes and interfaces for this UML diagram

<img src="https://user-images.githubusercontent.com/32310938/65386458-a1963080-dd44-11e9-937b-ebc62bc41669.png" alt="alt text" width="800" height="">

Your hierarchy have to be used with this code

| Main.java                                                                                                                                                                                                                                                                                                                                             |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
    
        
        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));
    
        for (Person person : persons) {
            print(person);
        }
    }
    
    private static void print(Person person) {
        person.sayHello();
    }


### Examples

| **Input** | **Output**                            |
|-----------|---------------------------------------|
|           | Здравей <br/> Hello <br/> Djydjybydjy |
<br/>

### Solution: <a title="" href=""></a>

---