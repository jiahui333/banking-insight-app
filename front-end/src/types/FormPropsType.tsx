import {Field} from "./FieldType";

export type FormProps = {
    fields: Field[];
    onSubmit: (data: any) => void;
    title: string;
}
