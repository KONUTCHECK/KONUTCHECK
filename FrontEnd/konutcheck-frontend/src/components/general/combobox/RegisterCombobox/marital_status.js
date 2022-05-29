import React from "react";
import Combobox from "../Combobox";

class Marital_status extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Evli", name: "Evli"}, {id: "Bekar", name: "Bekar"}, ]}
            ></Combobox>
        )
    }
}

export default Marital_status;