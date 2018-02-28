import { color } from '../utils/theme'

const Mock = require('mockjs')
const config = require('../utils/config')

const { apiPrefix } = config

const Dashboard = Mock.mock({
  numbers: [
    {
      icon: 'pay-circle-o',
      color: color.green,
      title: '部门管理',

    }, {
      icon: 'shopping-cart',
      color: color.blue,
      title: '职位管理',

    }, {
      icon: 'team',
      color: color.purple,
      title: '用户管理',

    },
    {
      icon: 'message',
      color: color.red,
      title: '操作日志',
    },
  ],
})

module.exports = {
  [`GET ${apiPrefix}/dashboard`] (req, res) {
    res.json(Dashboard)
  },
}
