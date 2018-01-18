import React,{ Component } from 'react';
import { Button, Modal } from 'antd';
import TodoAction from '../flux/TodoAction.js';
import TodoStore from '../flux/TodoStore.js';
import connectToStores from 'alt-utils/lib/connectToStores';
import Layout from './layout/Layout';

class PureCount extends Component {
    static getStores(){
        return [TodoStore];
    }

    static getPropsFromStores(){
        let state = TodoStore.getState();
        console.log('Count View, 取到当前store中的状态值：',state);
        return {
            result: state.result,
        }
    }

    render(){
        let result = this.props.result;
        return (
            <Layout>
                <h1>Alt.js 处理流程示例</h1>
                <hr /><br />
                <TodoOperateArea  />
                <ResultView result={result} />
            </Layout>
        )
    }
}

const Count = connectToStores(PureCount);

class TodoOperateArea extends Component {

    doCal = (flag) => {
        TodoAction.doAction(flag);
    };

    render(){
        return (
            <div>
                <Button onClick={() => this.doCal(1)}>加1操作</Button> &nbsp;
                <Button onClick={() => this.doCal(-1)}>减1操作</Button> &nbsp;
            </div>
        )
    }
}

class ResultView extends Component{
    render() {
        return (
            <div>
                <br/>
                结果: {this.props.result}
            </div>
        )
    }
}

export default Count;