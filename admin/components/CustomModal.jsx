import React,{ Component } from 'react';
import { DatePicker, Button, Modal } from 'antd';
import TodoAction from '../flux/action/TodoAction.js';
import TodoStore from '../flux/store/TodoStore.js';
import connectToStores from 'alt-utils/lib/connectToStores';
import Layout from './layout/Layout';

class PureCustomModal extends Component {

    static getStores(){
        return [TodoStore];
    }

    static getPropsFromStores(){
        let state = TodoStore.getState();
        console.log('Modal View, 取到当前store中的状态值：',state);
        return {
            show: state.show,
        }
    }


    render(){
        let show = this.props.show;
        return (
            <Layout>
                <h1>Ant-Design 与 alt.js 结合使用</h1>
                <hr /><br />
                <OperateArea />
                <ModalView visible={show}/>
            </Layout>
        )
    }
}

class ModalView extends Component {
    handleSwitch = () => {
        TodoAction.switchState();
    };

    render(){
        return (
            <Modal title="Basic Modal" maskClosable={false} visible={this.props.visible}
                   onOk={this.handleSwitch} onCancel={this.handleSwitch}
            >
                <p>some contents...</p>
                <p>some contents...</p>
                <p>some contents...</p>
            </Modal>
        )
    }
}

class OperateArea extends Component {

    doSwitch = () => {
        TodoAction.switchState();
    };

    render(){
        return (
            <div>
                <Button onClick={this.doSwitch}>改变展示状态</Button>
            </div>
        )
    }
}

const CustomModal = connectToStores(PureCustomModal);

export default CustomModal;
