import React from "react";
import Combobox from "../Combobox";

class Usertype extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Evsahibi", name: "Evsahibi"}, {id: "Kiracı", name: "Kiracı"}, ]}
            ></Combobox>
        )
    }
}

export default Usertype;