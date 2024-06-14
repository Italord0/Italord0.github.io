import "./index.css";
import { AllProjects } from "../../data/projects";

const Projects = () => {
  return (
      <div className="project-container" id="projects">
        <div className="project-section">
          <h2>Projects</h2>
          <p>Each project is a unique piece of development 🧩</p>
          <div className="project-flex-container">
            {AllProjects.map((project) => {
              return (
                <div className="projects" key={project.id}>
                  <div className="projects-card">
                    <img src={project.iconUrl} />
                    <h3>
                      {project.name}{" "}
                      {project.platform === "Both" ? (
                        <div className="section-platform">
                          <i className="fa-brands fa-android"></i>
                          <i className="fa-brands fa-apple"></i>
                        </div>
                      ) : (
                        <div className="section-platform">
                          <i
                            className={
                              "fa-brands" +
                              (project.platform === "Android"
                                ? " fa-android"
                                : project.platform === "iOS"
                                ? " fa-apple"
                                : "")
                            }
                          ></i>
                        </div>
                      )}
                    </h3>
                    <p>{project.description}</p>

                    <div className="links">
                      <a href={project.gitHubUrl}>
                        <span>
                          Code<i className="fa-brands fa-github"></i>
                        </span>
                      </a>
                      {project.prodUrl && (
                        <a href={project.prodUrl}>
                          <span>
                            Get on Store
                            <i className="fa-brands fa-google-play"></i>
                          </span>
                        </a>
                      )}
                    </div>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      </div>
  );
};

export default Projects;
