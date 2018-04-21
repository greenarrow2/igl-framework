import { request, config } from 'utils'

const { api } = config
const { userList,userSave,userDelete,userMultiDelete } = api

export async function query (params) {
    return request({
        url: userList,
        method: 'get',
        data: params,
    })
}

export async function create (params) {
    return request({
        url: userSave,
        method: 'post',
        data: params,
    })
}

export async function remove (params) {
    return request({
        url: userDelete,
        method: 'delete',
        data: params,
    })
}

export async function multiRemove (params) {
    console.log("multiRemove ddd",params)
    return request({
        url: userMultiDelete,
        method: 'delete',
        data: params,
    })
}

export async function update (params) {
    return request({
        url: userSave,
        method: 'post',
        data: params,
    })
}
