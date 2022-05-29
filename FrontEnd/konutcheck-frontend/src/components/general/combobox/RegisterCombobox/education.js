import React from "react";
import Combobox from "../Combobox";

class Education extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "İlkokul", name: "İlkokul"}, {id: "Ortaokul", name: "Ortaokul"},{id: "Lise", name: "Lise"},{id: "Üniversite", name: "Üniversite"} ]}
            ></Combobox>
        )
    }
}

export default Education;