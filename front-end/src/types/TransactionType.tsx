import {Account} from "./AccountType";
import {Category} from "./CategoryType";

export type Transaction = {
    id: number;
    account: Account;
    sender: string;
    receiver: string;
    amount: number;
    flowType: string;
    category: Category;
    footprint: number;
    localDate: string;
    }
