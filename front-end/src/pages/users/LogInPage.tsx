import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import loginBackground from "../../assets/loginBackground.svg"
import {Navbar} from "../../components/Navbar";

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
        <div className="bg-no-repeat bg-cover h-screen flex items-center justify-center " style={{ backgroundImage: `url(${loginBackground})` }}>
            <form className="flex flex-col items-center justify-center bg-white/90 shadow-xl h-[22.5rem] w-[36.25rem] rounded-lg">
                <h1 className="text-4xl">Welcome Back</h1>
                <div className="pt-14 pb-4">
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
        </div>
    )

}