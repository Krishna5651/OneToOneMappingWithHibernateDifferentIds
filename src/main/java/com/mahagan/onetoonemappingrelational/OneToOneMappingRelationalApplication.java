package com.mahagan.onetoonemappingrelational;


import com.mahagan.onetoonemappingrelational.entity.Pancard;
import com.mahagan.onetoonemappingrelational.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneMappingRelationalApplication {

	public static void main(String[] args){
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();

		Person person=new Person();
		person.setPerson_Name("Krishna");
		person.setBirth_Date("28/08/2001");
		person.setAddress("Pune");

		Pancard pancard=new Pancard();
		pancard.setAgency("Raj Enterprises");
		pancard.setIssue_Date("22/06/2019");

		person.setPancard(pancard);
		pancard.setPerson(person);

		session.persist(person);
		transaction.commit();

		session.close();
		System.out.println("Data has been successfully saved in database");

	}

}
