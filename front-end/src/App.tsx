import './App.css';

import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AccountsPage from "./pages/accounts/AccountsPage";
import RegisterPage from "./pages/users/RegisterPage";
import TransactionsPage from "./pages/transactions/TransactionsPage";
import AddTransactionPage from "./pages/transactions/AddTransactionPage";
import LogInPage from "./pages/users/LogInPage";

function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route path="/user/register" element={<RegisterPage/>} />
                <Route path="/user/login" element={<LogInPage/>} />
                <Route path="/accounts" element={<AccountsPage/>} />
                <Route path="/accounts/:id/transactions" element={<TransactionsPage/>} />
                <Route path="/accounts/:id/transactions/add" element={<AddTransactionPage/>} />
            </Routes>
        </Router>
    </div>
  );
}

export default App;
