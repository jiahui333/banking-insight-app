import React, {useState} from "react";
import axios from "axios";
import {Link, useNavigate, useParams} from "react-router-dom";


export default function AddTransactionPage() {

    const navigate = useNavigate();

    const { id } = useParams() as { id: string };
    const account_id: number = +id

    const [transaction, setTransaction] = useState({
        flowType: "",
        sender:"",
        receiver: "",
        amount:""
        })

    //destructure
    // const {flowType, sender, receiver, amount} = transaction;

    //spread operator
    const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setTransaction({...transaction,[e.target.name]:e.target.value})
    }
    const onSubmitForm = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        await axios.post(`http://localhost:8080/accounts/${account_id}/transactions`, transaction)
        navigate(`/accounts/${account_id}/transactions`)
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
                        value={transaction.flowType}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <label>
                    Sender:
                    <input
                        type="text"
                        name="sender"
                        value={transaction.sender}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <label>
                    Receiver:
                    <input
                        type="text"
                        name="receiver"
                        value={transaction.receiver}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <label>
                    Amount:
                    <input
                        type="text"
                        name="amount"
                        value={transaction.amount}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <input type="submit" value="Submit" />
                <Link to={`/accounts/${account_id}/transactions`}>
                    <input type="button" value="Cancel" />
                </Link>
            </form>
        </div>
    )
}