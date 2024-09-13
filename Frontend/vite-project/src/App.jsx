import './App.css'

function CreateUserComponent() {
    return <p>This component creates a user.</p>;
}

function CreatePollComponent() {
    return <p>This component creates a poll.</p>;
}

function VoteComponent() {
   return <p>This component consists of voting.</p>;
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