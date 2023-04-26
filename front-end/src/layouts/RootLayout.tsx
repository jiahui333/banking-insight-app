import lightGreenTreeLogo from "../assets/lightGreenTreeLogo.png";
import {NavLink, Outlet, useLocation} from "react-router-dom";

export function RootLayout() {
    const location = useLocation();
    const hideHeader = location.pathname === "/";

    return(
        <div className="px-20 py-14">
            {!hideHeader &&
                <header>
                <nav className="w-full flex justify-between block -z-10 pb-14">
                    <div className="flex">
                        <img src={lightGreenTreeLogo} className="object-cover h-10 mr-2"/>
                        <h1 className="text-logo">
                            Greeny Insight
                        </h1>
                    </div>
                    <div className="flex items-end">
                        <NavLink to="/accounts"
                                 className={({ isActive }) =>
                                     `text-logoColor ${isActive ? "underline" : ""}`
                        }>
                            Accounts
                        </NavLink>
                        <NavLink to="/footprint"  className={({ isActive }) =>
                            `ml-12 ${isActive ? 'text-h1Color underline' : 'text-logoColor'}`
                        }>
                            Footprint
                        </NavLink>
                    </div>
                </nav>
            </header>
            }

            <main>
                <Outlet />
            </main>
        </div>
    )

}