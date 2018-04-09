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
        title: 'Are you sure delete this record?',
        onOk () {
          onDeleteItem(record.id)
        },
      })
    }
  }

  const columns = [
    {
      title: '字典编码',
      dataIndex: 'dictCode',
      key: 'dictCode',
    }, {
      title: '字典名称',
      dataIndex: 'dictName',
      key: 'name',
    }, {
      title: '字典编号',
      dataIndex: 'dictNo',
      key: 'dictNo',
    }, {
      title: '字典描述',
      dataIndex: 'dictDesc',
      key: 'dictDesc',
    }, {
      title: '备注',
      dataIndex: 'mark',
      key: 'mark',
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
