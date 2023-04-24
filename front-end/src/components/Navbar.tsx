import treeLogo from "../assets/treeLogo.png";

export function Navbar() {
    return (
        <div className="flex items-center justify-center flex-row pt-10 pb-10 fixed w-full">
            <img src={treeLogo} className="object-cover h-10 mr-2"/>
            <h1 className="text-logo">
                Greeny Insight
            </h1>
        </div>
    )
}