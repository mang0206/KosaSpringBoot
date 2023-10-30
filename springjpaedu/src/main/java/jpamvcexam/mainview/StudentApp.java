package jpamvcexam.mainview;

import java.util.Scanner;
import javax.persistence.Persistence;
import jpamvcexam.controller.StudentController;
import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.dto.Student;

public class StudentApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentController student = new StudentController(new StudentDAO());

    String[] inputs;
    String input;
    loop:while(true){
      System.out.println("처리하려는 기능을 선택하세요.");
      System.out.println("1. 학생 정보 출력");
      System.out.println("2. 학생 정보 입력");
      System.out.println("3. 학생 정보 삭제");
      System.out.println("4. 학생 정보 수정");
      System.out.println("5. 학생 점수 확인");
      System.out.println("6. 종료");
      System.out.print("입력 :");
      switch(sc.nextLine()){
        case "1":
          student.printAll();
          break;
        case "2":
          System.out.print("학생의 이름과 점수를 입력하세요:(스페이스바로 구분)");
          inputs = sc.nextLine().split(" ");
          student.insert(inputs[0], Integer.parseInt(inputs[1]));
          break;
        case "3":
          System.out.print("학생의 이름을 입력하세요:");
          student.delete(sc.nextLine());
          break;
        case "4":
          System.out.println("학생의 이름과 점수를 입력하세요:(스페이스바로 구분)");
          inputs = sc.nextLine().split(" ");
          student.update(inputs[0], Integer.parseInt(inputs[1]));
          break;
        case "5":
          System.out.print("학생의 이름을 입력하세요:");
          student.printScore(sc.nextLine());
          break;
        case "6":
          System.out.println("종료 합니다.");
          student.close();
          break loop;
        default:
          System.out.println("잘못된 입력입니다.");
      }
    }
  }
}
