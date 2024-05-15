import models.Car;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
                Car car = new Car("BMW", Type.VEHICLE,230,23.500,2021);
                session.save(car);
                session.save(new Car("Mercedes",Type.VEHICLE,537,47.500,2024));
                session.save(new Car("Toyota",Type.TRUCK,287,50.500,2020));
                session.save(new Car("Lexus",Type.TRUCK,480,70.900,2022));




        session.getTransaction().commit();

//        List<Car> resultList = session.createNativeQuery("select * from my_Car", Car.class).getResultList();
//        System.out.println(resultList);

//        List<Car> carList = session.createQuery("select c from Car c", Car.class).getResultList();
//        System.out.println(carList);
//        List<Double> priceList = session.createQuery("select c.price from Car c", Double.class).getResultList();
//        System.out.println(priceList);


        session.close();
        sessionFactory.close();

    }
}
//Створити клас Car з полями:
//id
//        model,
//Type (ENUM)
//power,
//price,
//year.
