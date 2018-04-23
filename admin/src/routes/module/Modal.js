import React from "react";
import PropTypes from "prop-types";
import {Form, Select, Input, InputNumber, Radio, Modal, Cascader} from "antd";
import queryString from "query-string";
import {routerRedux} from "dva/router";

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

  let provinceData = [{moduleType:1,moduleTypeName:'10'},{moduleType: 2,moduleTypeName: '10000'}];

  const provinceOptions = provinceData.map(({moduleType,moduleTypeName}) => <Option key={moduleType}>{moduleTypeName}</Option>);

    return (
        <Modal {...modalOpts}>
            <Form layout="horizontal">
                <FormItem label="模块编号" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('moduleCode', {
                        initialValue: item.moduleCode,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>
                <FormItem label="模块名称" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('name', {
                        initialValue: item.moduleName,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>

                <FormItem label="路径" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('url', {
                        initialValue: item.url,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Input />)}
                </FormItem>
                <FormItem label="模块说明" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('moduleDesc', {
                        initialValue: item.moduleDesc,
                        rules: [
                            {
                                required: true,
                                 message:'模块说明是必输项',
                            },
                        ],
                    })(<Input />)}
                </FormItem>

                <FormItem label="模块类型" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('moduleType', {
                        initialValue: item.moduleType,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(
                        <Select
                                placeholder="请选择模块类型"
                                onChange={orgHandleChange.bind(null, 'orgId')}
                        >
                          {provinceOptions}
                        </Select>
                    )}
                </FormItem>

                <FormItem label="状态" hasFeedback {...formItemLayout}>
                    {getFieldDecorator('state', {
                      initialValue: item.state,
                        rules: [
                            {
                                required: true,
                            },
                        ],
                    })(<Select showSearch
                               placeholder="请选择状态"
                               optionFilterProp="children"
                               notFoundContent="无法找到"
                               onChange={roleHandleChange.bind()}
                    >
                        <Option value="1">启用</Option>
                        <Option value="0">停用</Option>
                        <Option value="-1">删除</Option>
                    </Select>)}
                </FormItem>

              <FormItem label="图标" hasFeedback {...formItemLayout}>
                {getFieldDecorator('icon', {
                  initialValue: item.icon,
                  rules: [
                    {
                      required: false,
                    },
                  ],
                })(<Input />)}
              </FormItem>
            </Form>
          <FormItem label="父级菜单" hasFeedback {...formItemLayout}>
            {getFieldDecorator('parentModule', {
              initialValue: item.parentModule,
              rules: [
                {
                  required: false,
                },
              ],
            })(<Input />)}
          </FormItem>
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
