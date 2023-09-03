import React, {useState} from "react";
import axios from "axios";
import {FaEye, FaEyeSlash} from "react-icons/fa6";
import {Link} from "react-router-dom";
import {TransactionPageButton} from "../../components/Buttons";

const PASSWORD_REGEX = /^.{8,}$/;

export default function RegisterPage() {

    const [jwt, setJwt] = useState("");
    const [username, setUsername] = useState("");

    const [password, setPassword] = useState("");
    const [validPassword, setValidPassword] = useState(false);

    const [type, setType] = useState("password");
    const [icon, setIcon] = useState(<FaEyeSlash/>);

    function sendRegisterRequest(e: React.MouseEvent<HTMLInputElement>) {
        const requestBody = {
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

    function handleEyeToggle() {
        if (icon.type === FaEyeSlash ) {
            setIcon(<FaEye />)
            setType("text")
        } else {
            setIcon(<FaEyeSlash />)
            setType("password")
        }
    }

    return (
        <div className="mt-56 px-32 bg-white/90 shadow-xl h-[38rem] w-[36.25rem] rounded-lg">
                <h1 className="my-20 text-center text-3xl font-bold text-baseColor">
                    Get Started
                </h1>
            <form className="flex flex-col items-center justify-center content-center w-full">
                <div className="pb-8 w-full">
                    <label htmlFor="username">Username</label>
                    <br/>
                    <input
                        className="input w-full font-bold"
                        type="text"
                        name="username"
                        id="username"
                        autoComplete="off"
                        onChange={(e) => {setUsername(e.target.value)}}
                        required />
                </div>
                <div className="pb-8 w-full">
                    <label htmlFor="password">Password </label>
                    <br/>
                    <div className="relative">
                        <span className="absolute right-0.5 bottom-1.5 text-baseColor cursor-pointer" onClick={handleEyeToggle}>{icon}</span>
                        <input
                            className="input w-full font-bold"
                            type={type}
                            name="password"
                            id="password"
                            autoComplete="off"
                            onChange={(e) => {setPassword(e.target.value)}}
                            required />
                    </div>
                    <small>Minimum eight characters</small>
                </div>

                <div className="bg-darkColor160 text-lightColor10 font-bold text-center w-full py-2 rounded">
                    <input
                        type="submit"
                        value="Submit"
                        onClick={e => sendRegisterRequest(e)}
                    />
                </div>

                <div className="inline-block text-left">
                    <small>Already have an account? </small>
                    <Link to="/">
                        <p className="text-sm underline underline-offset-4 decoration-2 decoration-lightColor30 inline">Log In</p>
                    </Link>
                </div>
            </form>
        </div>
    );
}