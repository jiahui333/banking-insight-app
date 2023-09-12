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

    async function onSubmitForm (e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        await axios.post(`http://localhost:8080/accounts/add`,
            {
                iban: iban,
                balance: 0
            },
            { headers: { Authorization: `Bearer ${localStorage.getItem("jwt")}`}})
            .then(res =>{
                console.log(res.data)
            })
            .catch(err => console.log(err.response.data, err.message))
        console.log("add account jwt: " + localStorage.getItem("jwt"))
        // navigate(`/accounts`)
    }

    return (
        <div>
            <h1 className="title">New Transaction</h1>
            <form onSubmit={onSubmitForm}>
                <label>
                    IBAN:
                    <input
                        className="ml-1"
                        type="text"
                        onChange={e => setIban(e.target.value)}
                    />
                </label>
                <div className="flex justify-around mt-6">
                    {PageButton("Submit")}
                </div>
            </form>
        </div>
    )
}