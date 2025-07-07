package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public String toString(){
        return name + " - " + age;
    }

}

public class JavaStreams {
    public static void main(String[] args) {

        // Activity 1
        List<Integer> myNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isOdd  = s -> s%2 == 1;
        List<Integer> resultNum = myNums.stream()
                .filter(isOdd)
                .toList();
        System.out.println("Odd Numbers: " + resultNum);

        // Activity 2
        List<String> myNames = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA  = s -> s.startsWith("A");
        List<String> resultName = myNames.stream()
                .filter(startsWithA)
                .toList();
        System.out.println("Names starting with A: " + resultName);

        // Activity 3
        List<Integer> myNums3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> resultNum3 = myNums3.stream()
                .map(n ->n * n)
                .toList();
        System.out.println("Squared Numbers: " + resultNum3);

        // Activity 4
        List<Integer> myNums4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven  = s -> s%2 == 0;
        Predicate<Integer> greaterThanFive = s-> s>5;
        Predicate<Integer> combined = isEven.and(greaterThanFive);

        List<Integer> resultNum4 = myNums4.stream()
                .filter(combined)
                .toList();
        System.out.println("Even and >5: " + resultNum4);


        // Activity 5
        List<Person> myPerson = Arrays.asList(new Person("John", 32), new Person("Ben",20), new Person("Anna", 22), new Person("Mike", 25), new Person("Zara",29));

        List<Person> sortedByAge = myPerson.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .toList();

        List<Person>sortedByAgeDescending = myPerson.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .toList().reversed();

        List<Person> sortedByName = myPerson.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();

        System.out.println("\n");
        System.out.println("Sorted by age (ascending):");
        Consumer<Person> printNameByAge = person -> System.out.println( person.getName() + " - " + person.getAge());
        sortedByAge.forEach(printNameByAge);
        System.out.println();

        System.out.println("Sorted by name:");
        Consumer<Person> printNameByName = person -> System.out.println( person.getName() + " - " + person.getAge());
        sortedByName.forEach(printNameByName);
        System.out.println();

        System.out.println("Sorted by age (descending):");
        Consumer<Person> printNameByAgeDescending = person -> System.out.println( person.getName() + " - " + person.getAge());
        sortedByAgeDescending.forEach(printNameByAgeDescending);












    }
}