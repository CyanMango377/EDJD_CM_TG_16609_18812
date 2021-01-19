package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_inicial.*
import kotlinx.android.synthetic.main.activity_pedido.*

class PedidoActivity : AppCompatActivity() {

    //Companion Object
    companion object{
        const val BURGER_NAME = "burger_name"
        const val IMAGE = "image"
        const val SIZE = "size"
        const val MENU_ID = "menuID"
        const val PRICE = "price"
        const val  DRINK = "drink"
    }

    var menuList : MutableList<Menu> = ArrayList()
    lateinit var listViewMenu : ListView
    lateinit var adapter: MenuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        menuList.add(Menu(1, "Big Burger Menu", R.drawable.big,"1x Big Burger\n1x Dose Batatas\n1x Bebida", "Um menu que conta com o nosso suculento Big Burger de carne fumada, e queijo derretido, e um belo molho especial, a acompanhar com as nossas deliciosas Batatas e uma bebida do nosso menu.\n" + "Delicie-se com este estupendo menu!\n" + "Bom Apetite!\n", "4,99", "0","0"))
        menuList.add(Menu(2, "Egg Burger Menu", R.drawable.egg,"1x Egg Burger\n1x Dose Batatas\n1x Bebida", "Um menu que conta com o nosso suculento Egg Burger de carne fumada, um ovo por cima da carne, e queijo derretido, e um saboroso molho de maionese e alho, a acompanhar com as nossas deliciosas Batatas e uma bebida do nosso menu.\n" + "Delicie-se com este estupendo menu!\n" + "Bom Apetite!\n", "5,99", "0","0"))
        menuList.add(Menu(3, "CBO Burger Menu", R.drawable.chicken,"1x CBO Burger\n1x Dose Batatas\n1x Bebida", "Um menu que conta com o nosso suculento CBO Burger com a sua caracteristica forma quadrada, feito com carne de frango, com pedaços de bacon no pão e queijo derretido, e um belo molho especial, a acompanhar com as nossas deliciosas Batatas e uma bebida do nosso menu.\n" + "Delicie-se com este estupendo menu!\n" + "Bom Apetite!\n", "6,99", "0","0"))
        menuList.add(Menu(4, "Nuggets", R.drawable.nuggets,"6x Chicken Nuggets", "Delicie-se com os nossos irresistíveis Nuggets de Frango, com uma fritura perfeita, e feito com o maior amor e carinho!\n" + "Bom Apetite!\n", "1,49", "0","0"))
        menuList.add(Menu(5, "Gelado", R.drawable.gelado,"1x Gelado", "Delicie-se com o nosso irresistível e cremoso gelado!\n" + "Bom Apetite!\n", "2,49", "0","0"))
        menuList.add(Menu(6, "Tarte de Maçã", R.drawable.tarte,"1x Tarte de Maçã", "Delicie-se com a nossa crocante e suculenta tarte de maçã!\n" + "Bom Apetite!\n", "1,79", "0","0"))
        menuList.add(Menu(7, "Café", R.drawable.cafe,"1x Café", "Aconchegue o seu estomago e complete a sua refeição com um bom café quentinho!\n" + "Bom Apetite!\n", "0,60", "0","0"))
        menuList.add(Menu(8, "Molho de Maionese com Alho", R.drawable.alho,"1x Molho de Maionese com Alho", "Incremente o sabor da sua refeição com este Molho!\nUma perfeita mistura de maionese e alho, que tornam este molho irresistível!\n" + "Bom Apetite!\n", "0,39", "0","0"))
        menuList.add(Menu(9, "Molho Barbecue", R.drawable.bq,"1x Molho Barbecue", "Incremente o sabor da sua refeição com este Molho!\nUm perfeito molho Barbecue, que tornam este molho irresistível!\n" + "Bom Apetite!\n", "0,39", "0","0"))

        listViewMenu = findViewById(R.id.listViewMenus)
        adapter = MenuAdapter()
        listViewMenu.adapter = adapter

        //variables
        val burgerName = intent.getStringExtra(BURGER_NAME)
        val image = intent.getIntExtra(IMAGE, 0)
        val size = intent.getStringExtra(SIZE)
        val menuID = intent.getIntExtra(MENU_ID, 0)
        val price = intent.getStringExtra(PRICE)
        var drink = intent.getStringExtra(DRINK)

        buttonVerificarPedido.setOnClickListener {
            var intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra(ConfirmActivity.BURGER_NAME,burgerName)
            intent.putExtra(ConfirmActivity.IMAGE, image)
            intent.putExtra(ConfirmActivity.SIZE, size)
            intent.putExtra(ConfirmActivity.PRICE, price)
            intent.putExtra(ConfirmActivity.MENU_ID, menuID)
            intent.putExtra(ConfirmActivity.DRINK, drink)
            startActivity(intent)
        }

        buttonCancelar.setOnClickListener {
            var intent = Intent(this, InicialActivity::class.java)
            startActivity(intent)
        }
    }

    inner class MenuAdapter : BaseAdapter(){
        override fun getCount(): Int {
            return menuList.size
        }

        override fun getItem(position: Int): Any {
            return  menuList[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rowView = layoutInflater.inflate(R.layout.row_pedido, viewGroup, false)
            val textViewFirstMenuName = rowView.findViewById<TextView>(R.id.textViewFirstMenuName)
            val textViewFirstMenuConteudo = rowView.findViewById<TextView>(R.id.textViewFirstMenuConteudo)
            val imageViewFirstMenu = rowView.findViewById<ImageView>(R.id.imageViewFirstMenu)
            val buttonAddFirstMenu = rowView.findViewById<Button>(R.id.buttonAddFirstMenu)

            textViewFirstMenuName.text = menuList[position].name
            textViewFirstMenuConteudo.text = menuList[position].content
            imageViewFirstMenu.setImageResource(menuList[position].image)

            rowView.isClickable = true
            rowView.setOnClickListener {
                val intent = Intent (this@PedidoActivity, MenuDetailActivity::class.java)
                intent.putExtra(MenuDetailActivity.BURGER_NAME, menuList[position].name)
                intent.putExtra(MenuDetailActivity.MENU_DETAIL, menuList[position].detail)
                intent.putExtra(MenuDetailActivity.IMAGE, menuList[position].image)
                startActivity(intent)
            }

            buttonAddFirstMenu.setOnClickListener {
                if (menuList[position].id > 0 && menuList[position].id < 4) {
                    var intent = Intent(this@PedidoActivity, MenuTamanhoActivity::class.java)
                    intent.putExtra(MenuTamanhoActivity.BURGER_NAME, menuList[position].name)
                    intent.putExtra(MenuTamanhoActivity.IMAGE, menuList[position].image)
                    intent.putExtra(MenuTamanhoActivity.SIZE, menuList[position].size)
                    intent.putExtra(MenuTamanhoActivity.PRICE, menuList[position].price)
                    intent.putExtra(MenuTamanhoActivity.MENU_ID, menuList[position].id)
                    intent.putExtra(MenuTamanhoActivity.DRINK, menuList[position].drink)
                    startActivity(intent)
                }
                else {
                    var intent = Intent(this@PedidoActivity, ConfirmActivity::class.java)
                    intent.putExtra(ConfirmActivity.BURGER_NAME, menuList[position].name)
                    intent.putExtra(ConfirmActivity.IMAGE, menuList[position].image)
                    intent.putExtra(ConfirmActivity.SIZE, menuList[position].size)
                    intent.putExtra(ConfirmActivity.PRICE, menuList[position].price)
                    intent.putExtra(ConfirmActivity.MENU_ID, menuList[position].id)
                    intent.putExtra(ConfirmActivity.DRINK, menuList[position].drink)
                    startActivity(intent)
                }
                adapter.notifyDataSetChanged()
            }

            return rowView
        }

    }
}