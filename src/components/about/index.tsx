import "./index.css";
import about from "../../images/about.png";
const About = () => {
  return (
    <div id="about" className="about-container">
      <div className="about-section">
        <div className="about-image-container">
          <img src={about} className="about-image" />
        </div>
        <div className="about-text">
          <h2>About Me</h2>
          <p>
            As a Mobile Developer, I possess an arsenal of skills in Android,
            iOS, Compose Multiplatform and some React Native.
            <br></br>
            <br></br>I excel in designing and maintaining usable apps that offer
            a smooth user experience.
            <br></br>
            <br></br>
            My expertise lies in crafting dynamic, engaging interfaces through
            writing clean and optimized code and utilizing cutting-edge
            development tools and techniques. <br></br>I am also a team player
            who thrives in collaborating with a cross-functional teams to
            produce outstanding mobile apps.
          </p>
        </div>
      </div>
    </div>
  );
};

export default About;
