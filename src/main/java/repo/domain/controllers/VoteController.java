package repo.domain.controllers;

import repo.domain.managers.DomainManager;
import repo.domain.models.Poll;
import repo.domain.models.User;
import repo.domain.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/votes")
public class VoteController {
    private final DomainManager domainManager;

    public VoteController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

    @GetMapping("/")
    public Collection<Vote> getAllVotesHandler() {
        //return domainManager.getAllVotes();
        return null;
    }

    @GetMapping("/{username}/{vote}")
    public ResponseEntity<Poll> getVoteHandler(@PathVariable String username, @PathVariable String voteID) {
        User user = domainManager.getUser(username);
        return null;
    }

    @PostMapping(value = "/{username}")
    public ResponseEntity<Poll> makeVoteHandler(@PathVariable String username, @RequestBody Vote vote) {
        User user = domainManager.getUser(username);
        return null;
    }

    @PutMapping("/{username}")
    public ResponseEntity<Poll> changeVoteHandler(@PathVariable String username, @RequestBody Vote vote) {
        User user = domainManager.getUser(username);
        return null;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Poll> deleteVoteHandler(@PathVariable String username) {
        User user = domainManager.getUser(username);
        return null;
    }
}
