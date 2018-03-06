package xin.haojias.ice.methods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.haojias.ice.methods.domain.User;
import xin.haojias.ice.methods.repository.UserRepository;
import xin.haojias.ice.methods.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping
    public User find(User user){
        return user;
    }


}