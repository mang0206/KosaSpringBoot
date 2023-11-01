package springrest.exam.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import springrest.exam.domain.User;

// 통합 클래스 이름 Dao + Service
@Service
public class UserService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    // static block
    static{
        users.add(new User(1, "둘리", LocalDate.of(2000,10,15), "gold", "1234"));
        users.add(new User(2, "또치", LocalDate.of(2001,10,15), "silver", "9999"));
        users.add(new User(3, "도우너",  LocalDate.of(2002,10,15), "silver", "0000"));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()== null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId()== id){
                return user;
            }
        }
        return null;
    }

    // 사용자 삭제
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();

            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
    public User updateById(User user, int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User update_user = iterator.next();

            if(id == update_user.getId()){
                update_user.setName(user.getName());
                update_user.setJoinDate(user.getJoinDate());
                return user;
            }
        }
        return null;
    }
}