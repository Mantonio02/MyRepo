package MyGroup.Domain.Controllers;

import MyGroup.Domain.Managers.DomainManager;
import MyGroup.Domain.Managers.PollManager;
import MyGroup.Domain.Models.Poll;
import MyGroup.Domain.Models.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final DomainManager domainManager;

    public PollController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

//    @GetMapping("/{user}")
//    public ResponseEntity<Poll> getPoll(@PathVariable User user) {
//        if (pollManager.getUserPoll().containsKey(user)) {
//            return ResponseEntity.ok(pollManager.getUserPoll().get(user));
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/{user}")
//    public ResponseEntity<Poll> createPoll(@PathVariable User user, @RequestBody Poll poll) {
//        pollManager.getUserPoll().put(user, poll);
//        return ResponseEntity.created(URI.create("/" + user)).body(poll);
//    }
//
//    @PutMapping("/{user}")
//    public ResponseEntity<Poll> changePoll(@PathVariable User user, @RequestBody Poll poll) {
//        if (pollManager.getUserPoll().containsKey(user)) {
//            pollManager.getUserPoll().replace(user, poll);
//            return ResponseEntity.created(URI.create("/" + user)).body(poll);
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{user}")
//    public ResponseEntity<Poll> deletePoll(@PathVariable User user, @RequestBody Poll poll) {
//        pollManager.getUserPoll().remove(user, poll);
//        return ResponseEntity.notFound().build();
//    }
}
