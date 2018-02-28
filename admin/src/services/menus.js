import { request, config } from 'utils'

const { api } = config
const { menus } = api

export async function query (params) {
  console.log("menus menus",menus)
  console.log("params params",params)
  return request({
    url: menus,
    method: 'get',
    data: params,
  })
}
