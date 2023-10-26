package jpamvcexam.mainview;

import jpamvcexam.model.dto.EmpDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class HelloJpa3 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from EmpDTO t", EmpDTO.class);
        List<EmpDTO> empDTOList = q.getResultList();
        for (Object dto : empDTOList) {
            System.out.println(dto);
        }
        System.out.println("데이터 갯수 : " + empDTOList.size());
        em.close();
        factory.close();
    }
}
