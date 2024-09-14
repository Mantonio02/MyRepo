import './App.css'

function CreateUserComponent() {
    return (
        <h1>Create User</h1>
        // TODO: Implement a form that requires
        //  username, email and password to be registered.
    );
}

function CreatePollComponent() {
    return (
        <h1>Create Poll</h1>
        // TODO: Implement a form that requires a question and VoteOptions.
        //  The poll should be registered as released at exact time and date
        //  as it was published, and the expiration date is up for choice.
    );
}

function VoteComponent() {
   return (
       <h1>Vote</h1>
       // TODO: Implement buttons for VoteOptions.
       //  Current plan is to iterate through a list of
       //  them to create a button for each VoteOption (element).
   );
}

export default function App() {
    return (
        <div>
            <CreateUserComponent />
            <CreatePollComponent />
            <VoteComponent />
        </div>
    );
}