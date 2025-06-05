package com.airexus.pixelview.Controller;

import com.airexus.pixelview.entities.User;
import com.airexus.pixelview.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * Handles user-related requests.
     *
     * @param request the HTTP request
     * @return a view name
     */
    @GetMapping("/user")
    public String getUserPage(HttpServletRequest request) {

        return "userPage";
    }

    @PostMapping("/user/create")
    public void createUser(@RequestBody User user) {
        try {
            // Call the service to create a new user
            userService.createUser(user.getUsername(), user.getPassword());
        } catch (Exception e) {
            // Handle exceptions, such as database errors
            e.printStackTrace();
            // Optionally, rethrow or handle specific exceptions
        }
    }

    @GetMapping("/user/current/user")
    public String getCurrentUser(Principal principal) {
        return principal.getName();
    }
}
