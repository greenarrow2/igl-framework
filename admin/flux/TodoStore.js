import alt from './alt.js';
import TodoAction from './TodoAction.js';

class TodoStore {
    constructor(){
        this.bindListeners({
            handleDoAction: TodoAction.doAction,
            handleSwitchState: TodoAction.switchState,
        })
        this.state = {
            result: 0,
            show: false,
        }
    }

    handleDoAction = (flag) => {
        let result = this.state.result;
        this.setState({result: flag + result});
    }

    handleSwitchState = () => {
        let show = !this.state.show;
        this.setState({show: show});
    }
}

export default alt.createStore(TodoStore,'TodoStore');
