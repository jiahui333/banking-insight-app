
import {useEffect, useState} from "react";
import axios from "axios";

export function FootprintPerCatTable() {

    const [categoryFootprintPairs, setCategoryFootprintPairs] = useState<{[categoryName: string]: number}>({});

    async function loadFootprint() {
        const response = await axios.get(`http://localhost:8080/footprint`);
        setCategoryFootprintPairs(response.data);
    }

    const totalAmount: number =
        Object.values(categoryFootprintPairs).reduce((previousValue, currentValue) => previousValue + currentValue, 0)


    useEffect(() => {
        void loadFootprint();
    }, []);

    return (


        <table>
            {Object.entries(categoryFootprintPairs).map(([categoryName, amount]) =>
                <tr>
                    <th>{categoryName}</th>
                    <td>{amount}</td>
                </tr>
            )}
            <tr>
                <th>
                    Total
                </th>
                <td>
                    {totalAmount}
                </td>
            </tr>
        </table>
    )
}

