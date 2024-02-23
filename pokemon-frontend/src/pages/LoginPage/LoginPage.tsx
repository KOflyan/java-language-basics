import './LoginPage.css'
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export const LoginPage = () => {
    const [username, setUsername] = useState<string>()
    const [password, setPassword] = useState<string>()
    const [error, setError] = useState<string>()

    const navigate = useNavigate()

    const login = () => {
        axios.post(
            'http://localhost:8080/api/trainer/login',
            {
                username,
                password,
            }
        ).then((response) => {
            localStorage.setItem('token', response.data.token)
            localStorage.setItem('role', response.data.role)

            navigate('/profile')

            setError(undefined)
        }).catch((error) => setError(error.response.data.message))
    }

    return (
        <div className="login-page">
            <div className="input-container">
                <h1>Login</h1>
            </div>
            <div className="input-container">
                <input
                    className="login-input"
                    placeholder='username'
                    onChange={(event) => setUsername(event.target.value)}
                />
            </div>
            <div className="input-container">
                <input
                    className="login-input"
                    placeholder='password'
                    type='password'
                    onChange={(event) => setPassword(event.target.value)}
                />
            </div>
            <div className="input-container">
                <button
                    className="login-button"
                    onClick={() => login()}
                >Login</button>
            </div>
            {
                !!error &&
                    <div className="error-container">
                        {error}
                    </div>
            }
        </div>
    )
}
