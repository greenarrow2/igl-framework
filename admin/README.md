
    1. 首页组件是ant-design的常规用法。
    2. 计数示例是alt.js经典应用场景。
    3. 对话框示例是alt.js + ant-design 组合使用，通过alt.js 控制状态数据流，反应在ant-design中，实现modal的切换。

运行步骤：
1. 安装nodejs,官网地址：https://nodejs.org . 安装完毕后，系统则会有node和npm两个命令。
第一步最好先安装一个cnpm, 避免使用npm带来的网速过慢的问题。安装命令:

    sudo  npm install cnpm -g

2. 安装依赖包

    cnpm install -d

3. 开发模式运行

    npm run start

访问 http://127.0.0.1:8000

4. 编译代码
    npm install 
    npm run build

具体编译后位置可以在package.json的script节点中修改build属性来指定。

