import alt from '../alt.js';
import UserAction from '../action/UserAction';

class UserStore {
    constructor(){
        this.bindListeners({
            handleGetMoreUserData: UserAction.getMoreUser,
        })
        this.state = {
            userList: [ {
                key: '1',
                name: '胡彦斌',
                age: 32,
                address: '西湖区湖底公园1号'
            }]
        }
    }

    handleGetMoreUserData = ()=>{
        let currentData = this.state.userList;
        let index = currentData.length + 1 ;
        currentData.push({
            key: index + '' ,
            name: '新的数据' + index ,
            age: 20,
            address: '西湖区湖底公园' + index
        });
        this.setState({ userList: currentData});
    }

}

export default alt.createStore(UserStore,'UserStore');