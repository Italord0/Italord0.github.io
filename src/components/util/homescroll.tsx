import React, { ReactNode } from 'react';
import { useNavigate } from 'react-router-dom';

interface ScrollWrapperProps {
  to: string;
  className?: string;
  offset?: number;
  duration?: number;
  children: ReactNode;
}

const ScrollWrapper: React.FC<ScrollWrapperProps> = ({ to, className = "", offset = 0, duration = 500, children }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    if (window.location.pathname !== '/') {
      navigate('/', { replace: true });
      setTimeout(() => {
        scrollToElement();
      }, 100);
    } else {
      scrollToElement();
    }
  };

  const scrollToElement = () => {
    const element = document.getElementById(to);
    if (element) {
      const offsetPosition = element.offsetTop - offset;
      window.scrollTo({
        top: offsetPosition,
        behavior: 'smooth'
      });
    }
  };

  return (
    <div className={className} onClick={handleClick} style={{ cursor: 'pointer' }}>
      {children}
    </div>
  );
};

export default ScrollWrapper;
