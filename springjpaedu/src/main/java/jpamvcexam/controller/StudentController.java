package jpamvcexam.controller;

import java.util.List;
import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.dto.Student;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class StudentController {
  private StudentDAO dao;

  public void printAll(){
    List<Student> students = dao.getAllStudent();
    students.stream().forEach(System.out::println);
  }

  public void printScore(String name){
    Student student = dao.getScore(name);
    if (student != null) {
      System.out.printf("%s 학생의 점수는 %d 입니다.\n",name, student.getScore());
    } else {
      System.out.println(name + " 학생은 존재하지 않습니다");
    }
  }

  public void insert(String name, int score){
    if(dao.insertStudent(new Student(name, score))) {
      System.out.println("입력 성공");
    } else {
      System.out.println("입력 실패");
    }
  }

  public void update(String name, int score){
    if(dao.updateStudent(new Student(name, score))){
      System.out.println(name + " 학생의 점수를 변경했습니다.");
    } else {
      System.out.println(name + " 핵생은 존재하지 않습니다.");
    }
  }

  public void delete(String name){
    if(dao.deleteStudent(name)){
      System.out.println(name + " 학생의 데이터를 삭제했습니다.");
    } else {
      System.out.println(name + " 핵생은 존재하지 않습니다.");
    }
  }

  public void close() {
    dao.close();
  }
}
