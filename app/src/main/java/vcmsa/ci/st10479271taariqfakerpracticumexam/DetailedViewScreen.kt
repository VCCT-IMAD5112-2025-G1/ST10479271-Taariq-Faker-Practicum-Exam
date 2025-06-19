package vcmsa.ci.st10479271taariqfakerpracticumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)


        val home=findViewById<Button>(R.id.btnHome)
        val Average=findViewById<Button>(R.id.btnAverage)
        val Display=findViewById<Button>(R.id.btnDisplay)
        val container=findViewById<LinearLayout>(R.id.scrollList)
        val averageText=findViewById<TextView>(R.id.AverageText)


        val songsName=intent.getStringArrayListExtra("song")?: arrayListOf()
        val artistName=intent.getStringArrayListExtra("Artist")?: arrayListOf()
        val ratingscore=intent.getIntegerArrayListExtra("ratings")?: arrayListOf()
        val CommentsNotes=intent.getStringArrayListExtra("comments")?: arrayListOf()




        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        Display.setOnClickListener {



            container.removeAllViewsInLayout()

            for(i in songsName.indices){
               val details=TextView(this)

               details.text= "${songsName[i]} - ${artistName[i]}\n  Rating:${ratingscore[i]} \n Comments: ${CommentsNotes[i]}"
                details.textSize=13f
                details.setPadding(0,20,0,20)
                container.addView(details)

            }
        }


        Average.setOnClickListener {

            var total=0

            for (rating in ratingscore) {
                total += rating
            }

            val average = if (ratingscore.isNotEmpty()) {
                total.toDouble() / ratingscore.size
            }
            else{ 0 }
                averageText.text="Average rating is : %. 2f".format(average)

        }
    }
}