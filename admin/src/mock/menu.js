const { config } = require('./common')

const { apiPrefix } = config
let database = [
  {
    id: '1',
    icon: 'dashboard',
    name: '系统管理',
    route: '/dashboard',
  }
]

module.exports = {

  [`GET ${apiPrefix}/menus`] (req, res) {
    console.log("======",res)
    res.status(200).json(database)
  },
}
