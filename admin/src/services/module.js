import { request, config } from 'utils'

const { api } = config
const { moduleList,moduleSave,moduleDel } = api

export async function query (params) {
    return request({
        url: moduleList,
        method: 'post',
        data: params,
    })
}

export async function create (params) {
    return request({
        url: moduleSave,
        method: 'post',
        data: params,
    })
}

export async function remove (params) {
    return request({
        url: moduleDel,
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
