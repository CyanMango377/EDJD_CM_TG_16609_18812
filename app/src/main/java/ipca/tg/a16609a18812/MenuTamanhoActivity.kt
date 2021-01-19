package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bebida.*
import kotlinx.android.synthetic.main.activity_menu_tamanho.*

class MenuTamanhoActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_menu_tamanho)

        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        var size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        val drink = intent.getStringExtra(DRINK)

        val textViewSecondMenuName = findViewById<TextView>(R.id.textViewSecondMenuName)
        val imageViewSecondMenu = findViewById<ImageView>(R.id.imageViewSecondMenu)

        textViewSecondMenuName.text = burgerName
        imageViewSecondMenu.setImageResource(image)

        buttonCancelarMenu.setOnClickListener {
            val intent = Intent(this, PedidoActivity::class.java)
            startActivity(intent)
        }

        buttonSmallMenu.setOnClickListener {
            val intent = Intent(this, BebidaActivity::class.java)

            //Get size
            size = "Small"

            intent.putExtra(BebidaActivity.BURGER_NAME,burgerName)
            intent.putExtra(BebidaActivity.IMAGE, image)
            intent.putExtra(BebidaActivity.SIZE, size)
            intent.putExtra(BebidaActivity.PRICE, price)
            intent.putExtra(BebidaActivity.MENU_ID, menuID)
            intent.putExtra(BebidaActivity.DRINK, drink)
            startActivity(intent)
        }

        buttonMediumMenu.setOnClickListener {
            val intent = Intent(this, BebidaActivity::class.java)

            //Get size
            size = "Medium"

            intent.putExtra(BebidaActivity.BURGER_NAME,burgerName)
            intent.putExtra(BebidaActivity.IMAGE, image)
            intent.putExtra(BebidaActivity.SIZE, size)
            intent.putExtra(BebidaActivity.PRICE, price)
            intent.putExtra(BebidaActivity.MENU_ID, menuID)
            intent.putExtra(BebidaActivity.DRINK, drink)
            startActivity(intent)
        }

        buttonLargeMenu.setOnClickListener {
            val intent = Intent(this, BebidaActivity::class.java)

            //Get size
            size = "Big"

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