package repo.domain.controllers;

import repo.domain.managers.DomainManager;
import repo.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    /**
     * Note: UserController builds upon Lecture 07's LocationController.
     * <a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/backend/src/main/java/no/hvl/dat250/l06/LocationController.java">LocationController</a>
     * */

    private final DomainManager domainManager;

    public UserController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

    @GetMapping("/")
    public Collection<User> getAllUsersHandler() {
        return domainManager.getAllUsers();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserHandler(@PathVariable String username) {
        return ResponseEntity.ok(domainManager.getUser(username));
    }

    /**
     * Based off LocationController.java's createLocationHandler (without exception) from Lecture 06:
     * <a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/backend/src/main/java/no/hvl/dat250/l06/LocationController.java">LocationController</a>
     */
    @PostMapping(value = "/")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) {
        this.domainManager.addUser(user);
        return ResponseEntity.created(URI.create("/" + user.getUsername())).body(user);
    }

    /**
     * Based off LocationController.java's updateLocationHandler (without use of Optional) from Lecture 06:
     * <a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/backend/src/main/java/no/hvl/dat250/l06/LocationController.java">LocationController</a>
     */
    @PutMapping("/{username}")
    public ResponseEntity<User> changeUserHandler(@PathVariable String username, @RequestBody User user) {
        if (domainManager.getAllUsers().contains(user)) {
            User hasUser = this.domainManager.getUser(username);
            hasUser.setUsername(user.getUsername());
            hasUser.setEmail(user.getEmail());
            return ResponseEntity.ok(hasUser);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Based off LocationController.java's deleteLocationHandler from Lecture 06:
     * <a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/backend/src/main/java/no/hvl/dat250/l06/LocationController.java">LocationController</a>
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<User> deleteUserHandler(@PathVariable String username) {
        boolean wasPresent = this.domainManager.deleteUser(username);
        if (wasPresent) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
