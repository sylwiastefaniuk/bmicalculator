package pl.kodu.akademia.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kodu.akademia.model.Person;

import java.util.List;

@Service
public class BmiService {

    @Autowired
    HibernateSessionFactoryService hsfs;

    public void savePerson(Person person){
        Session session = hsfs.getSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();
    }
    public void updatePerson(Person person) {
        Session session = hsfs.getSession();
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        session.close();
    }
    public Person getPersonById(int id) {
        Session session = this.hsfs.getSession();
        Person person = (Person) session.createQuery("FROM pl.kodu.akademia.model.Person WHERE id = " + id).uniqueResult();
        session.close();
        return person;
    }
    public List<Person> getAllPersonRecords(){
        Session session = this.hsfs.getSession();
        List<Person> personList = session.createQuery("FROM pl.kodu.akademia.model.Person").list();
        session.close();
        return personList;
    }

}
