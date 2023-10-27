package jpamvcexam.mainview;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import jpamvcexam.model.dto.Book;
import jpamvcexam.model.dto.EmpDTO;

public class JPASelectBookLab {
  static EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
  static EntityManager em = factory.createEntityManager();
  public void close() {
    em.close();
    factory.close();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Book> result;

    BREAK:
    while(true){
      System.out.println("1. 모두 출력하기");
      System.out.println("2. 가격이 높은 순으로 출력하기");
      System.out.println("3. 20000원 이상의 도서들만 출력하기");
      System.out.println("4. id가 3번인 도서 출력하기");
      System.out.println("5. 도서명에 '자바' 또는 '스프링'을 포함하는 도서들만 출력하기");
      System.out.println("6. 분류별 도서 가격의 합을 출력하기");
      System.out.println("7. 종료");

      switch(sc.nextInt()){
        case 1:
          getAllBook().stream().forEach(System.out::println);
          break;
        case 2:
          getDescOrderBook().stream().forEach(System.out::println);
          break;
        case 3:
          getMorePriceBook(20000).stream().forEach(System.out::println);
          break;
        case 4:
          Book tmp_book = findNumBook();
          if(tmp_book != null){
            System.out.println(tmp_book);
          }else{
            System.out.println("id가 3번인 도서는 없습니다.");
          }
          break;
        case 5:
          getNameContaineBook().stream().forEach(System.out::println);
          break;
        case 6:
          getGroupBook().stream().forEach(o-> {
            for(Object book: (Object[])o){
              System.out.printf(book + " ");
            }
            System.out.println();
          });
          break;
        default:
          System.out.println("종료합니다.");
          break BREAK;
      }

    }
  }

  static public List<Book> getAllBook() {
    TypedQuery<Book> q = em.createQuery("select b from Book b", Book.class);
    return q.getResultList();
  }

  static public List<Book> getDescOrderBook(){
    TypedQuery<Book> q = em.createQuery("select b from Book b order by b.price desc", Book.class);
    return q.getResultList();
  }

  static public List<Book> getMorePriceBook(int pirce){
    TypedQuery<Book> q = em.createQuery("select b from Book b where b.price >= :bp", Book.class);
    q.setParameter("bp", pirce);
    return q.getResultList();
  }
  static public Book findNumBook() {
    Book b = em.find(Book.class, 3);
    return b;
  }
  static public List<Book> getNameContaineBook(){
    TypedQuery<Book> q = em.createQuery("select b from Book b where b.title like :bt", Book.class);
    if(new Random().nextBoolean()){
      q.setParameter("bt", "%" + "자바" + "%");
    } else {
      q.setParameter("bt", "%" + "스프링" + "%");
    }
    return q.getResultList();
  }

  static public List<Object> getGroupBook() {
    Query q = em.createQuery("SELECT concat('분류 코드 ', b.kind) as kind, sum(b.price) FROM Book b Group by b.kind");
    return q.getResultList();
  }

}
