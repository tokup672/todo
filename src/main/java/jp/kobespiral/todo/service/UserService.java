package jp.kobespiral.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.todo.entity.User;
import jp.kobespiral.todo.exception.UserExistException;
import jp.kobespiral.todo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public User createUser(User user){
        if(ur.findUserByUid(user.getUid()) != null){
            System.out.println(ur.findUserByUid(user.getUid()));
            throw new UserExistException("そのユーザーは既に存在します");
        }else{
            return ur.save(user);
        }
    }

    // public User getUserByUid(String uid){
    //     for(User u:ur.findUserByUid(uid)){
    //         return u;
    //     }
    //     return null;
    // }

    public List<User> getAllUser() {
        ArrayList<User> list = new ArrayList<User>();
        for(User u:ur.findAll()){
            list.add(u); 
        }
        return list;
    }
}