import React, {useState} from "react";
import axios from "axios";
import {Form} from "../../components/Form";
import {FaCircleExclamation} from "react-icons/fa6";
import {useNavigate} from "react-router-dom";

const PASSWORD_REGEX = /^.{8,}$/;

export default function RegisterPage() {

    const [jwt, setJwt] = useState("");
    const [username, setUsername] = useState("");

    const [password, setPassword] = useState("");
    const [valid, setValid] = useState(true)

    const navigate = useNavigate();

    function validatePasswordFormat() {
        if (!valid) {
            return (
                <p><FaCircleExclamation className="inline text-darkColor160"/> Password must be at least 8 characters.</p>
            )
        }
    }

    function sendRegisterRequest(e: React.MouseEvent<HTMLInputElement>) {
        e.preventDefault();

        if (!PASSWORD_REGEX.test(password)) {
            setValid(false)
        } else{
            const requestBody = {
                "username": username,
                "password": password
            }
            axios.post("http://localhost:8080/user/register", requestBody)
                .then(res => {
                    const jwt = res.data.jwtToken
                    setJwt(JSON.stringify(res.data.jwtToken))
                    localStorage.setItem("jwt", jwt);
                    navigate("/accounts", { state: { username: requestBody.username } });
                })
        }
    }

    return (
        <Form
            title="Get Started"
            errView={validatePasswordFormat()}
            username={username}
            password={password}
            passComment="Minimum eight characters"
            setUsername={setUsername}
            setPassword={setPassword}
            sendRequest={sendRegisterRequest}
            alternativeMessage="Already have an account?"
            alternativePath="/"
            alternativePathName="Log In"
        />

    );
}