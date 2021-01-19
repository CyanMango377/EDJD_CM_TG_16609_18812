package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bebida.*
import kotlinx.android.synthetic.main.activity_table.*

class BebidaActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_bebida)

        //variables
        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        val size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        var drink = intent.getStringExtra(DRINK)

        buttonVoltarDrink.setOnClickListener {
            var intent = Intent(this, MenuTamanhoActivity::class.java)

            intent.putExtra(MenuTamanhoActivity.BURGER_NAME,burgerName)
            intent.putExtra(MenuTamanhoActivity.IMAGE, image)
            intent.putExtra(MenuTamanhoActivity.SIZE, size)
            intent.putExtra(MenuTamanhoActivity.PRICE, price)
            intent.putExtra(MenuTamanhoActivity.MENU_ID, menuID)
            intent.putExtra(MenuTamanhoActivity.DRINK, drink)

            startActivity(intent)
        }

        buttonDrinkCoca.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)

            drink ="Coca-Cola"

            intent.putExtra(PedidoActivity.BURGER_NAME,burgerName)
            intent.putExtra(PedidoActivity.IMAGE, image)
            intent.putExtra(PedidoActivity.SIZE, size)
            intent.putExtra(PedidoActivity.PRICE, price)
            intent.putExtra(PedidoActivity.MENU_ID, menuID)
            intent.putExtra(PedidoActivity.DRINK, drink)

            startActivity(intent)
        }

        buttonDrinkFanta.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)

            drink ="Fanta"

            intent.putExtra(PedidoActivity.BURGER_NAME,burgerName)
            intent.putExtra(PedidoActivity.IMAGE, image)
            intent.putExtra(PedidoActivity.SIZE, size)
            intent.putExtra(PedidoActivity.PRICE, price)
            intent.putExtra(PedidoActivity.MENU_ID, menuID)
            intent.putExtra(PedidoActivity.DRINK, drink)

            startActivity(intent)
        }

        buttonDrinkSuper.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)

            drink ="Super Bock"

            intent.putExtra(PedidoActivity.BURGER_NAME,burgerName)
            intent.putExtra(PedidoActivity.IMAGE, image)
            intent.putExtra(PedidoActivity.SIZE, size)
            intent.putExtra(PedidoActivity.PRICE, price)
            intent.putExtra(PedidoActivity.MENU_ID, menuID)
            intent.putExtra(PedidoActivity.DRINK, drink)

            startActivity(intent)
        }

        buttonDrinkSprite.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)

            drink ="Sprite"

            intent.putExtra(PedidoActivity.BURGER_NAME,burgerName)
            intent.putExtra(PedidoActivity.IMAGE, image)
            intent.putExtra(PedidoActivity.SIZE, size)
            intent.putExtra(PedidoActivity.PRICE, price)
            intent.putExtra(PedidoActivity.MENU_ID, menuID)
            intent.putExtra(PedidoActivity.DRINK, drink)

            startActivity(intent)
        }
    }
}