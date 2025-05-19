package relationshipmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

           BookStore bookStore = new BookStore();
           bookStore.setName("시애틀 책방");
           em.persist(bookStore);

           Book book = new Book();
           book.setTitle("JPA");
           em.persist(book);

           bookStore.add(book);
           book.setBookStore(bookStore);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();

    }
}
