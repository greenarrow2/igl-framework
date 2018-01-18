import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import NotFound from '../components/common/NotFound';
import App from '../components/App';
import Count from  '../components/Count';
import SimpleModal from  '../components/SimpleModal';
import CustomModal from '../components/CustomModal';
import UserTable from  '../components/UserTable';

const Routes = () =>
    <Router history={hashHistory}>
        <Route path="/" component={App} />
        <Route path="/count" component={Count} />
        <Route path="/simpleModal" component={SimpleModal} />
        <Route path="/modal" component={CustomModal}/>
        <Route path="/user" component={UserTable} />
        <Route path="*" component={NotFound}/>
    </Router>;

Routes.propTypes = {
    history: PropTypes.any,
};

export default Routes;