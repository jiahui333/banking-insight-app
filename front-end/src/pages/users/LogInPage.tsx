import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {Form} from "../../components/Form";
import {FaCircleExclamation} from "react-icons/fa6";

export default function LogInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [jwt, setJwt] = useState("");
    const [error, setError] = useState(null)

    const navigate = useNavigate();

   function sendLogInRequest(e: React.MouseEvent<HTMLInputElement>) {
         e.preventDefault();
        const requestBody = {
            "username": username,
            "password": password
        }
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
               <p><FaCircleExclamation className="inline text-darkColor160"/> Ops, wrong credentials. Please try again.</p>
           )
       }
    }

    return (
        <Form
            title="Welcome Back"
            errView={getErrorView()}
            username={username}
            password={password}
            passComment=""
            setUsername={setUsername}
            setPassword={setPassword}
            sendRequest={sendLogInRequest}
            alternativeMessage = "Do not have an account?"
            alternativePath="/register"
            alternativePathName="Register"
        />
    )
}