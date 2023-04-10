import {useEffect, useState} from "react";
import {Category} from "../types/CategoryType";
import axios from "axios";

export function CategoryDropDown(): JSX.Element {
    const [categories, setCategories] = useState<Category[]>([]);

    async function fetchCategories () {
        try {
            const response = await axios.get<Category[]>("http://localhost:8080/categories");
            setCategories(response.data);
        } catch (error) {
            console.error(error);
        }
    }

    // Use useEffect with empty dependencies to ensure that the function is only called once, when the component is mounted, and the state is updated only once.
    useEffect(() => {
        void fetchCategories();
    }, []);

    return (
        <select>
            {categories.map((category) => (
                <option key={category.id} value={category.id}>
                    {category.name}
                </option>
            ))}
        </select>
    );
}