import { articles } from "../../data/articles"
import ArticleCard from "../articleCard"
import "./index.css"

function BlogList(){
    return (
        <div className="blog-list">
            {articles.map((article, index) => (
                <ArticleCard key={index} {...article} />
      ))}
        </div>  
    )
}

export default BlogList