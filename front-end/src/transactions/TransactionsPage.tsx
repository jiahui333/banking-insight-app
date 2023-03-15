import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import type Transaction from "../types/TransactionType";

export default function TransactionsPage() {

    const [transactions, setTransactions] = useState<Transaction[]>([]);

    useEffect(() => {
        loadTransactions()},[]);

    const loadTransactions = () => {
        axios.get(`http://localhost:8080/transactions`)
            .then(res =>{
                setTransactions(res.data)
                console.log(res.data)
            })
            .catch(err => console.log(err))
    }

    const listTransactions = transactions.map((transaction) => {
        console.log(transaction);
        console.log(typeof transaction.localDate)
        // if the type of transaction.localDate is string, why do I have to add toLocaleString to make it display?
        console.log(transaction.id)
        return (
            <tr>
                <td>{transaction.id}</td>
                <td>{transaction.account.iban}</td>
                <td>{transaction.receiver}</td>
                <td>{transaction.amount}</td>
                <td>{transaction.flowType}</td>
                <td>{transaction.category.name}</td>
                <td>{transaction.localDate.toLocaleString()}</td>
                <td>
                    <button onClick={()=>deleteTransaction(transaction.id)}>Delete</button>
                </td>
            </tr>
        )
    })

    const deleteTransaction = (id: number) => {
        axios.delete(`http://localhost:8080/transactions/${id}`)
            .then(loadTransactions)
            .catch(err => console.log(err))
    }

    return (
        <div>
            <h1>Transactions</h1>
            <table>
                <tbody>
                    <tr>
                        <th>#</th>
                        <th>Account</th>
                        <th>Receiver</th>
                        <th>Amount</th>
                        <th>Flow type</th>
                        <th>Category</th>
                        <th>Date</th>
                    </tr>
                    {listTransactions}
                </tbody>
            </table>
            <Link to="/add-transaction">
                <button>Add transaction</button>
            </Link>
        </div>
    )
}