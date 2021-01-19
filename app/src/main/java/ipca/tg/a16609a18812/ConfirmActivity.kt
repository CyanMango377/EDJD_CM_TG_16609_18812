package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_confirm.*

class ConfirmActivity : AppCompatActivity() {

    companion object {
        const val BURGER_NAME = "burger_name"
        const val IMAGE = "image"
        const val SIZE = "size"
        const val MENU_ID = "menuID"
        const val PRICE = "price"
        const val DRINK = "drink"
    }

    var cartList : MutableList<Menu> = ArrayList()
    lateinit var listViewPedido : ListView
    lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        var size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        val drink = intent.getStringExtra(DRINK)


        val textViewPreco = findViewById<TextView>(R.id.textViewPreco)
        textViewPreco.text = price + "€"

        cartList.add(Menu(menuID, burgerName.toString(), image, price.toString(), drink.toString(), size.toString()))

        listViewPedido = findViewById(R.id.listViewPedido)
        adapter = CartAdapter()
        listViewPedido.adapter = adapter

        buttonFinalizarPedido.setOnClickListener {
            var intent = Intent(this, TableActivity::class.java)
            intent.putExtra(TableActivity.BURGER_NAME,burgerName)
            intent.putExtra(TableActivity.IMAGE, image)
            intent.putExtra(TableActivity.SIZE, size)
            intent.putExtra(TableActivity.PRICE, price)
            intent.putExtra(TableActivity.MENU_ID, menuID)
            intent.putExtra(TableActivity.DRINK, drink)
            startActivity(intent)
        }

        buttonContinuarPedido.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)
            intent.putExtra(PedidoActivity.BURGER_NAME,burgerName)
            intent.putExtra(PedidoActivity.IMAGE, image)
            intent.putExtra(PedidoActivity.SIZE, size)
            intent.putExtra(PedidoActivity.PRICE, price)
            intent.putExtra(PedidoActivity.MENU_ID, menuID)
            intent.putExtra(PedidoActivity.DRINK, drink)
            startActivity(intent)
        }
    }

    inner class CartAdapter : BaseAdapter(){
        override fun getCount(): Int {
            return cartList.size
        }

        override fun getItem(position: Int): Any {
            return  cartList[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rowView = layoutInflater.inflate(R.layout.row_list, viewGroup, false)
            val textViewListaPedidos = rowView.findViewById<TextView>(R.id.textViewListaPedidos)
            val imageViewBurgerLast = rowView.findViewById<ImageView>(R.id.imageViewBurgerLast)
            val buttonRemover = rowView.findViewById<Button>(R.id.buttonRemover)

            textViewListaPedidos.text = cartList[position].name
            imageViewBurgerLast.setImageResource(cartList[position].image)

            rowView.isClickable = true
            buttonRemover.setOnClickListener {
                cartList.removeAt(position)
                adapter.notifyDataSetChanged()
            }

            return rowView
        }

    }
}