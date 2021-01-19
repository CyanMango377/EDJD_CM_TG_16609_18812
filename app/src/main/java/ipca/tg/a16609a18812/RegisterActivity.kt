package ipca.tg.a16609a18812

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Variables Screen
        val regFirstName = this.findViewById<EditText>(R.id.editTextTextPersonFirstNameRegistar)
        val regLastName = this.findViewById<EditText>(R.id.editTextTextPersonLastNameRegistar)
        val regEmail = this.findViewById<EditText>(R.id.editTextTextEmailAddressRegistar)
        val regPassword = this.findViewById<EditText>(R.id.editTextTextPasswordRegistar)
        val buttonRegister = this.findViewById<Button>(R.id.buttonRegistar)

        //variables DB
        var tempUser : User
        val rootNode = FirebaseDatabase.getInstance()
        val reference : DatabaseReference

        reference = rootNode.getReference("user")

        buttonRegister.setOnClickListener {

            //get the values from the screen
            tempUser = User(
                regFirstName.editableText.toString(),
                regLastName.editableText.toString(),
                regEmail.editableText.toString(),
                regPassword.editableText.toString())

            //send to firebase
            reference.child(tempUser.id.toString()).setValue(tempUser)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}