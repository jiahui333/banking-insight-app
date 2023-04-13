import React, {useEffect, useState} from "react";
import {Category} from "../types/CategoryType";
import axios from "axios";
import {TransactionProps} from "../types/TransactionPropsType";

export function CategoryDropDown(props: TransactionProps): JSX.Element {
    const [categories, setCategories] = useState<Category[]>([]);
    const [selectedCategoryId, setSelectedCategoryId] = useState<number>();

    async function fetchCategories () {
        try {
            const response = await axios.get<Category[]>("http://localhost:8080/categories");
            setCategories(response.data);
            console.log(categories);
        } catch (error) {
            console.error(error);
        }
    }

    function handleSelectedCategory(e: React.ChangeEvent<HTMLSelectElement>) {
        console.log("Selected category: " + e.target.value)
        props.sendCategoryToTransaction(JSON.parse(e.target.value))
    }

    // Use useEffect with empty dependencies to ensure that the function is only called once, when the component is mounted, and the state is updated only once.
    useEffect(() => {
        void fetchCategories();
        console.log(categories);
    }, []);

    return (
        <div>
            <label> Category: </label>
            <select
                onChange={(e => handleSelectedCategory(e))}
            >
                {categories.map((category) => (
                    <option key={category.id} value={JSON.stringify(category)}>
                        {category.name}
                    </option>
                ))}
            </select>
        </div>
    );
}