import models.Gender;
import models.Pasport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Pasport.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        session.save(new User("Ruslan",Gender.MALE,Arrays.asList("Java", "js"),new Pasport("dhhdhdhdh")));
        session.save(new User("Nikita",Gender.MALE,Arrays.asList("Java", "js"),new Pasport("dfmfmfmfm")));
        session.save(new User("Katya",Gender.FEMALE,Arrays.asList("Java", "js"),new Pasport("fjfjfkkflf")));
        session.save(new User("Nasty",Gender.FEMALE,Arrays.asList("Java", "js"),new Pasport("lckjvjvjvj")));
        session.save(new User("Jack",Gender.MALE,Arrays.asList("Java", "js"),new Pasport("kkhkhkhlhl")));





        session.getTransaction().commit();

//        session.createQuery("select p.user from Passport p",User.class).getResultList().forEach(System.out::println);
//            session.createQuery("select u from User u",User.class).getResultList().forEach(System.out::println);

                session.createQuery("select p.user from Pasport p",User.class).getResultList().forEach(user -> System.out.println(user));

        session.close();
        sessionFactory.close();

    }
}
