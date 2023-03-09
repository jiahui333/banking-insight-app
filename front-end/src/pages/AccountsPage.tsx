import React, {useEffect, useState} from "react";
import axios from "axios";

export default function AccountsPage() {
    type Account = {
        user: any;
        iban: string;
        balance: number;
    }

    // Question: even if I change the type of iban to number for example, the code still works, then what's the point of putting the type here?

    const [accounts, setAccounts] = useState<Account[]>([]);

    useEffect(() => {
        axios.get('http://localhost:8080/accounts')
            .then(res =>{
                setAccounts(res.data)
                console.log(res.data)
    })
            .catch(err => console.log(err))
    },[])

    const listAccounts = accounts.map((account) => {
        console.log(account);
        console.log(typeof account)
        return (
            <tr>
                <td>{account.user.id}</td>
                <td>{account.iban}</td>
                <td>{account.balance}</td>
            </tr>
        )
    })

    return (
        <div>
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