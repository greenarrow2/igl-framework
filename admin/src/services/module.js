import { request, config } from 'utils'

const { api } = config
const { moduleList,moduleSave,moduleDel,dicListByDictNo } = api

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

export async function queryDictByDictNo (params) {
    console.log("dicListByDictNo",params)
    return request({
        url: dicListByDictNo,
        method: 'post',
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
