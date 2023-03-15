import Account from "./AccountType";

type Transaction = {
    id: number;
    account: Account;
    receiver: string;
    amount: number;
    flowType: string;
    category: any;
    localDate: Date;
}
export default Transaction;
