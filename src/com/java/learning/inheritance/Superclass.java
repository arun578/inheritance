package com.java.learning.inheritance;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by  preeti on 3/30/22 at 4:35 PM.
 */
//Parent class
class Superclass {
    String name;
    int num;

    // A method which prints the data of the parent class
    void showMessage()
    {
        System.out.println("Parent method is called");
    }

    void showMessage(String name, int num)
    {
        System.out.println("Parent method is called");
    }
    int showMessage(int num, String name)
    {
        System.out.println("Parent method is called");

        return 0;
    }



}

// Child class
class Child extends Superclass {
    int age;

    // Performing overriding
    @Override
    void showMessage()
    {
        System.out.println("Child method is called");
    }

    int showMessage(int num, String name)
    {
        System.out.println("Parent method is called");

        return 0;
    }


}

class Downcasting{

    public static void main(String[] args)
    {
        Superclass p = new Child();
        p.name = "Shubham";

        // Performing Downcasting Implicitly
        //Child c = new Parent(); // it gives compile-time error

        // Performing Downcasting Explicitly
        Child c = (Child)p;

        c.age = 18;
        System.out.println(c.name);
        System.out.println(c.age);
        c.showMessage();
    }
}


 interface Animal {

    default String identifyMyself() {
        return "I am an animal.";
    }
     static String identifyMyself1() {
         return "I am able to lay eggs in FireBreather.1 in Animal";
     }
}

 interface EggLayer extends Animal {
    default String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

 interface FireBreather extends Animal {
     default String identifyMyself() {
         return "I am able to lay eggs in FireBreather.";
     }
     static String identifyMyself1() {
         return "I am able to lay eggs in FireBreather.1";
     }
 }


 class Dragon implements EggLayer, FireBreather {
    public String identifyMyself(){
        return Animal.identifyMyself1();
    }

     public static void main (String... args) {
         Dragon myApp = new Dragon();
         System.out.println(FireBreather.identifyMyself1());
         System.out.println(Animal.identifyMyself1());

     }

}

class Animal1 {
    public int num = 10;
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

class Cat extends Animal1 {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
    public void method(){
        System.out.println("In Cat method");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal1 myAnimal = myCat;
        Cat cat = new Cat();
        Animal1.testClassMethod();
        myAnimal.testInstanceMethod();
        cat.method();//myAnimal object don't have this method
    }
}

class BaseClass{
    int num=10;
    int hiddenField=11;
}

class ChildClass extends BaseClass{
    int hiddenField=15;

    public static void main(String[] args) {
        new ChildClass().method();
    }

    void method(){
        System.out.println("accessing num "+num);
        System.out.println("Accessing hidden method of Childclass "+ hiddenField);
        System.out.println("Accessing hidden method of BaseClass "+ super.hiddenField);
    }
}
class Superclass1 {
    Superclass1(){}

    public void printMethod() {
        System.out.println("Printed in Superclass.");
    }
}

class Subclass extends Superclass1 {

    int a;

    Subclass(){}
    Subclass(int a){
        a=10;
    }

    // overrides printMethod in Superclass
    public void printMethod() {
        //super.printMethod();
        System.out.println("Printed in Subclass");
    }
    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();
        System.out.println("tostring() representation is "+s.hashCode() + s.getClass());
        System.out.println("tostring() representation is "+s.hashCode() + s.getClass().getSimpleName().toLowerCase());
        String string = "Arun";
        string = "abc";
        System.out.println("Value of String variable is "+ string);
        System.out.println(string.hashCode());
        int[]  x= {10};
    }
}

// A Java program to demonstrate
// shallow copy using clone()

// An object reference of this class is
// contained by Test2
class TestClone {
    int x, y;
}

// Contains a reference of Test and
// implements clone with shallow copy.
class TestClone2 implements Cloneable {
    int a;
    int b;
    Test c = new Test();
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Driver class
class Main1 {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        TestClone2 t1 = new TestClone2();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        TestClone2 t2 = (TestClone2)t1.clone();

        // Creating a copy of object t1
        // and passing it to t2
        t2.a = 100;

        // Change in primitive type of t2 will
        // not be reflected in t1 field
        t2.c.x = 300;

        // Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x
                + " " + t2.c.y);
    }
}



class Student18 implements Cloneable{
    int rollno;
    String name;

    Student18(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    protected Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args){
        try{
            Student18 s1=new Student18(101,"amit");

            Student18 s2=(Student18)s1.clone();
            s2.name = "arun";

            System.out.println(s1.rollno+" "+s1.name + " hashcode " + s1.hashCode());
            System.out.println(s2.rollno+" "+s2.name + " hashcode " + s2.hashCode());


        }catch(CloneNotSupportedException c){}

    }
}



// A Java program to demonstrate
// shallow copy using clone()
//import java.util.ArrayList;

// An object reference of this class is
// contained by Test2
class Test {
    int x, y;
}

// Contains a reference of Test and
// implements clone with shallow copy.
class Test2 implements Cloneable {
    int a;
    int b;
    Test c = new Test();
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Driver class
class Main {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Test2 t1 = new Test2();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        Test2 t2 = (Test2)t1.clone();

        // Creating a copy of object t1
        // and passing it to t2
        t2.a = 100;

        // Change in primitive type of t2 will
        // not be reflected in t1 field
        t2.c.x = 300;

        // Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x
                + " " + t2.c.y);
    }

}

abstract class GraphicObject {
    // declare fields
    // declare nonabstract methods
    abstract void draw();
}

abstract class as extends GraphicObject{
    abstract void abstract2();
}

abstract class me extends as {
    abstract void us();
}

class hey extends me{
    void us() {

    }
    void abstract2(){}
    void draw(){}
}

interface abc{
    int a =9;

        }

class xyz implements abc {
    public static void main(String[] args) {
       int a=10;
        System.out.println("here a is "+args);
    }

}


class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
                {"Mr. ", "Mrs. "},
                {"Smith", "Jones"},
                {"Jai","Veeru"}
        };
        // Mr. Smith
        System.out.println(names[0][0]+ names[1][0]);
        // Ms. Jones
        System.out.println(names[0][1] + names[1][1]);
        System.out.println(names.length);
    }
}

class ThreeArray {
    public static void main(String[] args) {

        // create a 3d array
        int[][][] test = {
                {
                        {1, -2, 3},
                        {2, 3, 4}
                },
                {
                        {-4, -5, 6, 9},
                        {1},
                        {2, 3}
                }
        };

        // for..each loop to iterate through elements of 3d array
        for (int[][] array2D: test) {
            for (int[] array1D: array2D) {
                for(int item: array1D) {
                    System.out.println(item);
                }
            }
        }
    }
}

class ArrayCopyDemo {
    public static void main(String[] args) {
        String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto" };

        String[] copyTo =  new String[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
    }
}


class EnumExample1{
    //defining the enum inside the class
    public enum Season { WINTER, SPRING, SUMMER, FALL }
    //main method
    public static void main(String[] args) {
        //traversing the enum
        for (Season s : Season.values())
            System.out.println(s);

        System.out.println("Value of WINTER is: "+Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is: "+Season.valueOf("WINTER").ordinal());
        System.out.println("Index of SUMMER is: "+Season.valueOf("SUMMER").ordinal());
    }

}


class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
class JavaStreamExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price > 30000)// filtering data
                .map(p->p.price)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);


    }
}



class DataStructure {

    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {

        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface

    private class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {

            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String[] s) {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}




class typesOfforLoop {

    /*Li1Integer> values = Arrays.asList(2,4,5,6,8,9,10);
    int length = values.size();

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2,4,5,6,8,9,10);
        int length = values.size();
        Java8Demo java8Demo = new Java8Demo();

        for(int i=0; i<java8Demo.length ; i++){
            System.out.println(java8Demo.values.get(i));
        }
    }*/

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2,4,6,8,10);
        int length = values.size();

        //first method to print traverse elements but we can set the first and list index element or travese based on index value
       /* for (int i=0; i<length; i++){
            System.out.println(values.get(i));
        }*/

        //Enhanced for loop used when you want to print all the values in the list irrespective of the starting and ending point in the list
       /* for (int i : values){
            System.out.println(i);
        }*/

        // using iterator interface in java: With iterator method in List we can iterate over custom class, can do modification while iterating with remove method
        /*Iterator<Integer> i = values.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }*/

        //All above loops are called external iterations i.e for loop outside of your method try to traverse the list and help in fetching the data
        //Internal iteration: for Internal iteration we can use Stream API.
        values.forEach(i-> System.out.println(i)); // with lambda expression
        values.forEach(System.out::println); //with method reference
    }

}

class ConsumerFunctionExample1{
    //This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

    public static void main(String[] args){
        Consumer<Integer> consumer= i-> System.out.print(" "+i);
        List<Integer> integerList=Arrays.asList(new Integer(1),
                new Integer(10), new Integer(200),
                new Integer(101), new Integer(-10),
                new Integer(0));
        printList(integerList, consumer);
    }
    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
        for(Integer integer:listOfIntegers){
            consumer.accept(integer);
        }
    }
    //O/p:  1 10 200 101 -10 0
}

class ConsumerFunctionExample_WithAndThenFunction{
    public static void main(String[] args){
        Consumer<Integer> consumer= i-> System.out.print(" "+i);
        Consumer<Integer> consumerWithAndThen = consumer.andThen( i-> System.out.print("(printed "+i+")"));
        List<Integer> integerList=Arrays.asList(new Integer(1),
                new Integer(10), new Integer(200),
                new Integer(101), new Integer(-10),
                new Integer(0));
        printList(integerList,consumerWithAndThen);
    }
    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
        for(Integer integer:listOfIntegers){
            consumer.accept(integer);
        }
    }
    //O/p:  1(printed 1) 10(printed 10) 200(printed 200) 101(printed 101) -10(printed -10) 0(printed 0)
}

class LambdaExample{
    public static void main(String[] args) {
        List<Integer>  values = Arrays.asList(1,3,4,6,7,9);

        //1.
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        values.forEach(consumer); //foreach internally implements consumer interface i.e implements accept method as well and iterate with for loop

       /*//2. Let's remove boiler plate code or repetitive code
        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/

        /*//3.
        Consumer<Integer> consumer = (Integer integer)-> System.out.println(integer);

        values.forEach(consumer);*/


        /*//4. since we already know the parameter type is same as consumer type so can remove that as well
        Consumer<Integer> consumer = integer -> System.out.println(integer);

        values.forEach(consumer);*/


        /* //5. Since having only single parameter so can remove brackets
        values.forEach((Integer integer)->{System.out.println(integer);
        });*/


       /*values.forEach(integer -> System.out.println(integer));*/


//Lambda expression will only works with functional interfaces(interfaces having only "one abstruct method").



        // but since foreach is passing the value to the sout. so we can skip the parameter name hear with help of method reference so we are passing a method as a parameter
       // values.forEach(System.out::println); //println==println(integer)  //so in java we can use call by value, call by reference and call by method reference
    }
}


class methodReferenceExample{

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2,4,3,5,6);

        values.forEach( i-> doubleit(i) );
        //values.forEach(methodReferenceExample :: doubleit);
    }

    public static void doubleit(int i) {
        System.out.println(i*2);
    }
}

class PredicateInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> pr = a -> (a > 18); // Creating predicate
        System.out.println(pr.test(10));    // Calling Predicate method
        System.out.println(pr.test(19));
    }
}


class PredicateInterfaceExample1{
    static Boolean checkAge(int age){
        return age > 17;
    }

    public static void main(String[] args){
        // Using Predicate interface
        Predicate<Integer> predicate =  PredicateInterfaceExample1::checkAge;   //Creating reference of interface without implementing interface in a class
        // Calling Predicate method
        boolean result = predicate.test(25);
        System.out.println(result);
    }
}


class StreamAPIExample{

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(12,33,14,65,17,10);

       // arrayList.forEach(i-> System.out.println(i)); //internal iteration with lambda expression

       // arrayList.forEach(System.out::println); //Internal iteration with method reference

       // arrayList.stream().forEach(System.out::println);
       // arrayList.parallelStream().forEach(System.out::println); //uses multicores to solve the problem
       /* arrayList.stream().filter(i-> {
                                        System.out.println(i);
                                        return true;
        }); //We are not getting any output since stream is lazy */

        /*arrayList.stream().filter(i-> {
            System.out.println("hi "+i);
            return true;
        }).findFirst().orElse(0); */

        Stream<Integer> s = arrayList.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::println);// Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

    }

}

class StreamApiBasicsExample{
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2,3,5,7,6,20);
 /*       Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };

       *//*Stream s = values.stream();

       Stream s1Map = s.map(f);
       s1Map.forEach(System.out::println);*//*

        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                return i+j;
            }
        };

        Stream s = values.stream();

        Stream s1Map = s.map(f);

        Integer s1MapReduce = (Integer) s1Map.reduce(0,b);

        //System.out.println(s1MapReduce);
*/

/*        //2
        Stream <Integer> s1 = values.stream();
        Stream <Integer> s1Map = s1.map(i->i*2);
        Integer result = s1Map.reduce(0,(c, e) -> c+e);
        System.out.println(result);*/

        System.out.println(values.stream().map(i -> i*2).reduce(0, (c,e) -> c+e ));
        System.out.println(values.stream().map(i -> i*2).reduce(0, (c,e) -> Integer.sum(c,e) )); //using lambda expression(applies only in functional interface)
        System.out.println(values.stream().map(i -> i*2).reduce(0, Integer::sum )); //can fetch values automatically(No need to be functional interface for method referencing)
    }
}


class FilterExample{

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3, 5, 10, 13, 15, 17);

        /*int result = 0;
        for (int i:values){
            if (i%5==0){
                result += i;
            }
        }
        System.out.println(result);
    */

    /*    System.out.println(values.stream().filter(i -> i % 5 == 0).reduce(0, (c, e) -> c + e)); // advantage with this is that it is internal iteration
        //this is the pros of functional programming that you focus more on what to do than how to do

        //to make look beautiful you can do cosmetic changes like
        System.out.println(values.stream()  // stream will convert all the values to stream
                                 .filter(i -> i % 5 == 0)  //Only those value will come out which satisfy this condition
                                 .reduce(0, (c, e) -> c + e));
        */

        /*//Elaboration of filter method

        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%5==0;
            }
        };

        System.out.println(values.stream()
                                 .filter(p)
                                 .reduce(0,((c,e) -> c+e)));*/

        //findFirstMethod

        System.out.println(values.stream()
                                 .filter(i->i%5==0)
                                 .map(i->i*2)
                                 .findFirst() /*Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty. If the stream has no encounter order, then any element may be returned.
                                                This is a short-circuiting terminal operation. Throws: NullPointerException – if the element selected is null*/
                                 .orElse(0));

        // O/p:  Optional[10]
    }
}

class IsStreamMethodsmoreEfficient{

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3, 5, 10, 13, 15, 17);
         /*int result=0;
         for (int i : values){
             if (i%5==0){
                 result = i*2;
                 break;
             }
         }
        System.out.println(result);  //like this intermediate methods are lazy loading methods */




    /*
    click on  intermediate operation on filter discription in Stream Interface
    Stream operations and pipelines
Stream operations are divided into intermediate and terminal operations, and are combined to form stream pipelines. A stream pipeline consists of a source (such as a Collection, an array, a generator function, or an I/O channel); followed by zero or more intermediate operations such as Stream.filter or Stream.map; and a terminal operation such as Stream.forEach or Stream.reduce.
Intermediate operations return a new stream. They are always lazy; executing an intermediate operation such as filter() does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate. Traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed.
Terminal operations, such as Stream.forEach or IntStream.sum, may traverse the stream to produce a result or a side-effect. After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used; if you need to traverse the same data source again, you must return to the data source to get a new stream. In almost all cases, terminal operations are eager, completing their traversal of the data source and processing of the pipeline before returning. Only the terminal operations iterator() and spliterator() are not; these are provided as an "escape hatch" to enable arbitrary client-controlled pipeline traversals in the event that the existing operations are not sufficient to the task.
Processing streams lazily allows for significant efficiencies; in a pipeline such as the filter-map-sum example above, filtering, mapping, and summing can be fused into a single pass on the data, with minimal intermediate state. Laziness also allows avoiding examining all the data when it is not necessary; for operations such as "find the first string longer than 1000 characters", it is only necessary to examine just enough strings to find one that has the desired characteristics without examining all of the strings available from the source. (This behavior becomes even more important when the input stream is infinite and not merely large.)
Intermediate operations are further divided into stateless and stateful operations. Stateless operations, such as filter and map, retain no state from previously seen element when processing a new element -- each element can be processed independently of operations on other elements. Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements.
Stateful operations may need to process the entire input before producing a result. For example, one cannot produce any results from sorting a stream until one has seen all elements of the stream. As a result, under parallel computation, some pipelines containing stateful intermediate operations may require multiple passes on the data or may need to buffer significant data. Pipelines containing exclusively stateless intermediate operations can be processed in a single pass, whether sequential or parallel, with minimal data buffering.
Further, some operations are deemed short-circuiting operations. An intermediate operation is short-circuiting if, when presented with infinite input, it may produce a finite stream as a result. A terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time. Having a short-circuiting operation in the pipeline is a necessary, but not sufficient, condition for the processing of an infinite stream to terminate normally in finite time.*/


        //Let's check if it is filtering all the elements

        System.out.println(values.stream()
                .filter(IsStreamMethodsmoreEfficient::isDivisible) //if it filtered all the elements than it should print all the elements in sout in method calling
                .map(IsStreamMethodsmoreEfficient::doubleValue)
                .findFirst()
                .orElse(0));

    }

    public static boolean isDivisible(int i){
        System.out.println("in isDivisible "+i);
        return i%5==0;
    }

    public static int doubleValue(int i){
        return i*2;
    }


    /*in isDivisible 3  // But since it is lazy evaluation it is only executing for the 3 and 5. So filter is applieed only two values
      in isDivisible 5  //and map is applied only one value
      10*/
}


class Book {
    String ISBN;

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }


    /*public boolean equals(Object obj) {
        if (obj instanceof Book)
            return ISBN.equals((Book)obj.getISBN());
        else
            return false;
    }*/

      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    public static void main(String[] args) {
        // Swing Tutorial, 2nd edition
        Book firstBook  = new Book("0201914670");
        Book secondBook = new Book("0201914670");
        System.out.println(firstBook.hashCode());
        System.out.println(secondBook.hashCode());

        if (firstBook.equals(secondBook)) {
            System.out.println("objects are equal");
        } else {
            System.out.println("objects are not equal");
        }

        String s1 = "abc";
        String s2 = "abc";
        String s3 = "abc";
        String s4 = "abc";

        System.out.println("compairing equals");
        if(s1.equals(s2)){
            System.out.println("s1.equals(s2)");
        }else {
            System.out.println("!s1.equals(s2)");
        }

        if(s1.equals(s3)){
            System.out.println("s1.equals(s3)");
        }else {
            System.out.println("!s1.equals(s3)");
        }

        if(s2.equals(s3)){
            System.out.println("s2.equals(s3)");
        }else {
            System.out.println("s2.equals(s3)");
        }

        System.out.println("compairing ==");
        if(s1==s2){
            System.out.println("s1==s2");
        }else {
            System.out.println("s1!==s2");
        }
        if(s1==s3){
            System.out.println("s1==s3");
        }else {
            System.out.println("s1!==s3");
        }
        if(s2==s3){
            System.out.println("s2==s3");
        }else {
            System.out.println("s2!==s3");
        }
        if(s3==s4){
            System.out.println("s3==s4");
        }else {
            System.out.println("s3!==s4");
        }

        int a = 133;
        Integer b = new Integer(133);
        System.out.println("b.equals(a)"+b.equals(a));
    }

}

class Birthday
{
private Date bday;
public boolean equals(Object obj)
        {
        if(this == obj)
        return true;
        if(obj instanceof Birthday)
        {
        Birthday bd = (Birthday) obj;
        return bday.equals(bd.bday);
        }
        else if(obj instanceof Date)
        {
        return bday.equals(obj);
        }
        else
        return false;
        }
  	}




class Book1 {
    String isbn;

    public Book1(String isbn) {
        this.isbn = isbn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book1)) return false;

        Book1 book1 = (Book1) o;

        return isbn.equals(book1.isbn);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(isbn)*31 +2;
    }
}

class Syllabus extends Book1{
    Syllabus(String str){
        super(str);
    }
    public static void main(String[] args) {

        Book1 firstBook = new Book1("1234");
        Syllabus secondBook = new Syllabus("1234");

        if (firstBook.equals(secondBook)) {
            System.out.println("objects are equal");
        } else {
            System.out.println("objects are not equal");
        }

        System.out.println("If two objects are equal their hashcode are same");
        System.out.println(firstBook.hashCode());
        System.out.println(secondBook.hashCode());

        int a = 2;
        Object obj = a;
        System.out.println(obj);
        String str1 = "E11";
        String str2 = "F02";
        System.out.println(str1.hashCode()+"   "+str2.hashCode());
        System.out.println(firstBook.getClass().getInterfaces());
        System.out.println(firstBook);
        System.out.println(firstBook);
    }

}

class IntegerDemo {

    public static void main(String[] args) {

        Integer i = new Integer(30);

        String str = "50";
      /* returns a Integer instance representing the specified
         string with radix 10 */
        System.out.println("Value = " + Integer.valueOf(str, 9));
    }
}

class Array{
    public static void main(String[] args) {

        String[] copyFromWithSystemClass = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto" };

        String[] copyToWithSystemClass = new String[7];
        System.arraycopy(copyFromWithSystemClass, 2, copyToWithSystemClass, 0, 7);
        for (String coffee : copyToWithSystemClass) {
            System.out.print(coffee + " ");

        }
            String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto" };

        String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, copyFrom.length);
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }


        java.util.Arrays.stream(copyTo).map(coffee -> coffee + "here ").forEach(System.out::print);

        System.out.println("\ntostring ");
        System.out.println(java.util.Arrays.toString(copyTo));

        int[] arrays;
       // arrays = new int[7];
}}

class TestArrayFeatures{
    //static int[] asArray1 = new int[10];

    int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new TestArrayFeatures().nonStaticMethod();
        int intArrayLength = intArray.length;
      /*  for (int i=0;i<intArrayLength;i++){
            System.out.print(intArray[i]);
            if(i<intArrayLength-1){
                System.out.print(",");
            }
        }*/

        for (int i : intArray) {
            System.out.print(intArray[i]);
            if (i < intArrayLength - 1) {
                System.out.print(",");
            }
        }
    }
    public void nonStaticMethod(){
        int[] asArray = new int[10];
        System.out.println(asArray[9]);
        int[] cloneArray = asArray.clone();
    }
}

class AddingItemsDynamically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :: ");
        int size = sc.nextInt();
        String[] myArray = new String[size];
        System.out.println("Enter elements of the array (Strings) :: ");
        for(int i=0; i<size; i++) {
            myArray[i] = sc.next();
        }
        String[] strArray = new String[myArray.length];
        System.out.println("Array List given below");
        System.out.println(Arrays.toString(myArray));
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(myArray));
        System.out.println("Enter the element that is to be added:");
        String element = sc.next();
        myList.add(element);
        myArray = myList.toArray(myArray);
        System.out.println(Arrays.toString(myArray));

        char uniChar = '\u03A9';
        System.out.println("unichar value: "+uniChar);
    }
}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

class EnumTest {
    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Day.MONDAY "+Day.MONDAY);
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}