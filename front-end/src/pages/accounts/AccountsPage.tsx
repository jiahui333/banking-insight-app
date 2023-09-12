import React, {useEffect, useState} from "react";
import axios from "axios";
import type { Account } from "../../types/AccountType";
import {Link, useLocation} from "react-router-dom";
import {PageButton} from "../../components/Buttons";

export default function AccountsPage() {
    // const { username } = useLocation().state as {username: string};

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
                <td>{account.iban}</td>
                <td>{account.balance}</td>
                <td className="text-2xl hover:text-baseColor">
                    <Link to={`/accounts/${account.id}/transactions`}
                    state={{
                        iban: account.iban
                    }}>
                        &#10145;
                    </Link>
                </td>
            </tr>
        )
    })

    return (
        <div className="flex items-center justify-center flex-col bg-white/90 shadow-xl rounded-lg w-3/5 m-auto p-12">
            <h1 className="title">Accounts</h1>
            <table className="w-1/2 text-left">
                <tr>
                    <th>IBAN</th>
                    <th>Balance</th>
                    <th>Transactions</th>
                </tr>
                {listAccounts}
            </table>
            <div className="mt-12">
                <Link to={`/accounts/add`}>
                    {PageButton("Add Account")}
                </Link>
            </div>
        </div>
    )
}