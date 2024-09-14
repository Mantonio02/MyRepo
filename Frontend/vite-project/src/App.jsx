import './App.css'
import { useState } from 'react'

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
    function handleSubmit() {
        alert("Poll registered!")
    }

    return (
        <>
            <form className={"creator"}>
                <h1>Create Poll</h1>
                <input className={"textbox"} placeholder={"Question"} required/>
                <input className={"textbox"} placeholder={"Additional options"} id={"extra"}/>
                <input className={"textbox"} placeholder={"Option 1"} required/>
                <input className={"textbox"} placeholder={"Option 2"} required/>
                <button onClick={handleSubmit} disabled>Submit</button>
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
                <p>{poll.question}</p>
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