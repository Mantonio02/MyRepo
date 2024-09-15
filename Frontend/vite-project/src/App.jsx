import './App.css'
import { useState } from 'react'

let newQuestion;
let newOption1;
let newOption2;
let publishedAt;
let validUntil;

//const polls = () =>  {
//  return fetch('/polls')
//        .then((response) => {
//            return response.json();
//        })
//}

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

// Based off function createNewLocation from App.svelte in Lecture 06 SPAs:
// https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l06_SPAs/frontend/src/App.svelte.
function createPoll(e) {
    e.preventDefault();
    fetch('/polls', {
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
            console.log("Poll created.");
            newQuestion = "";
            newOption1 = "";
            newOption2 = "";
        }
    }).catch((error) => {
        alert(error.message);
    })
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
    );
}

function VoteComponent() {
    const polls = poll.options.map(option =>
        <button key={option.presentationOrder}>
            {option.caption}
        </button>
    );

    return (
        <>
            <div className={"poll"}>
                <h2>Poll by {user.username}</h2>
                <p>{poll.question}</p>
                {polls}
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