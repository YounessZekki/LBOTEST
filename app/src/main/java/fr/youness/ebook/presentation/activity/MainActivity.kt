package fr.youness.ebook.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import fr.youness.ebook.R
import fr.youness.ebook.utils.AUTHOR_BOOK_REQUEST
import fr.youness.ebook.utils.TITLE_BOOK_REQUEST

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar?)

        search_btn.setOnClickListener {
            if (bookTitle.text.isNotEmpty()){
                val mIntent = Intent(this@MainActivity, ListBookActivity::class.java)
                mIntent.putExtra(TITLE_BOOK_REQUEST, bookTitle.text.toString())
                mIntent.putExtra(AUTHOR_BOOK_REQUEST, bookAuthor.text.toString())
                startActivity(mIntent)
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.field_required),
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }
}
