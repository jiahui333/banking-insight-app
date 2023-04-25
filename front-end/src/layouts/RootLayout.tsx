import treeLogo from "../assets/treeLogo.png";
import {NavLink, Outlet, useLocation} from "react-router-dom";

export function RootLayout() {
    const location = useLocation();
    const hideHeader = location.pathname === "/";

    return(
        <div className="px-20 py-14">
            {!hideHeader &&
                <header>
                <nav className="w-full flex justify-between block -z-10">
                    <div className="flex">
                        <img src={treeLogo} className="object-cover h-10 mr-2"/>
                        <h1 className="text-logo">
                            Greeny Insight
                        </h1>
                    </div>
                    <div className="flex items-center">
                        <NavLink to="/accounts"
                                 className={({ isActive }) =>
                                     isActive ? "text-h1Color underline" : "text-logoColor"
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