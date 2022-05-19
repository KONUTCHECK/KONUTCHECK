import React from "react";
import Combobox from "../Combobox";

class Countries extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                items = {[{id: "Türkiye", name: "Türkiye"}]}
            ></Combobox>
        )
    }
}

export default Countries;