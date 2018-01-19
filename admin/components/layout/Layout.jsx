import React,{ Component } from 'react';
import { Link } from 'react-router';
import { Menu } from 'antd';

class Layout extends Component {
    render() {
        return (
            <div>
                <div style={{ margin: "0 6rem"}}>
                    <Menu mode="horizontal">
                        <Menu.Item key="index">
                            <Link to="/">
                                首页
                            </Link>
                        </Menu.Item>
                        <Menu.Item key="count">
                            <Link to="/count">
                                计数示例
                            </Link>
                        </Menu.Item>
                        <Menu.Item key="simpleModal">
                            <Link to="/simpleModal">
                                简单对话框示例
                            </Link>
                        </Menu.Item>
                        <Menu.Item key="modal">
                            <Link to="/modal">
                                对话框示例(flux)
                            </Link>
                        </Menu.Item>
                        <Menu.Item key="user">
                            <Link to="/user">
                                项目实例
                            </Link>
                        </Menu.Item>
                    </Menu>
                </div>
                <div style={{ margin: 100 }}>
                    {this.props.children}
                </div>
            </div>
        )
    }
}

export default Layout;
