import React,{ Component } from 'react';
import { DatePicker, Button } from 'antd';
import Layout from './layout/Layout';

class App extends Component {
    render(){
        return (
            <Layout>
                <h1>AntDesign Demos</h1><hr /><br />
                <DateArea />
            </Layout>
        )
    }
}

class DateArea extends Component {
    render(){
        return (
            <DatePicker />
        )
    }
}

export default App;
