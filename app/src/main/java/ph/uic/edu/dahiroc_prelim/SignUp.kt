package ph.uic.edu.dahiroc_prelim

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ph.uic.edu.dahiroc_prelim.R.id.btncheckBox


class SignUp : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button

    private lateinit var showPasswordCB: CheckBox //imports the id's checkbox

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnSignUp = findViewById(R.id.btnSignUp)

        showPasswordCB = findViewById(R.id.showPasswordCB) //fetch the checkbox ID this for hide password

        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(email, password)
        }

        showPasswordCB.setOnClickListener {
            if(showPasswordCB.isChecked){
                // if clicked shows the password
                edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                 //otherwise hides the password
                edtPassword.inputType = 1
            }
        }
    }

    private fun signUp(email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // jump to home activity
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(this@SignUp, "Some error occured", Toast.LENGTH_SHORT).show()
                }
            }
    }
}