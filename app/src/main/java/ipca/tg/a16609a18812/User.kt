package ipca.tg.a16609a18812

class User {

    //variables
    var id = 0
    var firstName = "0"
    var lastName = "0"
    var email = "0"
    var password = "0"

    constructor(firstName: String, lastName: String, email: String, password: String) {

        this.id = User.id++
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.password = password
    }

    companion object{
        var id = 0
    }
}