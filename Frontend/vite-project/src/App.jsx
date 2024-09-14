import './App.css'

function CreateUserComponent() {
    return (
        <>
            <h1>Create User</h1>
            <form className={"creator"}>
                <input className={"textbox"} placeholder={"Username"} required/>
                <input className={"textbox"} placeholder={"Email"} required/>
                <input className={"textbox"} placeholder={"Password"} required/>
                <button>Submit</button>
            </form>
        </>
    );
}

function CreatePollComponent() {
    return (
        <>
            <h1>Create Poll</h1>
            <form className={"creator"}>
                <input className={"textbox"} placeholder={"Question"} required/>
                <input placeholder={"Option 1"} required/>
                <input placeholder={"Option 2"} required/>
                <button>Submit</button>
            </form>
        </>
        // TODO: Implement a form that requires a question and VoteOptions.
        //  The poll should be registered as released at exact time and date
        //  as it was published, and the expiration date is up for choice.
        //  Note that each registered poll should have its own unique id.

        // TODO: Implement some sort of way to create N VoteOptions,
        //  with N being the creator's demand of amount.
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