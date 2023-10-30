package jpamvcexam.mainview;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpamvcexam.model.dto.Emp;

public class EmpDeptLab {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
    EntityManager em = factory.createEntityManager();

    if (new Random().nextBoolean()) {
      System.out.print("사원명을 입력하세요 : ");
      String name = sc.nextLine();
      TypedQuery<Emp> q = em.createQuery("select e from Emp e where e.ename = :en", Emp.class);
      q.setParameter("en", name);
      Emp emp;
      try {
        emp = q.getSingleResult();
        System.out.printf("%s의 근무 부서 - %s \n",emp.getEname(), emp.getDept().getDname());
      } catch(NoResultException e) {
        System.out.println("부서를 찾을수 없네요..ㅠㅠ");
      }
    } else {
      System.out.print("부서명을 입력하세요 : ");
      String dname = sc.nextLine();
      TypedQuery<Emp> q = em.createQuery("select e from Emp e where e.dept.dname = :dn", Emp.class);
      q.setParameter("dn", dname);
      List<Emp> list = q.getResultList();

      if (list.size() != 0) {
        System.out.printf("[%s] 부서에 근무하는 직원", dname);
        list.stream().forEach(x -> {
          System.out.println(x.getEname());
        });
      } else {
        System.out.println("직원들을 찾을 수 없네요...ㅠㅠ");
      }
    }
    em.close();
    factory.close();
  }
}
