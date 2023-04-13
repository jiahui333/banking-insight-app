import {Category} from "./CategoryType";

export type TransactionProps = {
    sendCategoryToTransaction: (category: Category) => void;
}