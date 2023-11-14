
import {useEffect, useState} from "react";
import axios from "axios";

export function FootprintPerCatTable() {

    const [categoryFootprintPairs, setCategoryFootprintPairs] = useState<{[categoryName: string]: number}>({});

    async function loadFootprintPerCategory() {
        const response = await axios.get(`https://greeny-insight-backend.fly.dev/footprint/per-category`, { headers: { Authorization: `Bearer ${localStorage.getItem("jwt")}`}});
        setCategoryFootprintPairs(response.data);
    }

    const totalAmount: number =
        Object.values(categoryFootprintPairs).reduce((previousValue, currentValue) => previousValue + currentValue, 0)


    useEffect(() => {
        void loadFootprintPerCategory();
    }, []);

    return (
        <table className="text-center">
            <thead>
            <tr>
                <th>Category</th>
                <th>Amount(gCO2)</th>
            </tr>
            </thead>
            <tbody>
            {Object.entries(categoryFootprintPairs).map(([categoryName, amount]) => {
                if (amount !== 0) {
                    return (
                        <tr key={categoryName}>
                            <td>{categoryName}</td>
                            <td>{amount}</td>
                        </tr>
                    );
                } else {
                    return null;
                }
            })}
            <tr>
                <td colSpan={2}>
                    <hr/>
                </td>
            </tr>
            <tr>
                <td>Total</td>
                <td>{totalAmount}</td>
            </tr>
            </tbody>
        </table>
    );
}

