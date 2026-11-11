package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ro.pub.cs.systems.eim.practicaltest01var07.R
import java.util.Locale
import kotlin.random.Random

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private lateinit var navigateToSecondaryActivityButton: Button
    private lateinit var upperLeftEditText: EditText
    private lateinit var upperRightEditText: EditText
    private lateinit var lowerLeftEditText: EditText
    private lateinit var lowerRightEditText: EditText
    private lateinit var randomButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_main)

        val etTopLeft = findViewById<EditText>(R.id.upper_left_edit_text)
        val etTopRight = findViewById<EditText>(R.id.upper_right_edit_text)
        val etBottomLeft = findViewById<EditText>(R.id.lower_left_edit_text)
        val etBottomRight = findViewById<EditText>(R.id.lower_right_edit_text)

        val btnSet = findViewById<Button>(R.id.navigate_to_secondary_activity_button)
        val btnRandom = findViewById<Button>(R.id.Random)

        btnRandom.setOnClickListener {
            populateIfInvalid(etTopLeft)
            populateIfInvalid(etTopRight)
            populateIfInvalid(etBottomLeft)
            populateIfInvalid(etBottomRight)
        }

        btnSet.setOnClickListener {
            val intent =
                Intent("ro.pub.cs.systems.eim.practicaltest01var07.intent.action.PracticalTest01Var07SecondaryActivity")
            intent.putExtra("TOP_LEFT", etTopLeft.text.toString())
            intent.putExtra("TOP_RIGHT", etTopRight.text.toString())
            intent.putExtra("BOTTOM_LEFT", etBottomLeft.text.toString())
            intent.putExtra("BOTTOM_RIGHT", etBottomRight.text.toString())

            startActivity(intent)
        }
    }

    private fun populateIfInvalid(editText: EditText) {
        val text = editText.text.toString()
        val floatValue = text.toFloatOrNull()
        if (floatValue == null) {
            val randomValue = Random.nextDouble(0.0, 10.0)
            editText.setText(String.format(Locale.US, "%.2f", randomValue))
        }
    }
}
