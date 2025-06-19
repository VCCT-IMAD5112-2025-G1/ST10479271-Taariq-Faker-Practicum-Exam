package vcmsa.ci.st10479271taariqfakerpracticumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    var song= arrayOfNulls<String>(10)

    var artist= arrayOfNulls<String>(10)

    var rating= arrayOfNulls<Int>(10)

    var comments= arrayOfNulls<String>(10)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ExitButton=findViewById<Button>(R.id.btnExit)
        val NextPage=findViewById<Button>(R.id.btnNext)
        val AddToPlaylist=findViewById<Button>(R.id.btnAdd)


        ExitButton.setOnClickListener {
            finishAffinity()
        }

        NextPage.setOnClickListener {

            val intent= Intent(this,DetailedViewScreen::class.java)


        }

        AddToPlaylist.setOnClickListener {

            song[0]="Songs"


        }


        fun Songs (){}
        println("Please Enter a song")
        val songName= readln()

        }
    }
