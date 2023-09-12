import {Link} from "react-router-dom";
import React, {useState} from "react";
import {FaCircleExclamation, FaEye, FaEyeSlash} from "react-icons/fa6";
import {FormProps} from "../types/FormPropsType";

export function Form(props: FormProps) {

    const [type, setType] = useState("password");
    const [icon, setIcon] = useState(<FaEyeSlash/>);

    function handleEyeToggle() {
        if (icon.type === FaEyeSlash) {
            setIcon(<FaEye/>)
            setType("text")
        } else {
            setIcon(<FaEyeSlash/>)
            setType("password")
        }
    }

    return (
        <div className="mt-56 px-32 bg-white/90 shadow-xl h-[38rem] w-[36rem] rounded-lg relative">
            <h1 className="my-20 text-center text-3xl font-bold text-baseColor">
                {props.title}
            </h1>
            <div className="text-sm mb-4 absolute top-36">
                {props.errView}
            </div>
            <form className="text-bodyColor180 flex flex-col items-center justify-center content-center w-full">
                <div className="pb-8 w-full">
                    <label htmlFor="username">Username</label>
                    <br/>
                    <input
                        className="input w-full font-bold"
                        type="text"
                        name="username"
                        id="username"
                        autoComplete="off"
                        onChange={(e) => props.setUsername(e.target.value)}
                        required/>
                </div>
                <div className="pb-8 w-full">
                    <label htmlFor="password">Password </label>
                    <br/>
                    <div className="relative">
                        <span className="absolute right-0.5 bottom-1.5 text-baseColor cursor-pointer"
                              onClick={handleEyeToggle}>{icon}</span>
                        <input
                            className="input w-full font-bold"
                            type={type}
                            name="password"
                            id="password"
                            autoComplete="off"
                            onChange={(e) => props.setPassword(e.target.value)}
                            required/>
                    </div>
                    <small>{props.passComment}</small>
                </div>

                <input
                    className="bg-darkColor160 text-lightColor10 font-bold text-center w-full py-2 rounded cursor-pointer"
                    type="submit"
                    value="Submit"
                    onClick={props.sendRequest}
                />


                <div className="inline-block text-left">
                    <p className="text-sm inline">{props.alternativeMessage} </p>
                    <Link to={props.alternativePath}>
                        <p className="text-sm underline underline-offset-4 decoration-2 decoration-lightColor30 inline">
                            {props.alternativePathName}
                        </p>
                    </Link>
                </div>
            </form>
        </div>
    )
}