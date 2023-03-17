export type Account = {
    id: number;
    user: any;
    iban: string;
    balance: number;
}

// Question: even if I change the type of iban to number for example, the code still works, then what's the point of putting the type here?