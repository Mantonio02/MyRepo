package repo.domain.controllers;

import repo.domain.managers.DomainManager;
import repo.domain.models.Poll;
import repo.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/polls")
public class PollController {
    /**
     * Note: PollController builds upon UserController, which in turn builds upon
     * Lecture 07's LocationController. This class' code is unfinished.
     *
     * <a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/backend/src/main/java/no/hvl/dat250/l06/LocationController.java">LocationController</a>
     * */

    private final DomainManager domainManager;

    public PollController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

    @GetMapping("/")
    public Collection<Poll> getAllPollsHandler() {
        return domainManager.getPollManager().getAllPolls();
    }

    @GetMapping("/{username}/{question}")
    public ResponseEntity<Poll> getPollHandler(@PathVariable String username, @PathVariable String question) {
        User user = domainManager.getUser(username);
        if (domainManager.getPollManager().getUserPoll().get(user).getQuestion() != null) {
            return ResponseEntity.ok(domainManager.getPollManager().getPoll(question));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{username}")
    public ResponseEntity<Poll> createPollHandler(@PathVariable String username, @RequestBody Poll poll) {
        User user = domainManager.getUser(username);
        domainManager.getPollManager().addPoll(user, poll);
        return ResponseEntity.created(URI.create("/" + poll.getQuestion())).body(poll);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Poll> changePollHandler(@PathVariable String username, @RequestBody Poll poll) {
        User user = domainManager.getUser(username);
        if (domainManager.getPollManager().getUserPoll().containsKey(user)) {
            domainManager.getPollManager().getUserPoll().replace(user, poll);
            return ResponseEntity.created(URI.create("/" + user.getUsername())).body(poll);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Poll> deletePollHandler(@PathVariable String username) {
        User user = domainManager.getUser(username);
        boolean wasPresent = this.domainManager.getPollManager().deletePoll(user);
        if (wasPresent) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
