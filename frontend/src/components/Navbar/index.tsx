import { ReactComponent as GithubIcon } from "../../assets/images/github-icon.svg";
import "./styles.css";


export function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                </div>
                <a href="https://github.com/leoramos25">
                    <div className="dsmovie-contact-container">
                        <GithubIcon />
                        <p className="dsmovie-contact-link">/leoramos25</p>
                    </div>
                </a>
            </nav>
        </header>
    )
}