package com.javapersistence.demo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

  public static void main(String[] args) {

    deleteBooks();

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    persistBook(new Book(5004L, "H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247));

    Book book = findBook(5004L);

    System.out.println("# " + book);
  }

  /**
   * Gets an entity manager
   */
  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
  private static EntityManager em = emf.createEntityManager();

  private static void deleteBooks(){
    em.getTransaction().begin();
    Query q = em.createQuery("DELETE FROM Book");
    q.executeUpdate();
    em.getTransaction().commit();
  }
  /**
   * Persists the book to the database
   */
  private static void persistBook(Book book) {
    em.persist(book);
  }

  /**
   * Finds the book from the database
   */
  private static Book findBook(Long id) {
    return em.find(Book.class, id);
  }
}


