import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useLocation, useParams} from "react-router-dom";
import type {Transaction} from "../types/TransactionType";

export default function TransactionsPage() {

    const [transactions, setTransactions] = useState<Transaction[]>([]);
    console.log(useParams());
    console.log("useLocation().state: "+useLocation().state.iban);
    const { iban }= useLocation().state as {iban: string};
    const { id } = useParams() as { id: string };
    const account_id: number = +id

    useEffect(() => {
        loadTransactions(account_id)},[account_id]);
    //React Hook useEffect has a missing dependency: 'account_id'. Either include it or remove the dependency array

    const loadTransactions = (account_id: number) => {
        axios.get(`http://localhost:8080/accounts/${account_id}/transactions`)
            .then(res =>{
                setTransactions(res.data)
                console.log(res.data)
            })
            .catch(err => console.log(err))
    }

    const listTransactions = transactions.map((transaction) => {
        console.log(transaction);
        console.log(typeof transaction.localDate)
        return (
            <tr>
                <td>{transaction.id}</td>
                <td>{transaction.account.iban}</td>
                <td>{transaction.sender}</td>
                <td>{transaction.receiver}</td>
                <td>{transaction.amount}</td>
                <td>{transaction.flowType}</td>
                <td>{transaction.category.name}</td>
                <td>{transaction.localDate}</td>
                <td>
                    <button onClick={()=>deleteTransaction(transaction.id)}>Delete</button>
                </td>
            </tr>
        )
    })

    const deleteTransaction = (transaction_id: number) => {
        axios.delete(`http://localhost:8080/accounts/${account_id}/transactions/${transaction_id}`)
            .then(r => loadTransactions(account_id))
    }

    return (
        <div>
            <h1>Transactions</h1>
            <table>
                <tbody>
                    <tr>
                        <th>#</th>
                        <th>Account</th>
                        <th>Sender</th>
                        <th>Receiver</th>
                        <th>Amount</th>
                        <th>Flow type</th>
                        <th>Category</th>
                        <th>Date</th>
                    </tr>
                    {listTransactions}
                </tbody>
            </table>
            <Link to={`/accounts/${account_id}/transactions/add`}
            state={{
                iban: iban
            }}>

                <button>Add transaction</button>
            </Link>
            <br/>
            <Link to={"/accounts"}>
                <button>Return to accounts</button>
            </Link>
        </div>
    )
}