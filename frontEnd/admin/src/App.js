import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Register from "./Components/Pages/Register";

function App() {
	return (
		<BrowserRouter>
			<Routes>
				{/* <Route path="/" element={<Home/>}></Route>
				<Route path="/login" element={<Login/>}></Route>
				<Route path="/signup" element={SignUp}></Route>
        <Route path="/tables" element={Tables}></Route>
         */}

				<Route path="/register" element={<Register />}></Route>
			</Routes>
		</BrowserRouter>
	);
}

export default App;
