import React, { MouseEventHandler } from 'react';


export function SubmitButton({ onClick }: {onClick: MouseEventHandler<HTMLButtonElement>}) {
    return (
        <button type="submit" className="bg-logoColor hover:bg-h1Color text-white font-bold py-2 px-4 rounded" onClick={onClick}>
            Submit
        </button>
    );
}

