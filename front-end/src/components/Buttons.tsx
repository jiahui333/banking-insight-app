import { MouseEventHandler } from 'react';

// export function SubmitButton({ onClick }: {onClick: MouseEventHandler<HTMLButtonElement>}) {
//     return (
//         <button type="submit" className="bg-baseColor hover:bg-darkColor160 text-white font-bold py-2 px-4 rounded" onClick={onClick}>
//             Submit
//         </button>
//     );
// }

export function PageButton(buttonText: string) {
    const buttonType = buttonText === "Submit" ? "submit" : "button";
    return (
        <button
            type={buttonType}
            className="bg-baseColor hover:bg-darkColor160 text-white py-1 px-2 rounded">
            {buttonText}
        </button>
    )
}