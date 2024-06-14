import ReactDOM from 'react-dom/client'
import {BrowserRouter} from 'react-router-dom'
import MainRoutes from './routes'
import './styles/index.css'
import { StrictMode } from 'react'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <StrictMode>
        <BrowserRouter>
            <MainRoutes/>
        </BrowserRouter>
    </StrictMode>
)
