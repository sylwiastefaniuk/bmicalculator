package pl.kodu.akademia.repository;

import org.hibernate.Session;
import pl.kodu.akademia.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsRepository {


    private static List<Person> personsList = new ArrayList<>();

    public static void addNewPerson(Person newPerson){
        personsList.add(newPerson);
    }

static {
        Person p1 = new Person();
        personsList.add(p1);
}

    public static List<Person> getPersonsById(int id) {
        List<Person> result = new ArrayList<>();
            for (Person person : personsList) {
            if (person.getId() == id) {
                result.add(person);
            }
        }
        return result;

    }
}
