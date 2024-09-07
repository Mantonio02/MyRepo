package MyGroup.Domain;

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

	// Class Diagrams:
	// Aggregations (0-) enforces the object structures connected by the respective association to form a hierarchy.
	// 	User 0- created arbitrary many -> Poll
	// 	User 0- voted arbritrary many -> Vote
	// 	Poll 0- at least two -> VoteOption
	// 	Vote arbitrary many -> exactly one VoteOption

	// Write handlers for fetching (@GetMapping), creating (@PostMapping), updating (@PutMapping), and deleting (@DeleteMapping)
	// for User, Poll, VoteOption, and Vote in respective controller classes annotated with @RestController.

	// @JsonIgnore, @JsonIdentityInfo, @JsonIdentityReference, @JsonManagedReference, @JsonBackReference, or @JsonView might be useful.
	// You might find ways to identify users, polls, votes and voting options in the URLs.

	/*
	* Step 3: Design one or more test scenarios before starting to implement handlers,
	* it can be done by designing a sequence of requests in the HTTP client of choice.
	* One such scenario your app should support would look like this:
	*
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

	/*
	* Step 4: Use @RestController and @...Mapping annotations to define handlers that realise the required behavior.
	* You will have to think about resource identification, i.e. paths and presentation, i.e. JSON de-/serialization.
	* */

	/*
	* Step 5: Your test scenarios should become code such that they can be run automatically without any user interaction.
	* You might choose whether you want to use the proprietary testing mechanisms of your HTTP client,
	* or you can write them in Java, e.g. by using Spring's RestClient.
	* */

	/*
	* Step 6: (Optional) Check our Springdoc proect and add the following two dependencies to your build.gradle.kts:
	* 	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	* 	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.6.0")
	*
	* Visit http://127.0.0.1:8080/swagger-ui.html afterwards. Do you recognise the handlers and are they documented correctly?
	* */

	/*
	* Step 7: (Optional) Create a GitHub Actions workflow that runs the test scenarios you created in Step 6 automatically.
	* */
}