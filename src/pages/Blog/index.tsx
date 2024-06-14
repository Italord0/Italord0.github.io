import { Navbar } from '../../components/navbar';
import { articles } from '../../data/articles';

function Blog() {
  return (
    <div>
      <Navbar/>
      <h1>Articles List</h1>
      <ul>
        {articles.map((article, index) => (
          <li key={index}>
            <h2>{article.title}</h2>
            <p>{article.description}</p>
            <p>File Path: {article.filePath}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Blog;
