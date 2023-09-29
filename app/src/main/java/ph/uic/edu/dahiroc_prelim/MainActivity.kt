package ph.uic.edu.dahiroc_prelim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize buttons by IDs
        val buttonBirthday = findViewById<Button>(R.id.btnBirthdayCard)
        val buttonDice = findViewById<Button>(R.id.btnDiceRoll)
        val buttonTaskBud = findViewById<Button>(R.id.btnTaskBud)
        val buttonLemonade = findViewById<Button>(R.id.btnLemonade)
        val button2 = findViewById<Button>(R.id.BACKbtn)

        buttonBirthday.setOnClickListener {
            val intent = Intent(this,HappyBirthdayCard::class.java)
            startActivity(intent)
        }

        buttonDice.setOnClickListener {
            val intent = Intent(this,DiceRoll::class.java)
            startActivity(intent)
        }

        buttonTaskBud.setOnClickListener {
            val intent = Intent(this,TaskBuddy::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    }
}