package jpamvcexam.model.dao;

import jpamvcexam.model.dto.EmpFreqDTO;
import jpamvcexam.model.dto.EmpDTO;

import javax.persistence.*;
import java.util.List;

public class EmpDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
    EntityManager em = factory.createEntityManager();
    public void close() {
    	em.close();
    	factory.close();
    }
	public Long getAllDataNum() {	
		TypedQuery<Long> q = em.createQuery("select count(t.empno) from EmpDTO t", Long.class);
		return q.getSingleResult();   
	}
	
	public String getEmpName(Integer numOfEmp) {
		EmpDTO e = em.find(EmpDTO.class, numOfEmp);
		if (e != null)
			return e.getEname();
		else
			return "없음";
	}

	public List<EmpDTO> findByJob(String job) {
		TypedQuery<EmpDTO> q = em.createQuery("SELECT t FROM EmpDTO t WHERE t.job = :job", EmpDTO.class);
		q.setParameter("job", job); 
		List<EmpDTO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpDTO> findByPartEname(String partEname) {
		TypedQuery<EmpDTO> q = em.createQuery("SELECT t FROM EmpDTO t WHERE t.ename like :pe", EmpDTO.class);
		q.setParameter("pe", "%"+partEname+"%"); 
		List<EmpDTO> resultList = q.getResultList();
		return resultList;
	}
	
	public List<EmpDTO> findByGreaterThanSal(int sal) {
		TypedQuery<EmpDTO> q = em.createQuery("SELECT t FROM EmpDTO t WHERE t.sal >= :sal", EmpDTO.class);
		q.setParameter("sal", sal); 
		List<EmpDTO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpDTO> findByEnameAndJob1(String ename, String job) {
		TypedQuery<EmpDTO> q = em.createQuery("SELECT t FROM EmpDTO t WHERE t.ename = :ename and t.job = :job", EmpDTO.class);
		q.setParameter("ename", ename); 
		q.setParameter("job", job); 
		List<EmpDTO> resultList = q.getResultList();
		return resultList;
	}

	public EmpDTO findByEnameAndJob2(String ename, String job) {
		TypedQuery<EmpDTO>  q = em.createQuery("SELECT t FROM EmpDTO t WHERE t.ename = ?1 and t.job = ?2", EmpDTO.class);
		q.setParameter(1, ename); 
		q.setParameter(2, job); 
		EmpDTO result = q.getSingleResult();
		return result;
	}
	
	public List<EmpFreqDTO> findByEmpFreqDTO() {
		TypedQuery<EmpFreqDTO>  q = em.createQuery("SELECT new jpamvcexam.model.dto.EmpFreqDTO(t.empno, t.ename, t.hiredate, t.sal, t.deptno) FROM EmpDTO t", EmpFreqDTO.class);
		List<EmpFreqDTO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpDTO> listPart(int start, int num) {
		TypedQuery<EmpDTO> q = em.createQuery("SELECT t FROM EmpDTO t ORDER BY t.sal DESC", EmpDTO.class);
		q.setFirstResult(start);    // 조회 시작 위치
		q.setMaxResults(num);       // 조회할 데이터 수
		List<EmpDTO> resultList = q.getResultList();
		return resultList;
	}
	
	public Object[] getGroupFunc() {	
		Query query = em.createQuery("SELECT sum(t.sal), max(t.sal), min(t.sal) FROM EmpDTO t");
		Object[] result = (Object[])query.getSingleResult();
		return result;
	}
}
