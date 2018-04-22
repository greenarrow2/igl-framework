import React from 'react'
import PropTypes from 'prop-types'
import { routerRedux } from 'dva/router'
import { connect } from 'dva'
import { Row, Col, Button, Popconfirm } from 'antd'
import { Page } from 'components'
import queryString from 'query-string'
import List from './List'
import Filter from './Filter'
import Modal from './Modal'


const Dic = ({
    location, dispatch, dashboard, loading,
}) => {
    location.query = queryString.parse(location.search)
    const { query, pathname } = location

    const {
        list, pagination, currentItem, modalVisible, modalType, selectedRowKeys,
    } = dashboard
    const handleRefresh = (newQuery) => {
        dispatch(routerRedux.push({
            pathname,
            search: queryString.stringify({
                ...query,
                ...newQuery,
            }),
        }))
    }

    const modalProps = {
        item: modalType === 'create' ? {} : currentItem,
        visible: modalVisible,
        maskClosable: false,
        confirmLoading: loading.effects['dashboard/update'],
        title: `${modalType === 'create' ? '创建数据字典' : '更新数据字典'}`,
        wrapClassName: 'vertical-center-modal',
        onOk (data) {
            dispatch({
                type: `dashboard/${modalType}`,
                payload: data,
            }).then(() => {
                handleRefresh()
            })
        },
        onCancel () {
            dispatch({
                type: 'dashboard/hideModal',
            })
        },
    }

    const listProps = {
        dataSource: list,
        loading: loading.effects['dashboard/query'],
        pagination,
        location,
        onChange (page) {
            handleRefresh({
                page: page.current,
                pageSize: page.pageSize,
            })
        },
        onDeleteItem (id) {
            dispatch({
                type: 'dashboard/delete',
                payload: id,
            }).then(() => {
                    handleRefresh({
                        page: (list.length === 1 && pagination.current > 1) ? pagination.current - 1 : pagination.current,
                    })
                })
        },
        onEditItem (item) {
            dispatch({
                type: 'dashboard/showModal',
                payload: {
                    modalType: 'update',
                    currentItem: item,
                },
            })
        },
        rowSelection: {
            selectedRowKeys,
            onChange: (keys) => {
                dispatch({
                    type: 'dashboard/updateState',
                    payload: {
                        selectedRowKeys: keys,
                    },
                })
            },
        },
    }

    const filterProps = {
        filter: {
            ...query,
        },
        onFilterChange (value) {
            handleRefresh({
                ...value,
                page: 1,
                pageSize: 20,
            })
        },
        onAdd () {
            dispatch({
                type: 'dashboard/showModal',
                payload: {
                    modalType: 'create',
                },
            })
        },
    }

    const handleDeleteItems = () => {
        dispatch({
            type: 'dashboard/multiDelete',
            payload: {
                ids: selectedRowKeys,
            },
        })
            .then(() => {
                handleRefresh({
                    page: (list.length === selectedRowKeys.length && pagination.current > 1) ? pagination.current - 1 : pagination.current,
                })
            })
    }

    return (
        <Page inner>
            <Filter {...filterProps} />
            {
                selectedRowKeys.length > 0 &&
                <Row style={{ marginBottom: 24, textAlign: 'right', fontSize: 13 }}>
                    <Col>
                        {`Selected ${selectedRowKeys.length} items `}
                        <Popconfirm title="Are you sure delete these items?" placement="left" onConfirm={handleDeleteItems}>
                            <Button type="primary" style={{ marginLeft: 8 }}>Remove</Button>
                        </Popconfirm>
                    </Col>
                </Row>
            }
            <List {...listProps} />
            {modalVisible && <Modal {...modalProps} />}
        </Page>
    )
}

Dic.propTypes = {
    dashboard: PropTypes.object,
    location: PropTypes.object,
    dispatch: PropTypes.func,
    loading: PropTypes.object,
}

export default connect(({ dashboard, loading }) => ({ dashboard, loading }))(Dic)
