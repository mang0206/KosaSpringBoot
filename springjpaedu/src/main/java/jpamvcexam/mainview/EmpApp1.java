package jpamvcexam.mainview;

import jpamvcexam.model.dao.EmpDAO;
import jpamvcexam.model.dto.EmpFreqDTO;
import jpamvcexam.model.dto.EmpDTO;
import java.util.List;

public class EmpApp1 {
	public static void hr() {
		for(int i=1; i < 100; i++)
			System.out.print("-");
		System.out.println();
	}
	public static void main(String[] args)  {
		EmpDAO dao = new EmpDAO();
		System.out.printf("emp 테이블의 데이터 갯수 : %d개 \n",dao.getAllDataNum());
		hr();
		int inputNum = 7499;
		System.out.printf("사번이 %d인 직원의 성명 : %s%n", inputNum, dao.getEmpName(inputNum));
		hr();
		List<EmpDTO> r1 = dao.findByJob("SALESMAN");
		for(EmpDTO vo : r1)
			System.out.println(vo);
		hr();
		List<EmpDTO> r2 = dao.findByPartEname("T");
		for(EmpDTO vo : r2)
			System.out.println(vo);
		hr();
		List<EmpDTO> r3 = dao.findByGreaterThanSal(2000);
		for(EmpDTO vo : r3)
			System.out.println(vo);
		hr();
		List<EmpDTO> r4 = dao.findByEnameAndJob1("MARTIN", "SALESMAN");
		for(EmpDTO vo : r4)
			System.out.println(vo);
		hr();
		EmpDTO evo = dao.findByEnameAndJob2("MARTIN", "SALESMAN");
		System.out.println(evo);
		hr();
		List<EmpFreqDTO> r5 = dao.findByEmpFreqDTO();
		for(EmpFreqDTO vo : r5)
			System.out.println(vo);
		hr();
		List<EmpDTO> r6 = dao.listPart(0, 14);
		for(EmpDTO vo : r6)
			System.out.println(vo);
		hr();
		List<EmpDTO> r7 = dao.listPart(0, 3);
		for(EmpDTO vo : r7)
			System.out.println(vo);
		hr();
		List<EmpDTO> r8 = dao.listPart(3, 2);
		for(EmpDTO vo : r8)
			System.out.println(vo);
		hr();
		
		Object[] r9 = dao.getGroupFunc();
		System.out.println("급여 총액 : "+r9[0]);
		System.out.println("최대 급여 : "+r9[1]);
		System.out.println("최소 총액 : "+r9[2]);
		hr();
		dao.close();	
	}
}
