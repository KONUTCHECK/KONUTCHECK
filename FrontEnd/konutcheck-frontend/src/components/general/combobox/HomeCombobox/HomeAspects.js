import React from "react";
import Combobox from "../Combobox";

class HomeAspects extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Kuzey", name: "Kuzey"}, {id: "Güney", name: "Güney"}]}
            ></Combobox>
        )
    }
}

export default HomeAspects;