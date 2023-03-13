import './App.css';
import TransactionsPage from "./pages/TransactionsPage";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddTransaction from "./transactions/AddTransaction";
import AccountsPage from "./pages/AccountsPage";


function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route path="/accounts" element={<AccountsPage/>} />
                <Route path="/transactions" element={<TransactionsPage/>} />
                <Route path="/add-transaction" element={<AddTransaction/>} />
            </Routes>
        </Router>
    </div>
  );
}

export default App;
