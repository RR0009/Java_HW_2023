import models.Word;
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
                .addAnnotatedClass(Word.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Word word1 = new Word(1,"honey");
        session.save(word1);
        Word word2 = new Word(2,"money");
        session.save(word2);
        Word word3 = new Word(3,"funny");
        session.save(word3);
        Word word4 = new Word(4,"nanny");
        session.save(word4);

//        session.save(new Word(1,"honey"));
//        - дістати всі value слів та запакувати в List .


        session.getTransaction().commit();
//        List<Word> list = session.createNativeQuery("select * from word_hike", Word.class).getResultList();
//        List<Word> list = session.createQuery("select w from Word w", Word.class).getResultList();
//        System.out.println(list);

//        List<Integer> resultList = session.createQuery("select w.id from  Word w", Integer.class).getResultList();
//        System.out.println(resultList);


        session.close();
        sessionFactory.close();

    }
}

//List<Integer> idList = session.createQuery("select x.id from User x", Integer.class).getResultList();