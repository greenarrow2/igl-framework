const APIV1 = '/api/v1'
const APIV2 = '/api/v2'
const DOMIN = 'http://127.0.0.1:8001'
// const DOMIN = 'http://101.200.42.185:8001'

module.exports = {
  name: 'Team Admin',
  prefix: 'team',
  footerText: 'Admin  © 2017 TEAM',
  logo: '/logo.svg',
  iconFontCSS: '/iconfont.css',
  iconFontJS: '/iconfont.js',
  CORS: [],
  openPages: ['/login'],
  apiPrefix: '/api/v1',
  APIV1,
  APIV2,
  api: {
    userLogin: `${APIV1}/user/login`,
    userLogout: `${APIV1}/user/logout`,
    user: `${APIV1}/user/:id`,
    dicList: `${DOMIN}/api/sysdict/pagelist`,
    dicSave: `${DOMIN}/api/sysdict/save`,
    dicDelete: `${DOMIN}/api/sysdict/delete`,
    dicMultiDelete: `${DOMIN}/api/sysdict/multiDelete`,
    // menus: `${APIV1}/menus`,
    menus: `${DOMIN}/api/sysrolemodule/queryrolemodulebyroleid`,
  },
}
