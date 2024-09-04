package MyGroup.MyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	// Write handlers for fetching (@GetMapping), creating (@PostMapping), updating (@PutMapping), and deleting (@DeleteMapping)
	// for User, Poll, VoteOption, and Vote in respective controller classes annotated with @RestController.

	// @JsonIgnore, @JsonIdentityInfo, @JsonIdentityReference, @JsonManagedReference, @JsonBackReference, or @JsonView might be useful.
	// You might find ways to identify users, polls, votes and voting options in the URLs.

	// Design one or more test scenarios before starting to implement handlers, it can be done by designing a sequence of requests in the HTTP client of choice.
	// One such scenario your app should support would look like this:
	/*
	* - Create a new user.
	* - List all users -> shows the newly created user.
	* - Create another user.
	* - List all users again -> shows two users.
	* - User 1 creates a new poll.
	* - List polls -> shows the new poll.
	* - User 2 votes on the poll.
	* - User 2 changes his vote.
	* - List -> shows the most recent vote for User 2.
	* - Delete one poll.
	* - List votes -> empty.
	* */
}
