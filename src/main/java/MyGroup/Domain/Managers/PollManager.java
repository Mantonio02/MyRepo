package MyGroup.Domain.Managers;

import MyGroup.Domain.Models.Poll;
import MyGroup.Domain.Models.User;
import MyGroup.Domain.Models.Vote;
import MyGroup.Domain.Models.VoteOption;

import java.lang.reflect.Array;
import java.util.*;

public class PollManager {
    private HashMap<User, Poll> userPoll;
    private Set<VoteOption> optionsPoll;

    public PollManager() {
        this.userPoll = new HashMap<User, Poll>();
        this.optionsPoll = new HashSet<VoteOption>(2);
    }

    public void addPoll(User user, Poll poll) {
        if (!userPoll.containsValue(poll)) {
            userPoll.put(user, poll);
        }
    }

    public Poll getPoll(String question) {
        for (User user : userPoll.keySet()) {
            if (userPoll.get(user).getQuestion().equals(question)) {
                return userPoll.get(user);
            }
        }

        return new Poll();
    }

    public boolean deletePoll(User user) {
        return this.userPoll.remove(user) != null;
    }

    public Collection<Poll> getAllPolls() {
        return userPoll.values();
    }

    public HashMap<User, Poll> getUserPoll() {
        return this.userPoll;
    }
}
