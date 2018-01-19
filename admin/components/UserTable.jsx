import React,{ Component } from 'react';
import { Button, Table} from 'antd';
import UserAction from '../flux/action/UserAction';
import UserStore from '../flux/store/UserStore.js';
import connectToStores from 'alt-utils/lib/connectToStores';
import Layout from './layout/Layout';

const columns = [{
    title: '姓名',
    dataIndex: 'name',
    key: 'name',
}, {
    title: '年龄',
    dataIndex: 'age',
    key: 'age',
}, {
    title: '住址',
    dataIndex: 'address',
    key: 'address',
}];

class UserTable extends  Component {

    static getStores(){
        return [UserStore];
    }

    static getPropsFromStores(){
        let state = UserStore.getState();
        console.log('state:',state);
        return {
            userList: state.userList
        }
    }

    getMoreUser = ()=>{
        UserAction.getMoreUser();
    }

    render(){
        return (
            <Layout>
                <div>
                    <Button type="primary" onClick={()=> this.getMoreUser()}>获取更多数据</Button>
                </div><br/>
                <Table dataSource={this.props.userList} columns={columns} />
            </Layout>
        )
    }
}

export default connectToStores(UserTable);