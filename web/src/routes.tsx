import { createBrowserRouter } from "react-router-dom";
import { Header } from "./components/layouts/Header";

export const routes = createBrowserRouter( [
    {
        path: "/",
        index: true,
        element: <Header />
    }
] );