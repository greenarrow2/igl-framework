/* global window */
import modelExtend from 'dva-model-extend'
import queryString from 'query-string'
import { config } from 'utils'
import { create, remove, update } from 'services/user'
import * as userService from 'services/user'
import { pageModel } from './common'

const { query } = userService
const { prefix } = config

export default modelExtend(pageModel, {
    namespace: 'user',

    state: {
        currentItem: {},
        modalVisible: false,
        modalType: 'create',
        selectedRowKeys: [],
    },

    subscriptions: {
        setup ({ dispatch, history }) {
            history.listen((location) => {
                if (location.pathname === '/user') {
                    const payload = queryString.parse(location.search) || { page: 1, pageSize: 10 }
                    dispatch({
                        type: 'query',
                        payload,
                    })
                }
            })
        },
    },

    effects: {

        * query ({ payload = {} }, { call, put }) {
            const data = yield call(query, payload)
            if (data) {
                yield put({
                    type: 'querySuccess',
                    payload: {
                        list: data.items,
                        pagination: {
                            current: Number(data.currentPage) || 1,
                            pageSize: Number(data.pageSize) || 20,
                            total: data.totalNum,
                        },
                    },
                })
            }
        },

        * delete ({ payload }, { call, put, select }) {
            const data = yield call(remove, { id: payload })
            const { selectedRowKeys } = yield select(_ => _.user)
            if (data.success) {
                yield put({ type: 'updateState', payload: { selectedRowKeys: selectedRowKeys.filter(_ => _ !== payload) } })
            } else {
                throw data
            }
        },

        * multiDelete ({ payload }, { call, put }) {
            const data = yield call(dicService.multiRemove, payload)
            if (data.success) {
                yield put({ type: 'updateState', payload: { selectedRowKeys: [] } })
            } else {
                throw data
            }
        },

        * create ({ payload }, { call, put }) {
            const data = yield call(create, payload)
            if (data.success) {
                yield put({ type: 'hideModal' })
            } else {
                throw data
            }
        },

        * update ({ payload }, { select, call, put }) {
            const id = yield select(({ user }) => user.currentItem.id)
            const newUser = { ...payload, id }
            const data = yield call(update, newUser)
            if (data.success) {
                yield put({ type: 'hideModal' })
            } else {
                throw data
            }
        },

    },

    reducers: {

        showModal (state, { payload }) {
            return { ...state, ...payload, modalVisible: true }
        },

        hideModal (state) {
            return { ...state, modalVisible: false }
        },

    },
})
