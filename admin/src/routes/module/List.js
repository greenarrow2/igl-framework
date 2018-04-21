import React from 'react'
import PropTypes from 'prop-types'
import { Table, Modal,Icon } from 'antd'
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
      title: '模块编码',
      dataIndex: 'moduleCode',
      key: 'moduleCode',
    },
    {
      title: '模块名称',
      dataIndex: 'moduleName',
      key: 'moduleName',
    }, {
      title: '路径',
      dataIndex: 'url',
      key: 'url',
    }, {
      title: '模块说明',
      dataIndex: 'moduleDesc',
      key: 'moduleDesc',
    }, {
      title: '模块类型',
      dataIndex: 'moduleTypeName',
      key: 'moduleTypeName',
    }, {
      title: '状态',
      dataIndex: 'stateName',
      key: 'stateName',
    }, {
      title: '图标',
      dataIndex: 'icon',
      key: 'icon',
      render: (text, record) => {

        const imgStyle = {
          height:50,
          weith:50
        }

        if(record.icon.indexOf("/") > -1){
          return (
            <img src={record.icon} style={imgStyle} />
            )
        }
        const iconStyle = {
          fontSize : 30
        }
        return <Icon style={iconStyle} type={record.icon} />
      },
    }, {
      title: '父模块',
      dataIndex: 'parentModuleName',
      key: 'parentModuleName',
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
