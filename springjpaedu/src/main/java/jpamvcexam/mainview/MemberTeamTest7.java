package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MemberTeamTest7 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        Member m = em.find(Member.class, 2); // id 는 알아서 입력
        System.out.println(m);
        System.out.println("========================================");
        Query q = em.createNativeQuery("select * from membertbl order by username", Member.class);
        List<Member> list = q.getResultList();

        if (list.size() != 0) {
            list.stream().forEach(System.out::println);
        }
        System.out.println("========================================");
        q = em.createNativeQuery("select username from membertbl order by username");
        List<String> namelist = q.getResultList();

        if (namelist.size() != 0) {
            namelist.stream().forEach(System.out::println);
        }
        em.close();
        factory.close();
	}
}
