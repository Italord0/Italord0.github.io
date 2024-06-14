import { Link , useLocation } from "react-router-dom"
import ScrollWrapper from "../util/homescroll"
import "./index.css";

export const Navbar = () => {

    const location = useLocation();

    return (
        <div>
            <nav>
                <ul className='nav-links'>
                    <ScrollWrapper to="home" duration={500} className={location.pathname === '/' ? 'active-link' : ''} ><li>Home</li></ScrollWrapper>
                    <Link to="/blog" className={location.pathname === '/blog' ? 'active-link' : ''}><li>Blog</li></Link>
                    <ScrollWrapper to="about" offset={100} duration={500}><li>About</li></ScrollWrapper>
                    <ScrollWrapper to="projects" duration={500}><li>Projects</li></ScrollWrapper>
                    <ScrollWrapper to="contact" duration={500}><li>Contact</li></ScrollWrapper>
                </ul>
            </nav>
        </div >

    )
}
