import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useLocation, useNavigate, useParams} from "react-router-dom";
import {CategoryDropDown} from "../../components/CategoryDropDown";
import {Category} from "../../types/CategoryType";
import {Transaction} from "../../types/TransactionType";

export default function AddTransactionPage() {

    const navigate = useNavigate();



    const { id } = useParams() as { id: string };
    const account_id: number = +id

    console.log("useLocation().state: " + useLocation().state.iban);
    const { iban } = useLocation().state as {iban: string};

    const [transaction, setTransaction] = useState({
        flowType: "outflow",
        sender:iban,
        receiver: "",
        amount:"",
        category: {} as Category
        })

    const [flowType, setFlowType] = useState("outflow");


    //destructure
    // const {flowType, sender, receiver, amount} = transaction;

    //spread operator
    function onInputChange (e: React.ChangeEvent<HTMLInputElement>) {
        console.log(transaction.sender);
        setTransaction({...transaction,[e.target.name]:e.target.value})
    }
    async function onSubmitForm (e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        await axios.post(`http://localhost:8080/accounts/${account_id}/transactions`, transaction)
        navigate(`/accounts/${account_id}/transactions`,{ state: { iban: iban } })
    }

// functions below can be factored into a check component
    function checkOutflow() {
        transaction.flowType = "outflow";
        setFlowType("outflow");
        transaction.sender = iban;
        transaction.receiver = "";
    }

    function checkInflow() {
        transaction.flowType = "inflow";
        setFlowType("inflow");
        transaction.receiver = iban;
        transaction.sender = "";
    }

    function handleDataFromCategoryDropDownComponent(category: Category) {
        console.log(`This is the category received from the component- ${category.id}`);
        transaction.category = category;
        console.log(transaction.category);
    }


    return (
        <div>
            <h1>New Transaction</h1>
            <form onSubmit={(e => onSubmitForm(e))}>
                <label>
                    Outflow:
                    <input
                        type="checkbox"
                        checked={flowType === "outflow"}
                        onChange={checkOutflow}
                    />
                </label>
                <label>
                    Inflow:
                    <input
                        type="checkbox"
                        checked={flowType === "inflow"}
                        onChange={checkInflow}
                    />
                </label>
                <br />
                <label>
                    Sender:
                    <input
                        type="text"
                        name="sender"
                        onChange={(e => onInputChange(e))}
                        value={transaction.sender}
                        disabled = {transaction.flowType === "outflow"}
                    />
                </label>
                <br />
                <label>
                    Receiver:
                    <input
                        type="text"
                        name="receiver"
                        onChange={(e => onInputChange(e))}
                        value={transaction.receiver}
                        disabled = {transaction.flowType === "inflow"}
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
                <CategoryDropDown sendCategoryToTransaction = {handleDataFromCategoryDropDownComponent}/>
                <br />
                <input type="submit" value="Submit" />
                <Link to={`/accounts/${account_id}/transactions`}
                      state={{iban: iban}}>
                    <input type="button" value="Cancel" />
                </Link>
            </form>
        </div>
    )
}