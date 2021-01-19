package ipca.tg.a16609a18812

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


class Menu {

    var id = 0
    var name ="0"
    var image = 0
    var content = "0"
    var detail ="0"
    var price = "0"
    var drink = "0"
    var size = "0"



    constructor()
    constructor(
        id: Int,
        name: String,
        image: Int,
        content: String,
        detail: String,
        price: String,
        drink: String,
        size: String
    ) {
        this.id = id
        this.name = name
        this.image = image
        this.content = content
        this.detail = detail
        this.price = price
        this.drink = drink
        this.size = size
    }

    constructor(id: Int, name: String, image: Int, price: String, drink: String, size: String) {
        this.id = id
        this.name = name
        this.image = image
        this.price = price
        this.drink = drink
        this.size = size
    }

    constructor(id: Int, name: String, price: String, drink: String, size: String) {
        this.id = id
        this.name = name
        this.price = price
        this.drink = drink
        this.size = size
    }


}