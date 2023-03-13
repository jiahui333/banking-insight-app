import React, {ChangeEvent, useState} from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";


export default function AddTransactionPage() {

    const navigate = useNavigate();

    const [transaction, setTransaction] = useState({
        flowType: "",
        receiver: "",
        amount:""
        })

    //destructure
    const {flowType, receiver, amount} = transaction;

    //spread operator
    const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setTransaction({...transaction,[e.target.name]:e.target.value})
    }

    const onSubmitForm = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/transactions", transaction)
        navigate("/transactions")
    }

    return (
        <div>
            <h1>New Transaction</h1>
            <form onSubmit={(e => onSubmitForm(e))}>
                <label>
                    Flow type:
                    <input
                        type="text"
                        name="flowType"
                        value={flowType}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <label>
                    Receiver:
                    <input
                        type="text"
                        name="receiver"
                        value={receiver}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <label>
                    Amount:
                    <input
                        type="text"
                        name="amount"
                        value={amount}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <input type="submit" value="Submit" />
                <Link to={"/transactions"}>
                    <input type="button" value="Cancel" />
                </Link>
            </form>
        </div>
    )
}