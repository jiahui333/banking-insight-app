type Account = {
    user: any;
    iban: string;
    balance: number;
}
export default Account;

// Question: even if I change the type of iban to number for example, the code still works, then what's the point of putting the type here?