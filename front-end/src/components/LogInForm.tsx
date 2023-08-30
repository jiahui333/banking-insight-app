import {FormProps} from "../types/FormPropsType";
import React, {useState} from "react";

export function Form(props: FormProps) {
    const [formData, setFormData] =useState<any>({label: "", name: "", type: ""});

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormData((prevData: any) => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        // onSubmit(formData);
    };
    return (
        <div>
            <h1>{props.title}</h1>
            <form onSubmit={handleSubmit}>
                {props.fields.map((field) => (
                    <div key={field.name}>
                        <label>{field.label}</label>
                        <input
                            type={field.type}
                            name={field.name}
                            value={formData[field.name]}
                            onChange={handleInputChange}
                        />
                    </div>
                ))}
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}