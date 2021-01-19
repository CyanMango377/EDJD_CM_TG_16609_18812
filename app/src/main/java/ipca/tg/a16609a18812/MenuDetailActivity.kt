package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_menu_detail.*
import kotlinx.android.synthetic.main.activity_pedido.*

class MenuDetailActivity : AppCompatActivity() {

    companion object {
        const val BURGER_NAME = "burger_name"
        const val MENU_DETAIL = "menu_detail"
        const val IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val burgerName = intent.getStringExtra(BURGER_NAME)
        val menuDetail = intent.getStringExtra(MENU_DETAIL)
        val image = intent.getIntExtra(IMAGE, 0)

        val textViewMenuNameDetail = findViewById<TextView>(R.id.textViewMenuNameDetail)
        val textViewDetailDescricao = findViewById<TextView>(R.id.textViewDetailDescricao)
        val imageViewMenuDetail = findViewById<ImageView>(R.id.imageViewMenuDetail)

        textViewMenuNameDetail.text = burgerName
        textViewDetailDescricao.text = menuDetail
        imageViewMenuDetail.setImageResource(image)


        buttonVoltarDetail.setOnClickListener {
            var intent = Intent(this, PedidoActivity::class.java)
            startActivity(intent)
        }
    }
}