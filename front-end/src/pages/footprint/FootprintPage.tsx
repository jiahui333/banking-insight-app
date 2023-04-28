import axios from "axios";
import {useState} from "react";
import {FootprintPerCatTable} from "../../components/FootprintPerCatTable";

export default function FootprintPage() {

    return (
        <div className="w-3/5 flex items-center justify-center flex-col bg-white/90 shadow-xl rounded-lg m-auto px-52 py-20">
            <h1 className="title"> Footprint Overview</h1>
            <FootprintPerCatTable/>
        </div>

    )
}
