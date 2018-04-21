import React from "react";
import PropTypes from "prop-types";
import {Form, Select, Input, InputNumber, Radio, Modal, Cascader} from "antd";

const Option = Select.Option;
const OptGroup = Select.OptGroup;
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


    const orgHandleChange = (key, values) => {
        console.log("orgHandleChange",key,values)
    }


    const roleHandleChange = (key, values) => {
        console.log("roleHandleChange",key,values)
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

                <FormItem label="部门" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('orgId', {
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(
                        <Select  showSearch
                                placeholder="请选择所属部门"
                                onChange={orgHandleChange.bind(null, 'orgId')}
                        >
                            <OptGroup label="部门1">
                                <Option value="11">部门11</Option>
                                <Option value="12">部门12</Option>
                            </OptGroup>
                            <OptGroup label="部门2">
                                <Option value="21">部门21</Option>
                                <Option value="22">部门22</Option>
                            </OptGroup>
                        </Select>
                    )}
                </FormItem>

                <FormItem label="角色" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('roleId', {
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Select showSearch
                               placeholder="请选择人员"
                               optionFilterProp="children"
                               notFoundContent="无法找到"
                               onChange={roleHandleChange.bind(null, 'roleId')}
                    >
                        <Option value="jack">院长</Option>
                        <Option value="lucy">副院长</Option>
                        <Option value="tom">科长</Option>
                    </Select>)}
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
