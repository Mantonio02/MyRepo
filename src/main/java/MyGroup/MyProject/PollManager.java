package MyGroup.MyProject;

import java.util.HashMap;

public class PollManager {
    private HashMap<User, Poll> userPoll;

    public PollManager() {

    }

    public PollManager(HashMap<User, Poll> userPoll) {
        this.userPoll = userPoll;
    }

    public HashMap<User, Poll> getUserPoll() {
        return userPoll;
    }

    public void setUserPoll(HashMap<User, Poll> userPoll) {
        this.userPoll = userPoll;
    }
}
