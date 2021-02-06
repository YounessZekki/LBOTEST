package fr.youness.ebook.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.youness.ebook.R
import kotlinx.android.synthetic.main.activity_list_book.*

class ListBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_book)
        setSupportActionBar(toolbar)
    }

}
