/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 19:41
 * Project: OneToOneMappingRelational
 **/

package com.mahagan.onetoonemappingrelational;

import com.mahagan.onetoonemappingrelational.entity.Pancard;
import com.mahagan.onetoonemappingrelational.entity.Person;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneMappingRelationalFetchAllDataFromDB {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        TypedQuery query=session.createQuery("from Person person");
        List<Person> list=query.getResultList();
        Iterator<Person> iterator= list.listIterator();

        while (iterator.hasNext()){
            Person person=iterator.next();
            System.out.println(person.getPerson_Name()+""+person.getAddress()+""+person.getBirth_Date());
            Pancard pancard=person.getPancard();
            System.out.println(pancard.getAgency()+""+pancard.getIssue_Date());
        }
            session.close();
        System.out.println("Successfully Retrive data from database");

    }

}
