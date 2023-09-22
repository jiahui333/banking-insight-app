import React, {useState} from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";
import {Category} from "../../types/CategoryType";
import {PageButton} from "../../components/Buttons";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

export default function AddAccountPage() {
    const navigate = useNavigate();
    const [iban, setIban] = useState("");
    const [balance, setBalance] = useState("0");

    async function onSubmitForm (e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        await axios.post(`http://localhost:8080/accounts/add`,
            {
                iban: iban,
                balance: balance
            },
            { headers: { Authorization: `Bearer ${localStorage.getItem("jwt")}`}})
            .then(res =>{
                console.log(res.data)
            })
            .catch(err => console.log(err.response.data, err.message))
        console.log("add account jwt: " + localStorage.getItem("jwt"))
        navigate(`/accounts`)
    }

    return (
        <div className="bg-white/90 shadow-xl rounded-lg w-3/5 min-h-[24rem] text-bodyColor180 ">
            <h1 className="title mt-16">New Account</h1>
            <form onSubmit={onSubmitForm} className="text-bodyColor180 flex flex-col items-center justify-center content-center w-full">
                <label>
                    IBAN:
                    <input
                        className="ml-1 input"
                        type="text"
                        onChange={e => setIban(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Balance:
                    <input
                        className="ml-1 input"
                        type="text"
                        onChange={e => setBalance(e.target.value)}
                    />
                </label>
                <div className="flex gap-16 mt-10">
                    {PageButton("Submit")}
                    <Link to={`/accounts/`}>
                        {PageButton("Cancel")}
                    </Link>
                </div>
            </form>
        </div>
    )
}