package MyGroup.Domain.Managers;

import MyGroup.Domain.Models.Poll;
import MyGroup.Domain.Models.User;
import MyGroup.Domain.Models.Vote;
import MyGroup.Domain.Models.VoteOption;

import java.util.HashMap;

public class PollManager {
    private HashMap<User, Poll> userPoll;
    private HashMap<Poll, VoteOption> optionsPoll;

    public PollManager() {

    }

    public PollManager(HashMap<User, Poll> userPoll, HashMap<User, Vote> userVotes, HashMap<Poll, VoteOption> optionsPoll) {
        this.userPoll = userPoll;
        this.optionsPoll = optionsPoll;
    }

    public HashMap<User, Poll> getUserPoll() {
        return userPoll;
    }

    public void setUserPoll(HashMap<User, Poll> userPoll) {
        this.userPoll = userPoll;
    }

    public HashMap<Poll, VoteOption> getOptionsPoll() {
        return optionsPoll;
    }

    public void setOptionsPoll(HashMap<Poll, VoteOption> optionsPoll) {
        this.optionsPoll = optionsPoll;
    }
}
