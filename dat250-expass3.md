DAT250 Expass3

On this assignment I have done the following:

- Step 1: I managed to set up the Node project. I chose React as my preferred framework.
- Step 2: I managed to set up three components:
    1. CreateUserComponent (as mentioned in the introduction),
    2. CreatePollComponent, and
    3. VoteComponent.
- Step 3: I enabled CORS through the @CrossOrigin annotation to each Controller class in the backend.
- Step 4: I begun integrating frontend and backend via fetch, however this is where I stumbled into issues when changing what was already established within the React Components and valid HTTP requests. These issues are mentioned later on.
- Step 5: Have not done anything related to this step.
- Step 6: -- || --

Technical Issues:
- At the start of the Node project set up, I encountered some issues with file management because I did not know where to place the files for the frontend. I fixed it by removing what was done, and set up the project again at a more appropiate file location.
- Sometime during step 1, the backend's java classes from previous assignment had all its content erased with the exception of the classes mentioned in their respective files. I fixed it by going back to a previous push in the main repository.

Link to Frontend folder:
https://github.com/Mantonio02/MyRepo/tree/main/Frontend/vite-project

Link to React App:
https://github.com/Mantonio02/MyRepo/blob/main/Frontend/vite-project/src/App.jsx

Other Issues:
- The React Components in step 4 went invisible on the web page after using fetch to get all the polls to output them through VoteComponent. I suspect this occurred due to a failed HTTP request by status code 404, missing code, or a case of there being no available polls (although it would be weird for the manner that all the components vanishes). Thus I opted to keep the solution for the test values that were already available in App.jsx.
- CreateUserComponent does not currently do anything other than alerting the viewer when they have submitted the user registration form.
- CreatePollComponent sends a HTTP request when the submit button is clicked, however it fails due to 404 error.
- There is no apparent way for user to make N voting options by the frontend, only 2.
- Due to not completing all the steps in the previous assignment, progress in step 4 somewhat halted. I.e. some Controller classes not fully implemented.
- The mappings of PollController does not match with the post request from App.jsx.
