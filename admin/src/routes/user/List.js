import React from 'react'
import PropTypes from 'prop-types'
import { Table, Modal } from 'antd'
import classnames from 'classnames'
import { DropOption } from 'components'
import { Link } from 'react-router-dom'
import queryString from 'query-string'
import styles from './List.less'

const { confirm } = Modal

const List = ({
  onDeleteItem, onEditItem, isMotion, location, ...tableProps
}) => {
  location.query = queryString.parse(location.search)

  const handleMenuClick = (record, e) => {
    if (e.key === '1') {
      onEditItem(record)
    } else if (e.key === '2') {
      confirm({
        title: '你确定要删除该条记录吗?',
        onOk () {
          onDeleteItem(record.id)
        },
      })
    }
  }

  const columns = [
    {
      title: '登录用户名',
      dataIndex: 'username',
      key: 'username',
    }, {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
    }, {
      title: '手机',
      dataIndex: 'mobile',
      key: 'mobile',
    }, {
      title: '邮箱',
      dataIndex: 'email',
      key: 'email',
    }, {
      title: '所属部门',
      dataIndex: 'orgNames',
      key: 'orgNames',
    }, {
      title: '用户角色',
      dataIndex: 'roleNames',
      key: 'roleNames',
    }, {
      title: '创建时间',
      dataIndex: 'createTime',
      key: 'createTime',
    }, {
      title: '操作',
      key: 'operation',
      render: (text, record) => {
        return <DropOption onMenuClick={e => handleMenuClick(record, e)} menuOptions={[{ key: '1', name: 'Update' }, { key: '2', name: 'Delete' }]} />
      },
    },
  ]


  const CommonBody = (props) => {
    return <tbody {...props} />
  }

  return (
    <Table
      {...tableProps}
      className={classnames(styles.table, { [styles.motion]: isMotion })}
      bordered
      columns={columns}
      simple
      rowKey={record => record.id}
      components={{
        body: { wrapper: CommonBody },
      }}
    />
  )
}

List.propTypes = {
  onDeleteItem: PropTypes.func,
  onEditItem: PropTypes.func,
  location: PropTypes.object,
}

export default List
