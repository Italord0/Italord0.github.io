import About from "./components/about";
import Contact from "./components/contact";
import Footer from "./components/footer";
import Header from "./components/header";
import { Navbar } from "./components/navbar";
import Projects from "./components/projects";

function App() {
  return (
    <div>
      <Navbar />
      <Header />
      <About />
      <Projects />
      <Contact />
      {/* <Footer /> */}
    </div>
  );
}

export default App;
