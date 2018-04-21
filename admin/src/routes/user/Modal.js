import React from "react";
import PropTypes from "prop-types";
import {Form, Select, Input, InputNumber, Radio, Modal, Cascader} from "antd";
import enUS from 'antd/lib/locale-provider/en_US';

const RadioButton = Radio.Button;
const RadioGroup = Radio.Group;
const FormItem = Form.Item

const formItemLayout = {
    labelCol: {
        span: 6,
    },
    wrapperCol: {
        span: 14,
    },
}

const modal = ({
    item = {},
    onOk,
    form: {
        getFieldDecorator,
        validateFields,
        getFieldsValue,
    },
    ...modalProps
}) => {
    const handleOk = () => {
        validateFields((errors) => {
            if (errors) {
                return
            }
            const data = {
                ...getFieldsValue(),
                key: item.key,
            }
            onOk(data)
        })
    }

    const modalOpts = {
        ...modalProps,
        onOk: handleOk,
    }


    const sexHandleChange = (key, values) => {
        console.log("orgHandleChange",key,values)
    }




    return (
        <Modal {...modalOpts}>
            <Form layout="horizontal">
                <FormItem label="登录用户名" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('userName', {
                        initialValue: item.dictCode,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>
                <FormItem label="姓名" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('name', {
                        initialValue: item.dictName,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>

                <FormItem label="性别" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('gender', {
                        initialValue: item.gender,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })( <RadioGroup onChange={sexHandleChange}>
                        <RadioButton value="1">男</RadioButton>
                        <RadioButton value="2">女</RadioButton>
                    </RadioGroup>)}
                </FormItem>

                <FormItem label="手机" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('mobile', {
                        initialValue: item.status,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>
                <FormItem label="邮箱" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('email', {
                        initialValue: item.status,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>
            </Form>
        </Modal>
    )
}

modal.propTypes = {
    form: PropTypes.object.isRequired,
    type: PropTypes.string,
    item: PropTypes.object,
    onOk: PropTypes.func,
}

export default Form.create()(modal)
