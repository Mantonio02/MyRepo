package MyGroup.Domain.Controllers;

import MyGroup.Domain.Managers.DomainManager;
import MyGroup.Domain.Models.Poll;
import MyGroup.Domain.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final DomainManager domainManager;

    public VoteController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

//    @GetMapping("/")
//    public Collection<ArrayList<Poll>> getAllPollsHandler() {
//        return domainManager.getPollManager().getAllPolls();
//    }
//
//    @GetMapping("/{poll}")
//    public ResponseEntity<ArrayList<Poll>> getPollHandler(@PathVariable Poll poll) {
//        return ResponseEntity.ok(domainManager.getPollManager().getPoll(poll));
//    }
//
//    @PostMapping(value = "/")
//    public ResponseEntity<User> createUserHandler(@RequestBody User user) {
//        this.domainManager.addUser(user);
//        return ResponseEntity.created(URI.create("/" + user.getUsername())).body(user);
//    }
//
//    @PutMapping("/{username}")
//    public ResponseEntity<User> changeUserHandler(@PathVariable String username, @RequestBody User user) {
//        if (domainManager.getAllUsers().contains(user)) {
//            User hasUser = this.domainManager.getUser(username);
//            hasUser.setUsername(user.getUsername());
//            hasUser.setEmail(user.getEmail());
//            return ResponseEntity.ok(hasUser);
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{username}")
//    public ResponseEntity<User> deleteUserHandler(@PathVariable String username) {
//        boolean wasPresent = this.domainManager.deleteUser(username);
//        if (wasPresent) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.notFound().build();
//    }
}
