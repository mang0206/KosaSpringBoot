package springjpa.exam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springjpa.exam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
  //1.전체 도서의 리스트

  //2.전달된 id와 동일한 id를 갖는 도서
  public Book findById(int id);
  //3. 가격이 높은 순으로 도서 리스트

  //4.전달된 가격 정보와 동일하거나 비싼 도서 리스트
  public List<Book> findByPriceGreaterThanEqual(int price);

  //5.전달된 분류 정보와 동일한 도서 리스트
  public List<Book> findByKind(String kind);

  //6. 도서 제목이 전달된 아규먼트 값으로 시작하는 리스트
  public List<Book> findByTitleStartsWith(String title);

  //7. 전달된 2개의 아규먼트 중 하나를 도서 제목에 포함하는 도서 리스트
  public List<Book> findByTitleContainsOrTitleContains(String title1, String title2);

  //8. 가격이 가장 싼 도서
  public Book findTopByOrderByPrice();

  //9. 전체 도서의 개수
  public Long countBy();

  //10. 전달된 분류 정보에 속하는 도서 개수
  public Long countByKind(String kind);

  //11. 분류별 도서 가격의 평균
  @Query("select b.kind, avg(b.price) from Book b group by b.kind")
  public List<Object> avgBook();
}
