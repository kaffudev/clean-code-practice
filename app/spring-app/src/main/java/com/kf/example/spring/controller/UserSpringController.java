package com.kf.example.spring.controller;

import com.kf.example.controller.UserController;
import com.kf.example.controller.model.UserWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserSpringController {

    private final UserController controller;

    @Autowired
    public UserSpringController(UserController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = "/dummy", method = RequestMethod.GET)
    public String dummy() {
        return "This is a dummy implementation as U can see XD";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserWeb createUser(@RequestBody final UserWeb userWeb) {
        return controller.createUser(userWeb);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public UserWeb loginUser(@RequestParam("email") final String email, @RequestParam("password") final String password) {
        return controller.loginUser(email, password);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UserWeb getUser(@PathVariable("userId") final String userId) {
        return controller.getUser(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserWeb> getAllUsers() {
        return controller.findAllUser();

    }
}
