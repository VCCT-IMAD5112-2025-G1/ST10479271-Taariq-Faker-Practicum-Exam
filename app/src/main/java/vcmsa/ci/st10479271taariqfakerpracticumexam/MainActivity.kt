package vcmsa.ci.st10479271taariqfakerpracticumexam

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    var songArray = ArrayList<String>()

    var artistArray = ArrayList<String>()

    var ratingArray = ArrayList<Int>()

    var commentsArray = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ExitButton = findViewById<Button>(R.id.btnExit)
        val NextPage = findViewById<Button>(R.id.btnNext)
        val AddToPlaylist = findViewById<Button>(R.id.btnAdd)


        ExitButton.setOnClickListener {
            finishAffinity()
        }

        NextPage.setOnClickListener {

            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putStringArrayListExtra("songs",songArray)
            intent.putStringArrayListExtra("Artist",artistArray)
            intent.putIntegerArrayListExtra("ratings",ratingArray)
            intent.putStringArrayListExtra("comments",commentsArray)


        }

        AddToPlaylist.setOnClickListener {

            AddSongs()


        }

    }

    private fun AddSongs() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_songs_list, null)


        val SongInput = dialogView.findViewById<EditText>(R.id.EditTextSong)
        val ArtistName = dialogView.findViewById<EditText>(R.id.editTextArtist)
        val RatingInput = dialogView.findViewById<EditText>(R.id.editTextRating)
        val CommentsInput = dialogView.findViewById<EditText>(R.id.editTextComments)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Song Name")
            .setView(dialogView)
            .setPositiveButton("Add")
            { _, _ ->

                val song = SongInput.text.toString()
                val artist = ArtistName.text.toString()
                val Rating = RatingInput.text.toString().toIntOrNull()
                val Comments = CommentsInput.text.toString()

                if (song.isNotEmpty() && artist.isNotEmpty() && Rating != null && Rating in 1..5) {
                    songArray.add(song)
                    artistArray.add(artist)
                    ratingArray.add(Rating)
                    commentsArray.add(Comments)

                    Toast.makeText(this, "Song Added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please fill all the field correctly", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
            .create()


    }
}


