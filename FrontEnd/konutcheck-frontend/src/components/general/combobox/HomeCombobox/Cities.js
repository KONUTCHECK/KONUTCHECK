import React from "react";
import Combobox from "../Combobox";

class Countries extends React.Component{

    render(){
        return(
            <Combobox
                fieldName = {this.props.fieldName}
                notNull= {true}
                name={this.props.name}
                onChange={this.props.onChange}
                items = {[{id: "Adana", name: "Adana"},
                {id: "Adıyaman", name: "Adıyaman"},
                {id: "Afyonkarahisar", name: "Afyonkarahisar"},
                {id: "Ağrı", name: "Ağrı"},
                {id: "Aksaray", name: "Aksaray"},
                {id: "Amasya", name: "Amasya"},
                {id: "Ankara", name: "Ankara"},
                {id: "Antalya", name: "Antalya"},
                {id: "Ardahan", name: "Ardahan"},
                {id: "Artvin", name: "Artvin"},
                {id: "Aydın", name: "Aydın"},
                {id: "Balıkesir", name: "Balıkesir"},
                {id: "Bartın", name: "Bartın"},
                {id: "Batman", name: "Batman"},
                {id: "Bayburt", name: "Bayburt"},
                {id: "Bilecik", name: "Bilecik"},
                {id: "Bingöl", name: "Bingöl"},
                {id: "Bitlis", name: "Bitlis"},
                {id: "Bolu", name: "Bolu"},
                {id: "Burdur", name: "Burdur"},
                {id: "Bursa", name: "Bursa"},
                {id: "Çanakkale", name: "Çanakkale"},
                {id: "Çankırı", name: "Çankırı"},
                {id: "Çorum", name: "Çorum"},
                {id: "Denizli", name: "Denizli"},
                {id: "Diyarbakır", name: "Diyarbakır"},
                {id: "Düzce", name: "Düzce"},
                {id: "Edirne", name: "Edirne"},
                {id: "Elazığ", name: "Elazığ"},
                {id: "Erzincan", name: "Erzincan"},
                {id: "Erzurum", name: "Erzurum"},
                {id: "Eskişehir", name: "Eskişehir"},
                {id: "Gaziantep", name: "Gaziantep"},
                {id: "Giresun", name: "Giresun"},
                {id: "Gümüşhane", name: "Gümüşhane"},
                {id: "Hakkâri", name: "Hakkâri"},
                {id: "Hatay", name: "Hatay"},
                {id: "Iğdır", name: "Iğdır"},
                {id: "Isparta", name: "Isparta"},
                {id: "İstanbul", name: "İstanbul"},
                {id: "İzmir", name: "İzmir"}, 
                {id: "Kahramanmaraş", name: "Kahramanmaraş"},
                {id: "Karabük", name: "Karabük"},
                {id: "Karaman", name: "Karaman"},
                {id: "Kars", name: "Kars"},
                {id: "Kastamonu", name: "Kastamonu"},
                {id: "Kayseri", name: "Kayseri"},
                {id: "Kilis", name: "Kilis"},
                {id: "Kırıkkale", name: "Kırıkkale"},
                {id: "Kırklareli", name: "Kırklareli"},
                {id: "Kırşehir", name: "Kırşehir"},
                {id: "Kocaeli", name: "Kocaeli"},
                {id: "Konya", name: "Konya"},
                {id: "Kütahya", name: "Kütahya"},
                {id: "Malatya", name: "Malatya"},
                {id: "Manisa", name: "Manisa"},
                {id: "Mardin", name: "Mardin"},
                {id: "Mersin", name: "Mersin"},
                {id: "Muğla", name: "Muğla"},
                {id: "Muş", name: "Muş"},
                {id: "Nevşehir", name: "Nevşehir"},
                {id: "Niğde", name: "Niğde"},
                {id: "Ordu", name: "Ordu"},
                {id: "Osmaniye", name: "Osmaniye"},
                {id: "Rize", name: "Rize"},
                {id: "Sakarya", name: "Sakarya"},
                {id: "Samsun", name: "Samsun"},
                {id: "Şanlıurfa", name: "Şanlıurfa"},
                {id: "Siirt", name: "Siirt"},
                {id: "Sinop", name: "Sinop"},
                {id: "Sivas", name: "Sivas"},
                {id: "Şırnak", name: "Şırnak"},
                {id: "Tekirdağ", name: "Tekirdağ"},
                {id: "Tokat", name: "Tokat"},
                {id: "Trabzon", name: "Trabzon"},
                {id: "Tunceli", name: "Tunceli"},
                {id: "Uşak", name: "Uşak"},
                {id: "Van", name: "Van"},
                {id: "Yalova", name: "Yalova"},
                {id: "Yozgat", name: "Yozgat"},
                {id: "Zonguldak", name: "Zonguldak"},
        
            ]}

                
            ></Combobox>
        )
    }
}

export default Countries;