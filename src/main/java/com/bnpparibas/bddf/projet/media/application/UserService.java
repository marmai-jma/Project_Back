package com.bnpparibas.bddf.projet.media.application;

import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String create(User newUser){
        return this.userRepository.save(newUser);
    }

    public User obtain(String id){
        return this.userRepository.get(id);
    }

    public List<User> listAll(){
        return this.userRepository.findAll();
    }

    public void update(String id, User userToUpdate){
        User user = obtain(id);
        user.update(userToUpdate);
        this.userRepository.update(user);
    }

    public void remove(String id){
        obtain(id);
        this.userRepository.delete(id);
    }
}
