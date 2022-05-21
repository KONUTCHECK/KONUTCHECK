import React from "react";
import Combobox from "../Combobox";

class Gender extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Kadın", name: "Kadın"}, {id: "Erkek", name: "Erkek"},{id: "Belirtmek İstemiyorum", name: "Belirtmek İstemiyorum"} ]}
            ></Combobox>
        )
    }
}

export default Gender;