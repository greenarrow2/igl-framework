import { request, config } from 'utils'

const { api } = config
const { organizationDel,organizationList,organizationSave } = api

export async function query (params) {
    return request({
        url: organizationList,
        method: 'post',
        data: params,
    })
}

export async function create (params) {
    return request({
        url: organizationSave,
        method: 'post',
        data: params,
    })
}

export async function remove (params) {
    return request({
        url: organizationDel,
        method: 'delete',
        data: params,
    })
}

export async function update (params) {
    return request({
        url: organizationSave,
        method: 'post',
        data: params,
    })
}
