import {Field} from "./FieldType";
import React from "react";

export type FormProps = {
    title: string;
    errView: React.ReactNode;
    username: string;
    password: string;
    passComment: string;
    setUsername: (e: string) => void;
    setPassword: (e: string) => void;
    sendRequest: (e: React.MouseEvent<HTMLInputElement>) => void;
    alternativeMessage: string;
    alternativePath: string;
    alternativePathName: string;
}
