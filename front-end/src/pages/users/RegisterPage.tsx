import React, {useState} from "react";
import axios from "axios";

export default function RegisterPage() {

    const [jwt, setJwt] = useState("");

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstName] = useState("");
    const [secondName, setSecondName] = useState("");

    async function sendRegisterRequest(e: React.MouseEvent<HTMLInputElement>) {
        const requestBody = {
            "firstName": firstName,
            "secondName": secondName,
            "username": username,
            "password": password
        }
        e.preventDefault();
        await axios.post("http://localhost:8080/user/register", requestBody)
    }

    return (
        <form>
            <div>
                <label htmlFor="firstName">First name: </label>
                <input
                    type="text"
                    name="firstName"
                    id="firstName"
                    value = {firstName}
                    onChange={e => {setFirstName(e.target.value)}}
                    required />
            </div>

            <div>
                <label htmlFor="secondName">Second name: </label>
                <input
                    type="text"
                    name="secondName"
                    id="secondName"
                    value = {secondName}
                    onChange={e => {setSecondName(e.target.value)}}
                    required />
            </div>

            <div>
                <label htmlFor="username">Username: </label>
                <input
                    type="text"
                    name="username"
                    id="username"
                    value = {username}
                    onChange={e => {setUsername(e.target.value)}}
                    required />
            </div>
            <div>
                <label htmlFor="password">Password </label>
                <input
                    type="password"
                    name="pass"
                    id="password"
                    value = {password}
                    onChange={e => {setPassword(e.target.value)}}
                    required />
            </div>
            <div>
                <input type="submit" value="Submit" onClick={e => sendRegisterRequest(e)}/>
            </div>
        </form>
    );
}