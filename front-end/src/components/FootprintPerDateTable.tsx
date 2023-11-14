
import {useEffect, useState} from "react";
import axios from "axios";

export function FootprintPerDateTable() {

    const [DateFootprintPairs, setDateFootprintPairs] = useState<{[date: string]: number}>({});

    async function loadFootprintPerYearMonth() {
        const response = await axios.get(`https://greeny-insight-backend.fly.dev/footprint/per-year-month`, { headers: { Authorization: `Bearer ${localStorage.getItem("jwt")}`}});
        setDateFootprintPairs(response.data);
        console.log(response.data)
    }

    useEffect(() => {
        void loadFootprintPerYearMonth();
    }, []);

    return (
        <table className="text-center">
            <thead>
            <tr>
                <th>Month</th>
                <th>Amount(gCO2)</th>
            </tr>
            </thead>
            <tbody>
            {Object.entries(DateFootprintPairs).map(([date, amount]) => {
                if (amount !== 0) {
                    return (
                        <tr>
                            <td>{date.slice(5)}</td>
                            <td>{amount}</td>
                        </tr>
                    );
                } else {
                    return null;
                }
            })}
            </tbody>
        </table>
    );
}

