import "./index.css";
import swift from "../../images/swift.svg";
import kotlin from "../../images/koltin.png";
import java from "../../images/java.svg";
import react from "../../images/react.png";
import photo from "../../images/me.png";
const Header = () => {
  return (
      <div className="main-container" id="home">
        <main>
          <section className="section-container">
            <div>
              <h1>Italo Melo</h1>
              <div className="text-container">
                <p>Hi! I'm a Mobile Developer based in Recife, Brazil.</p>
                <div>
                    <a href="https://www.linkedin.com/in/italocmelo/">
                      <i className="fa-brands fa-linkedin"></i>
                    </a>
                    <a href="https://github.com/Italord0">
                      <i className="fa-brands fa-github"></i>
                    </a>
                    <a href="https://x.com/olemolati">
                      <i className="fa-brands fa-x-twitter"></i>
                    </a>
                    <a href="https://medium.com/@italord.melo">
                      <i className="fa-brands fa-medium"></i>
                    </a>
                </div>
              </div>
            </div>
            <img className="main-photo" src={photo} />
          </section>
          <div className="images-container">
            <div className="span-container">
              <span>Tech Stack</span>
            </div>
            <div className="image-container">
              <div className="image-styles">
                <img className="images" src={kotlin} />
              </div>
              <div className="image-styles">
                <img className="images" src={swift} />
              </div>
              <div className="image-styles">
                <img className="images" src={java} />
              </div>
              <div className="image-styles">
                <img className="images" src={react} />
              </div>
            </div>
          </div>
        </main>
      </div>
  );
};

export default Header;
