package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {
    companion object {
        const val BURGER_NAME = "burger_name"
        const val IMAGE = "image"
        const val SIZE = "size"
        const val MENU_ID = "menuID"
        const val PRICE = "price"
        const val  DRINK = "drink"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)


        //variables
        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        val size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        var drink = intent.getStringExtra(DRINK)
        var tableNumber = "0"
        var etTableNumber = findViewById<EditText>(R.id.editTextNumeroMesa)

        buttonConfirmar.setOnClickListener {

            //get table number
            tableNumber = etTableNumber.editableText.toString()

            var intent = Intent(this, EndActivity::class.java)

            intent.putExtra(EndActivity.BURGER_NAME,burgerName)
            intent.putExtra(EndActivity.IMAGE, image)
            intent.putExtra(EndActivity.SIZE, size)
            intent.putExtra(EndActivity.PRICE, price)
            intent.putExtra(EndActivity.MENU_ID, menuID)
            intent.putExtra(EndActivity.DRINK, drink)
            intent.putExtra(EndActivity.TABLE_NUMBER, tableNumber)
            startActivity(intent)
        }

        buttonVoltar.setOnClickListener {
            var intent = Intent(this, ConfirmActivity::class.java)

            intent.putExtra(BebidaActivity.BURGER_NAME,burgerName)
            intent.putExtra(BebidaActivity.IMAGE, image)
            intent.putExtra(BebidaActivity.SIZE, size)
            intent.putExtra(BebidaActivity.PRICE, price)
            intent.putExtra(BebidaActivity.MENU_ID, menuID)
            intent.putExtra(BebidaActivity.DRINK, drink)

            startActivity(intent)
        }
    }
}