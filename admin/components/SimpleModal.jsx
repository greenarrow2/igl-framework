import React,{Component} from 'react';
import {Button,Modal} from 'antd';
import Layout from './layout/Layout';

class SimpleModal extends Component{
    constructor(props){
        super(props);
        this.state = {
            show : false
        }
    }

    handleSwitch = () =>{
        let show = !this.state.show;
        this.setState({show: show});
    };

    render(){
        let visible = this.state.show;
        return (
            <Layout>
                <div>
                    <Button onClick={this.handleSwitch}>Switch</Button>
                    <Modal maskClosable={false} visible={visible}
                           onOk={this.handleSwitch} onCancel={this.handleSwitch}>
                        Hello World !
                    </Modal>
                </div>
            </Layout>
        )
    }
}

export  default SimpleModal;
