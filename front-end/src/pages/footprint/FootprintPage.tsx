import axios from "axios";
import {useState} from "react";


export default function FootprintPage() {

    const [groceryFootprint, setGroceryFootprint] = useState<number>();

    function loadFootprint(category_name: string) {
        axios.get(`http://localhost:8080/${category_name}/footprint`).then(r => console.log(r))
    }

    loadFootprint("Grocery")

    return (
        <div>
            <table>
                <tr>
                    <th>Grocery</th>
                    <th>Energy</th>
                    <th>Restaurant</th>
                </tr>
                <tr>
                    <td>{groceryFootprint}</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Centro comercial Moctezuma</td>
                    <td>Francisco Chang</td>
                    <td>Mexico</td>
                </tr>
            </table>
        </div>
    )
    //sum the total footprint
}
