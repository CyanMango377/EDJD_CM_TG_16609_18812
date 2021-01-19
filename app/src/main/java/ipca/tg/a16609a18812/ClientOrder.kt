package ipca.tg.a16609a18812

import kotlinx.android.parcel.Parcelize


class ClientOrder {

    //variables
    var id = "0"
    var clientID = "0"
    var tableNumber = "0"
    var rating = "0"
    lateinit var menus : MutableList<Menu>

    constructor(
        clientID: String,
        tableNumber: String,
        rating: String,
        menus: MutableList<Menu>
    ){
        this.id = ClientOrder.id++.toString()
        this.clientID = clientID
        this.tableNumber = tableNumber
        this.rating = rating
        this.menus = menus
    }

    constructor()


    companion object{
        var id = 0
    }
}