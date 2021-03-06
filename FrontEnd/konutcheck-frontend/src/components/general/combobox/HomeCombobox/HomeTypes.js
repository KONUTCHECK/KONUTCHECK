import React from "react";
import Combobox from "../Combobox";

class HomeTypes extends React.Component {

    render() {
        return (
            <Combobox
                fieldName={this.props.fieldName}
                notNull={true}
                name={this.props.name}
                onChange={this.props.onChange}
                items={[{ id: "Daire", name: "Daire" }, { id: "Villa", name: "Villa" }, { id: "Gecekondu", name: "Gecekondu" }]}
            ></Combobox>
        )
    }
}

export default HomeTypes;