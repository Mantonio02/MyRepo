import './App.css'

const user = {
    username: "JohnDoe",
    email: "johndoe@email.com",
    password: "ASimplePWDForTestingPurposes"
}

function CreateUserComponent() {
    return (
        <>
            <form className={"creator"}>
                <h1>Create User</h1>
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
            <form className={"creator"}>
                <h1>Create Poll</h1>
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
       <>
           <div className={"poll"}>
               <h2>Poll made by {user.username}</h2>
               <p>What quote do you think is most iconic?</p>
               <button>I Like Turtles</button>
               <button>Here Comes Johnny!</button>
           </div>
       </>
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