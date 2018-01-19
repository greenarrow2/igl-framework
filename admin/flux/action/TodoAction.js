import alt from '../alt.js';

class TodoAction {
    doAction(flag){
        //Todo 校验数据合法性
        return flag;
    }

    switchState(){
        return null;
    }
}

export default alt.createActions(TodoAction);
