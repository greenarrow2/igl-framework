import React from 'react'
import PropTypes from 'prop-types'
import { Form,Select, Input, InputNumber, Radio, Modal, Cascader } from 'antd'
import city from '../../utils/city'

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
    let fields = getFieldsValue()
    fields[key] = values
    fields = handleFields(fields)
    onFilterChange(fields)
  }


  const roleHandleChange = (key, values) => {
    let fields = getFieldsValue()
    fields[key] = values
    fields = handleFields(fields)
    onFilterChange(fields)
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
          {getFieldDecorator('orgId')(
              <Select defaultValue="lucy"
                                               style={{ width: 200 }}
                                               showSearch={false}
                                               onChange={orgHandleChange.bind(null, 'orgId')}
              >
                <OptGroup label="Manager">
                  <Option value="jack">jack</Option>
                  <Option value="lucy">lucy</Option>
                </OptGroup>
                  <OptGroup label="Engineer">
                  <Option value="yiminghe">yiminghe</Option>
                </OptGroup>
              </Select>
          )}
        </FormItem>

        <FormItem label="角色" hasFeedback {...formItemLayout}>
          {getFieldDecorator('roleId')(<Select showSearch
                                               style={{ width: 200 }}
                                               placeholder="请选择人员"
                                               optionFilterProp="children"
                                               notFoundContent="无法找到"
                                               onChange={roleHandleChange.bind(null, 'roleId')}
          >
            <Option value="jack">杰克</Option>
            <Option value="lucy">露西</Option>
            <Option value="tom">汤姆</Option>
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
