package utn.emiliano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utn.emiliano.model.User;
import utn.emiliano.repository.UserRepository;

import java.util.List;

/**
 * Created by francisco on 17/02/2016.
 */
@RestController
@Component("userController")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> user(){
        return userRepository.findAll();
    }

}
