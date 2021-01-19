package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {

    companion object {
        const val BURGER_NAME = "burger_name"
        const val IMAGE = "image"
        const val SIZE = "size"
        const val MENU_ID = "menuID"
        const val PRICE = "price"
        const val DRINK = "drink"
        const val TABLE_NUMBER = "tableNumber"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        //variables
        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        val size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        val drink = intent.getStringExtra(DRINK)
        val tableNumber = intent.getStringExtra(TABLE_NUMBER)
        var ratingValue = findViewById<RatingBar>(R.id.ratingBar)
        var menus : MutableList<Menu> = ArrayList()
     //DB variables
        val rootNode = FirebaseDatabase.getInstance()
        val reference : DatabaseReference

        reference = rootNode.getReference("ClientOrders")

        buttonRecomecar.setOnClickListener {
            //create menus
            menus.add(Menu(menuID,burgerName.toString(), price.toString(), drink.toString(), size.toString() ))

            //create cliente order
            var clientOrder = ClientOrder("0",tableNumber.toString(),ratingValue.rating.toString(),menus)

            //send to firebase
            reference.child(clientOrder.id.toString()).setValue(clientOrder)

            var intent = Intent(this, InicialActivity::class.java)
            startActivity(intent)
        }

        buttonSairFinal.setOnClickListener {
            //create menus
            menus.add(Menu(menuID,burgerName.toString(), price.toString(), drink.toString(), size.toString() ))

            //create cliente order
            var clientOrder = ClientOrder("0",tableNumber.toString(),ratingValue.rating.toString(),menus)

            //send to firebase
            reference.child(clientOrder.id.toString()).setValue(clientOrder)

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}