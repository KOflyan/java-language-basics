import { NavLink } from "react-router-dom";
import './Toolbar.css'

export const Toolbar = () => {
    return (
        <div className="toolbar">
            <NavLink
                className="route-switch"
                to="/"
            >
                Home
            </NavLink>
            <NavLink
                className="route-switch"
                to="/profile"
            >
                Profile
            </NavLink>
        </div>
    )
}
