import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {SubmitButton} from "../../components/Buttons";

export default function LogInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [jwt, setJwt] = useState("");
    const [error, setError] = useState(null)

    const navigate = useNavigate();

   function sendLogInRequest(e: React.MouseEvent<HTMLButtonElement>) {
        const requestBody = {
            "username": username,
            "password": password
        }
        e.preventDefault();
       axios.post("http://localhost:8080/user/authenticate", requestBody)
            .then(res => {
                const jwt = res.data.jwtToken
                setJwt(jwt)
                localStorage.setItem("jwt", jwt);
                // console.log("login page jwt: " + jwt + new Date().getTime())
                navigate("/accounts", { state: { username: requestBody.username } });
            })
           .catch(err => {
                setError(err)
            })

    }

    function getErrorView() {
       if (error) {
           return (
               <div className="pt-4">
                   <p>Ops, wrong credentials. Please try again.</p>
               </div>
           )
       }
    }

    return (
        <div className="mt-56">
            <form className="flex flex-col items-center justify-center bg-white/90 shadow-xl h-[22.5rem] w-[36.25rem] rounded-lg">
                <h1 className="text-4xl font-bold text-baseColor">Log In</h1>
                <div className="pt-12 pb-4">
                    <label htmlFor="username">Username: </label>
                    <input
                        className="input"
                        type="text"
                        name="username"
                        id="username"
                        onChange={e => {setUsername(e.target.value)}}
                        required />
                </div>
                <div className="pb-8">
                    <label htmlFor="password">Password: </label>
                    <input
                        className="input"
                        type="password"
                        name="pass"
                        id="password"
                        onChange={e => {setPassword(e.target.value)}}
                        required />
                </div>
                <div>
                    <SubmitButton onClick={(e) => sendLogInRequest(e)}/>
                </div>
                {getErrorView()}
            </form>

        </div>
    )

}