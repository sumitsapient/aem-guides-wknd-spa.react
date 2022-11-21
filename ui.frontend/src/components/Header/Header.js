import React from 'react'
import { Link } from 'react-router-dom';
require('./Header.css');

export const Header = () => {
    return (
        <header className="Header">
            <div className="Header-container">
                <Link to="/content/wknd-spa-react/us/en/home.html">
                    <h1>WKND</h1>
                </Link>
            </div>
        </header>
    )
}
