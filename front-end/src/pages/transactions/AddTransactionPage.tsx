import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useLocation, useNavigate, useParams} from "react-router-dom";
import {CategoryDropDown} from "../../components/CategoryDropDown";
import {Category} from "../../types/CategoryType";
import {Transaction} from "../../types/TransactionType";
import {TransactionPageButton} from "../../components/Buttons";

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
        console.log(transaction);
        await axios.post(`http://localhost:8080/accounts/${account_id}/transactions`, transaction, { headers: { Authorization: `Bearer ${localStorage.getItem("jwt")}`}})
        console.log("add trans jwt: " + localStorage.getItem("jwt"))
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
        <div className="flex items-center justify-center flex-col bg-white/90 shadow-xl rounded-lg w-3/5 m-auto p-12 text-bodyColor180 ">
            <h1 className="title">New Transaction</h1>
            <form onSubmit={(e => onSubmitForm(e))}>
                <div className="flex justify-between mb-4">
                    <label>
                        Outflow:
                        <input
                            className="ml-1"
                            type="checkbox"
                            checked={flowType === "outflow"}
                            onChange={checkOutflow}
                        />
                    </label>
                    <label>
                        Inflow:
                        <input
                            className="ml-1"
                            type="checkbox"
                            checked={flowType === "inflow"}
                            onChange={checkInflow}
                        />
                    </label>
                </div>
                <label>
                    Sender:
                    <input
                        className="input mb-3"
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
                        className="input mb-3"
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
                        className="input mb-3"
                        type="text"
                        name="amount"
                        value={transaction.amount}
                        onChange={(e => onInputChange(e))}
                    />
                </label>
                <br />
                <CategoryDropDown sendCategoryToTransaction = {handleDataFromCategoryDropDownComponent} flowType={transaction.flowType}/>
                <br />
                <div className="flex justify-around mt-6">
                    {TransactionPageButton("Submit")}
                    <Link to={`/accounts/${account_id}/transactions`}
                          state={{iban: iban}}>
                        {TransactionPageButton("Cancel")}
                    </Link>
                </div>
            </form>
        </div>
    )

}