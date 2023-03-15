import {Account} from "./AccountType";
import {Category} from "./CategoryType";

export type Transaction = {
        id: number;
        account: Account;
        receiver: string;
        amount: number;
        flowType: string;
        category: Category;
        localDate: Date;
    }
