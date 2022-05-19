import React from "react";
import Combobox from "../Combobox";

class WarningSystemType extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Doğalgaz", name: "Doğalgaz"}, {id: "Soba", name: "Soba"}]}
            ></Combobox>
        )
    }
}

export default WarningSystemType;