import './index.html';
import './index.css';
import ReactDOM from 'react-dom';
import React from 'react';
import { browserHistory } from 'react-router';
import Routes from '../routes/route';

ReactDOM.render(<Routes history={browserHistory} />, document.getElementById('root'));
