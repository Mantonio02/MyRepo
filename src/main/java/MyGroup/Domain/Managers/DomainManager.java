package MyGroup.Domain.Managers;

import MyGroup.Domain.Models.Poll;
import MyGroup.Domain.Models.User;
import MyGroup.Domain.Models.Vote;
import MyGroup.Domain.Models.VoteOption;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DomainManager {
    private HashMap<String, User> userList = new HashMap<>();
    private HashMap<User, Vote> userVotes;

    public DomainManager() {
    }

    public void addUser(User user) {
        if (!userList.containsValue(user.getUsername())) {
            userList.put(user.getUsername(), user);
        }
    }

    public User getUser(String username) {
        if (userList.containsKey(username)) {
            return userList.get(username);
        }

        return new User();
    }

    public boolean deleteUser(String username) {
        return this.userList.remove(username) != null;
    }

    public Collection<User> getAllUsers() {
        return userList.values();
    }
}
