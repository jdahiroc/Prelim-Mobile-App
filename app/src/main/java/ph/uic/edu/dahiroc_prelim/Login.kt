package ph.uic.edu.dahiroc_prelim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {


    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var btncheckBox: CheckBox //variable for checkbox

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)

        btncheckBox = findViewById(R.id.btncheckBox) //import the checkbox ID this for hide password


        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email, password)
        }

        btncheckBox.setOnClickListener {
            if(btncheckBox.isChecked) {
                edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD //otherwise hides the password
            } else {
                edtPassword.inputType = 1 //if checks will shows the password
            }
        }
    }

    private fun login(email:String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // code for logging existing user

                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login, "User doesn't exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
}