import './App.css';

import {
    Route,
    createBrowserRouter,
    createRoutesFromElements,
    RouterProvider
} from "react-router-dom";
import AccountsPage from "./pages/accounts/AccountsPage";
import TransactionsPage from "./pages/transactions/TransactionsPage";
import AddTransactionPage from "./pages/transactions/AddTransactionPage";
import LogInPage from "./pages/users/LogInPage";
import FootprintPage from "./pages/footprint/FootprintPage";
import {RootLayout} from "./layouts/RootLayout";


const router = createBrowserRouter(
    createRoutesFromElements(
        <Route element={<RootLayout />}>
            <Route path="/" element={<LogInPage />} />
            <Route path="/accounts" element={<AccountsPage/>} />
            <Route path="/accounts/:id/transactions" element={<TransactionsPage/>} />
            <Route path="/accounts/:id/transactions/add" element={<AddTransactionPage/>} />
            <Route path="/footprint" element={<FootprintPage/>} />
        </Route>
    )
)
function App() {
  return (
      <RouterProvider router={router}/>
  );
}

export default App;
