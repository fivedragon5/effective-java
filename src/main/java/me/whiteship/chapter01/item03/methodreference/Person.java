package me.whiteship.chapter01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    public Person() {

        System.out.println("?");

    }

    public Person(LocalDate birthday) {
        System.out.println("#");
        this.birthday = birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(2011, 3, 2));
        dates.add(LocalDate.of(20132, 1, 28));
        Function<LocalDate, Person> aNew = Person::new;
        dates.stream().map(aNew).collect(Collectors.toList());

        System.out.println("================");

        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));

        people.sort(Person::compareByAge);

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        });
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}
