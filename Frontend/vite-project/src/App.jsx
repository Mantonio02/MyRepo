import './App.css'
import { useState } from 'react'

let newQuestion;
let newOption1;
let newOption2;
let publishedAt;
let validUntil;

const polls = fetch('/polls')
        .then((response) => {
            return response.json();
        })

const options = () => {
    return fetch('/voteOptions')
        .then((response) => {
            return response.json();
        })
}

const votes = () => {
    return fetch('/votes')
        .then((response) => {
            return response.json();
        })
}

const user = {
    username: "JohnDoe",
    email: "johndoe@email.com",
    password: "ASimplePWDForTestingPurposes"
}

const poll = {
    question: "What quote do you think is most iconic?",
    publishedAt: "2024-09-14T21:47:49.12Z",
    validUntil: "2025-09-14T21:47:49.12Z",
    options: [
        {caption: "I Like Turtles", presentationOrder: 1},
        {caption: "Here Comes Johnny!", presentationOrder: 2},
        {caption: "I Am Your Father", presentationOrder: 3}
    ]
}

function CreateUserComponent() {
    function handleSubmit() {
        alert("User registered!")
    }

    return (
        <>
            <form className={"creator"}>
                <h1>Create User</h1>
                <input className={"textbox"} placeholder={"Username"} required/>
                <input className={"textbox"} placeholder={"Email"} required/>
                <input className={"textbox"} placeholder={"Password"} required/>
                <button onClick={handleSubmit} disabled>Submit</button>
            </form>
        </>
    );
}

function CreatePollComponent() {
    const [question, setQuestion] = useState('');
    const [option1, setOption1] = useState('');
    const [option2, setOption2] = useState('');

    function createPoll() {
        fetch('/polls/', {
            method: 'POST',
            body: JSON.stringify({
                question: newQuestion,
                option1: newOption1,
                option2: newOption2
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response) => {
            if (response.status === 201) {
                newQuestion = "";
                newOption1 = "";
                newOption2 = "";
            }
        }).catch((error) => {
            alert(error.message);
        })
    }

    return (
        <>
            <form className={"creator"}>
                <h1>Create Poll</h1>
                <input
                    value={question}
                    onChange={e => setQuestion(e.target.value)}
                    className={"textbox"}
                    placeholder={"Question"}
                    required
                />
                <input
                    value={option1}
                    onChange={e => setOption1(e.target.value)}
                    className={"textbox"}
                    placeholder={"Option 1"}
                    required
                />
                <input
                    value={option2}
                    onChange={e => setOption2(e.target.value)}
                    className={"textbox"}
                    placeholder={"Option 2"}
                    required
                />
                <button onClick={createPoll}>Submit</button>
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
    const voteOptions = poll.options.map(option =>
        <>
            <button key={option.presentationOrder}>
                {option.caption} | 0 votes
            </button>
        </>
    );

    return (
        <>
            <div className={"poll"}>
                <h2>Poll made by {user.username}</h2>
                {voteOptions}
            </div>
        </>
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