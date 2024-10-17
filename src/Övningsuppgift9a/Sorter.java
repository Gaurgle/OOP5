package Övningsuppgift9a;

import java.util.Comparator;
import java.util.List;

public class Sorter{

    public void sortByName(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getName));
    }

    public void sortByHeight(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getLength));
    }

    public void sortByWeight(List<Person> persons) {
        persons.sort(Comparator.comparing((Person::getWeight)));
    }

    public void sortByAge(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getAge));
    }

    public void sortByAdress(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getAdress));
    }
}
