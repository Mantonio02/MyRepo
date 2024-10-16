package repo.domain.controllers;

import repo.domain.managers.DomainManager;
import repo.domain.models.Poll;
import repo.domain.models.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/voteOptions")
public class VoteOptionController {
    private final DomainManager domainManager;

    public VoteOptionController(@Autowired DomainManager domainManager) {
        this.domainManager = domainManager;
    }

    @GetMapping("/")
    public Collection<VoteOption> getAllVoteOptionsHandler() {
        //return domainManager.getAllVoteOptions();
        return null;
    }

    @GetMapping("/{option}")
    public ResponseEntity<Poll> getVoteOptionHandler(@PathVariable String caption) {
        return null;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Poll> createVoteOptionHandler(@RequestBody VoteOption voteOption) {
        return null;
    }

    @PutMapping("/{option}")
    public ResponseEntity<Poll> changeVoteOptionHandler(@PathVariable String caption, @RequestBody VoteOption voteOption) {
        return null;
    }

    @DeleteMapping("/{option}")
    public ResponseEntity<Poll> deleteVoteOptionHandler(@PathVariable String caption) {
        return null;
    }
}
