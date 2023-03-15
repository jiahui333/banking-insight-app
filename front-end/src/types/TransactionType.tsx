import {Account} from "./AccountType";

export type Transaction = {
        id: number;
        account: Account;
        receiver: string;
        amount: number;
        flowType: string;
        category: any;
        localDate: Date;
    }
