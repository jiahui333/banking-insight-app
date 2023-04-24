import React, {useEffect, useState} from "react";
import axios from "axios";
import type { Account } from "../../types/AccountType";
import {Link} from "react-router-dom";

export default function AccountsPage() {

    const [accounts, setAccounts] = useState<Account[]>([]);

    useEffect(() => {
        const account_jwt = localStorage.getItem("jwt");
        console.log("account page jwt: " + account_jwt + new Date().getTime())
        axios.get('http://localhost:8080/accounts', { headers: { Authorization: `Bearer ${account_jwt}`}})
            .then(res =>{
                setAccounts(res.data)
                console.log(res.data)
    })
            .catch(err => console.log(err))
    },[])

    const listAccounts = accounts.map((account) => {
        console.log(account);
        console.log(typeof account)
        console.log(typeof account.iban)
        return (
            <tr>
                <td>{account.user.id}</td>
                <td>{account.iban}</td>
                <td>{account.balance}</td>
                <td>
                    <Link to={`/accounts/${account.id}/transactions`}
                    state={{
                        iban: account.iban
                    }}>
                        <button>Transactions</button>
                    </Link>
                </td>
            </tr>
        )
    })

    return (
        <div className="pt-20">
            <h1>Accounts</h1>
            <table>
                <tr>
                    <th>User</th>
                    <th>IBAN</th>
                    <th>Balance</th>
                </tr>
                {listAccounts}
            </table>
        </div>
    )
}