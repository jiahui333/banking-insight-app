import './App.css';
import TransactionsPage from "./transactions/TransactionsPage";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddTransactionPage from "./transactions/AddTransactionPage";
import AccountsPage from "./pages/accounts/AccountsPage";
import RegisterPage from "./pages/users/RegisterPage";

function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route path="/user" element={<RegisterPage/>} />
                <Route path="/accounts" element={<AccountsPage/>} />
                <Route path="/accounts/:id/transactions" element={<TransactionsPage/>} />
                <Route path="/accounts/:id/transactions/add" element={<AddTransactionPage/>} />
            </Routes>
        </Router>
    </div>
  );
}

export default App;
