import React from "react";
import PropTypes from "prop-types";
import {routerRedux} from "dva/router";
import {connect} from "dva";
import {Row, Col, Button, Popconfirm} from "antd";
import {Page} from "components";
import queryString from "query-string";
import List from "./List";
import Filter from "./Filter";
import Modal from "./Modal";


const Dic = ({
    location, dispatch, user, loading,
}) => {
    location.query = queryString.parse(location.search)
    const {query, pathname} = location
    const {
        list, pagination, currentItem, modalVisible, modalType, selectedRowKeys,
    } = user
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
        item: modalType === 'save' ? {} : currentItem,
        visible: modalVisible,
        maskClosable: false,
        confirmLoading: loading.effects['user/update'],
        title: `${modalType === 'create' ? '添加新用户' : '更新部门信息'}`,
        wrapClassName: 'vertical-center-modal',
        onOk (data) {
            dispatch({
                type: `user/${modalType}`,
                payload: data,
            }).then(() => {
                handleRefresh()
            })
        },
        onCancel () {
            dispatch({
                type: 'user/hideModal',
            })
        },
    }

    const listProps = {
        dataSource: list,
        loading: loading.effects['user/query'],
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
                type: 'user/delete',
                payload: id,
            })
                .then(() => {
                    handleRefresh({
                        page: (list.length === 1 && pagination.current > 1) ? pagination.current - 1 : pagination.current,
                    })
                })
        },
        onEditItem (item) {
            dispatch({
                type: 'user/showModal',
                payload: {
                    modalType: 'update',
                    currentItem: item,
                },
            }).then(() => {
                handleRefresh({
                    page: (list.length === 1 && pagination.current > 1) ? pagination.current - 1 : pagination.current,
                })
            })
        },
        rowSelection: {
            selectedRowKeys,
            onChange: (keys) => {
                dispatch({
                    type: 'user/updateState',
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
                type: 'user/showModal',
                payload: {
                    modalType: 'create',
                },
            })
        },
    }

    const handleDeleteItems = () => {
        dispatch({
            type: 'user/multiDelete',
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

            <Row style={{marginBottom: 24, textAlign: 'right', fontSize: 13}}>
                <Col>
                    {
                        selectedRowKeys.length > 0 &&
                        `已选择 ${selectedRowKeys.length} 条数据 `
                    }

                    <Button type="primary" style={{marginLeft: 8}}>批量授权角色</Button>
                    <Popconfirm title="你确定要删除这些数据?" placement="left" onConfirm={handleDeleteItems}>
                        <Button type="primary" icon="minus-circle-o" style={{marginLeft: 8}}>批量删除</Button>
                    </Popconfirm>

                </Col>
            </Row>

            <List {...listProps} />
            {modalVisible && <Modal {...modalProps} />}
        </Page>
    )
}

Dic.propTypes = {
    user: PropTypes.object,
    location: PropTypes.object,
    dispatch: PropTypes.func,
    loading: PropTypes.object,
}

export default connect(({user, loading}) => ({user, loading}))(Dic)
