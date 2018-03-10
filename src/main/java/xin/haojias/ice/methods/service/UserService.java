package xin.haojias.ice.methods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xin.haojias.ice.methods.domain.User;
import xin.haojias.ice.methods.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User get(String name){
        User user=userRepository.findUser(name);
        return user;
    }

    public Page<User> findAll(){

        Page<User> user=userRepository.findAll(new PageRequest(0,6,
                new Sort(Sort.Direction.DESC, "age")));
        return user;
    }


}
