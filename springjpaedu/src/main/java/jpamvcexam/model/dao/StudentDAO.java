package jpamvcexam.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpamvcexam.model.dto.Student;


public class StudentDAO {

  private EntityManagerFactory factory;

  public StudentDAO() {
    factory = Persistence.createEntityManagerFactory("emptest");
  }

  public List<Student> getAllStudent() {
    EntityManager em = factory.createEntityManager();
    TypedQuery<Student> q = em.createQuery("select st from Student st", Student.class);
    List<Student> book = q.getResultList();
    em.close();
    return book;
  }

  public Student getScore(String name) {
    EntityManager em = factory.createEntityManager();
    Student student = em.find(Student.class, name);
    return student;
  }

  public boolean insertStudent(Student entity) {
    boolean result = true;
    EntityManager em = factory.createEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(entity);
      em.getTransaction().commit();
    } catch (Exception e) {
      result = false;
    }
    em.close();
    return result;
  }

  public boolean updateStudent(Student entity) {
    boolean result = true;
    EntityManager em = factory.createEntityManager();
    try {
      em.getTransaction().begin();
      Student student = em.find(Student.class, entity.getName());
      student.setName(entity.getName());
      student.setScore(entity.getScore());
      em.getTransaction().commit();
    } catch (Exception e) {
      result = false;
    }
    em.close();
    return result;
  }

  public boolean deleteStudent(String name){
    EntityManager em = factory.createEntityManager();
    boolean result = true;
    try {
      em.getTransaction().begin();
      Student student = em.find(Student.class, name);
      em.remove(student);
      em.getTransaction().commit();
    } catch (Exception e) {
      result = false;
    }
    em.close();
    return result;
  }

  public void close() {
    if (factory != null)
      factory.close();
  }
}