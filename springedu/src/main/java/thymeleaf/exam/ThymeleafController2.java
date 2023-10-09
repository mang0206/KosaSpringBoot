package thymeleaf.exam;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/step2")
public class ThymeleafController2 {
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("사용자 A", 10);
        User userB = new User("사용자 B", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        final HashMap<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }    

    @GetMapping("/basicobjects")
    public String basicObjects1(HttpSession session, Model model) {
        model.addAttribute("startTime", LocalDateTime.of(2023, 8, 17, 9, 0));
        model.addAttribute("tech", "     JAVA, SQL, JAVASCRIPT, SPRING");
        model.addAttribute("num", 123456789);
        session.setAttribute("sessionData", "sessionData라는 이름으로 Session Scope 영역에 보관된 객체");
        if(session.getAttribute("count") == null)
            session.setAttribute("count", new int[1]);
        int su[] = (int[])session.getAttribute("count");
        su[0]++;
        return "basic/basicobjects";    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "news");
        model.addAttribute("param2", "단풍");
        model.addAttribute("pageno", 123);
        model.addAttribute("name", "line");
        model.addAttribute("number", 5);
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring Boot!");
        return "basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring Boot!");
        return "basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/each";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("둘리", 10));
        list.add(new User("또치", 20));
        list.add(new User("도우너", 30));
        model.addAttribute("users", list);
    }

    @GetMapping("/conditiontest3")
    public String condition(Model model) {
        addUsers(model);
        return "basic/condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring Boot!");
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("듀크", 10));
        addUsers(model); 
        return "basic/javascript";
    }
    
    @GetMapping("/utility")
    public String utility(Model model) {     
    	model.addAttribute("now",new java.util.Date());        
        model.addAttribute("num", 123456789);
        return "basic/utility";
    }
    
    @GetMapping("/fragment1")
    public String freg1() {
        return "basic/fragmentMain1";
    }
    
    @GetMapping("/fragment2")
    public String freg2() {
        return "basic/fragmentMain2";
    }

}
