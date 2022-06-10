import React from "react";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
toast.configure();
var timeout = null;
class ToastMessage extends React.Component {

    notif(message) {
        clearTimeout(timeout);
        timeout = setTimeout(() => {
            toast[this.props.type](message, {
                autoClose: 2500,
                position: toast.POSITION.TOP_RIGHT,
            });
        }, 100);
    };
    render() {
        return (<div>{this.notif(this.props.message)}</div>)
    }
}

export default ToastMessage;