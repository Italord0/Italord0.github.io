import { Article } from "../../data/model/Article"
import "./index.css"

function ArticleCard(article : Article){
    return (
        <a className="article-card" href={article.link}>
            <img src={article.image} alt={article.title} />
            <div className="article-details">
            <h2>{article.title}</h2>
            <p>{article.description}</p>
            </div>
        </a>
    )
}

export default ArticleCard