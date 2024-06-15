import BlogHeader from '../../components/blogHeader';
import BlogList from '../../components/blogList';
import { Navbar } from '../../components/navbar';
import { articles } from '../../data/articles';

function Blog() {
  return (
    <div>
      <Navbar/>
      <BlogHeader/>
      <BlogList/>
    </div>
  );
};

export default Blog;
