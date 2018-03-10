package xin.haojias.ice.methods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.haojias.ice.methods.domain.User;
import xin.haojias.ice.methods.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User get(String name){
        User user=userRepository.findByName(name);
        return user;
    }

}
