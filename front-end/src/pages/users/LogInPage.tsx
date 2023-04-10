import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export default function LogInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [jwt, setJwt] = useState("");

    const navigate = useNavigate();

   function sendLogInRequest(e: React.MouseEvent<HTMLInputElement>) {
        const requestBody = {
            "username": username,
            "password": password
        }
        e.preventDefault();
       axios.post("http://localhost:8080/user/authenticate", requestBody)
            .then(res => {
                setJwt(JSON.stringify(res.data.jwtToken))
            })
       if (!jwt) {
           localStorage.setItem("jwt", jwt);
       }
       navigate("/accounts")
    }

    return (
        <form>
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
                <input type="submit" value="Submit" onClick={e => sendLogInRequest(e)}/>
            </div>
        </form>
    )

}