import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom";

export default function TransactionsPage() {
    type Transaction = {
        account: any;
        receiver: string;
        amount: number;
        flowType: string;
        category: any;
        localDate: Date;
    }

    const [transactions, setTransactions] = useState<Transaction[]>([]);

    useEffect(() => {
        axios.get('http://localhost:8080/transactions')
            .then(res =>{
                setTransactions(res.data)
                console.log(res.data)
            })
            .catch(err => console.log(err))
    },[])

    const listTransactions = transactions.map((transaction) => {
        console.log(transaction);
        console.log(typeof transaction.localDate)
        // if the type of transaction.localDate is string, why do I have to add toLocaleString to make it display?
        return (
            <tr>
                <td>{transaction.account.iban}</td>
                <td>{transaction.receiver}</td>
                <td>{transaction.amount}</td>
                <td>{transaction.flowType}</td>
                <td>{transaction.category.name}</td>
                <td>{transaction.localDate.toLocaleString()}</td>
            </tr>
        )
    })

    return (
        <div>
            <h1>Transactions</h1>
            <table>
                <tr>
                    <th>Account</th>
                    <th>Receiver</th>
                    <th>Amount</th>
                    <th>Flow type</th>
                    <th>Category</th>
                    <th>Date</th>
                </tr>
                {listTransactions}
            </table>
            <Link to="/add-transaction">
                <button>Add transaction</button>
            </Link>
        </div>
    )
}