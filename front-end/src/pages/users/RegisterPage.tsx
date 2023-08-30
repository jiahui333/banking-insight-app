import React, {useState} from "react";
import axios from "axios";

export default function RegisterPage() {

    const [jwt, setJwt] = useState("");

    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function sendRegisterRequest(e: React.MouseEvent<HTMLInputElement>) {
        const requestBody = {
            "email": email,
            "username": username,
            "password": password
        }
        e.preventDefault();
        axios.post("http://localhost:8080/user/register", requestBody)
            .then(res => {
                setJwt(JSON.stringify(res.data.jwtToken))
            })
        localStorage.setItem("jwt", jwt);
    }

    return (
        <div className="mt-56">
            <form className="flex flex-col items-center justify-center bg-white/90 shadow-xl h-[22.5rem] w-[36.25rem] rounded-lg">
                <h1 className="text-4xl font-bold text-baseColor">
                    Register
                </h1>
                <div className="pt-12 pb-4">
                    <label htmlFor="email">Email: </label>
                    <input
                        type="text"
                        name="firstName"
                        id="firstName"
                        value = {email}
                        onChange={e => {setEmail(e.target.value)}}
                        required />
                </div>

                <div className="pb-8">
                    <label htmlFor="username">Username: </label>
                    <input
                        type="text"
                        name="username"
                        id="username"
                        value = {username}
                        onChange={e => {setUsername(e.target.value)}}
                        required />
                </div>
                <div className="pb-8">
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
        </div>
    );
}