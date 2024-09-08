DAT250 Expass2

On this assignment I have done the following:
- Step 0: Downloaded Bruno as preferred HTTP client.
- Step 1: Skipped because I already made the repository back in previous assignment.
- Step 2: Implemented Java Beans for all the class diagrams User, Poll, Vote and VoteOption, and the mentioned manager classes PollManager and DomainManager.
- Step 3: Made a test scenario like the one mentioned in expass2.md on Bruno.
- Step 4: Began implementing controllers. With the exception of UserController, I have so far only made what could be referred as skeleton code for the others.
- Step 5: Have not done it.
- Step 6: - - || - -
- Step 7: - - || - -

Technical Installation Issues:
- On this assignment I encountered no particular technical issues with downloading software.
From what I can gather from expass 1, I followed the suggested tutorials that were provided, and in cases where I received errors during installation, I tried to resolve it by taking a look at the error messages that would occur. If I could not fix it, Google had an answer in most cases.

Pending Issues:
- I did not manage to complete step 4 and beyond, a lot of time went into trying to understand the concepts of this assignment whenever things went wrong.

Experiment results:
- I managed to make some of the test scenarios work. Those are creating a new user, list it, create another and list them. At the part of making polls, votes and voting options I did not finish coding them for testing.
- Create New User, POST http://localhost:8080/users/ ->
  Body:
    ```json
    {
      "username": "UserA",
      "email": "abc@email.com"
    }
    ```

  Response: 201 Created
    ```json
    {
      "username": "UserA",
      "email": "abc@email.com"
    }
    ```

  Associated code:
    ```java
    // UserController.java
    @PostMapping(value = "/")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) {
        this.domainManager.addUser(user);
        return ResponseEntity.created(URI.create("/" + user.getUsername())).body(user);
    }

    // DomainManager.java
    public void addUser(User user) {
        if (!userList.containsValue(user.getUsername())) {
            userList.put(user.getUsername(), user);
        }
    }

    // User.java
    public getUsername() {
        return username;
    }
    ```

- List User, GET http://localhost:8080/users/ ->
  Response: 200 OK
    ```json
    {
      {
        "username": "UserA",
        "email": "abc@email.com"
      }
    }
    ```

  Associated code:
    ```java
    // UserController.java
    @GetMapping("/")
    public Collection<User> getAllUsersHandler() {
        return domainManager.getAllUsers();
    }

    // DomainManager.java
    public Collection<User> getAllUsers() {
        return userList.values();
    }
    ```

- Create Another User, POST http://localhost:8080/users/ ->
  Body:
    ```json
    {
      "username": "UserB",
      "email": "def@email.com"
    }
    ```

  Response: 201 Created
    ```json
    {
      "username": "UserA",
      "email": "abc@email.com"
    }
    ```

  Associated code: See Create New User.

- List Users, GET http://localhost:8080/users/ ->
  Response: 200 OK
    ```json
    {
      {
        "username": "UserB",
        "email": "def@email.com"
      },
      {
        "username": "UserA",
        "email": "abc@email.com"
      }
    }
    ```

  Associated code: See List User.
  
    
  
