package fr.youness.ebook.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.squareup.picasso.Picasso
import fr.youness.ebook.R
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.utils.EXTRA_BOOK

import kotlinx.android.synthetic.main.activity_detail_book.*
import kotlinx.android.synthetic.main.content_detail_book.*

class DetailBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        Récupérer l'objet Book
        val book = intent.getSerializableExtra(EXTRA_BOOK) as Item

        bindComponents(book)
    }

    private fun bindComponents(book: Item) {
        Picasso
            .with(this)
            .load(book.volumeInfo?.imageLinks?.smallThumbnail)
            .into(bookImage)
        bookTitle.text = book.volumeInfo?.title
        book.volumeInfo?.authors?.forEach { author -> bookAuthor.text = author }
        bookSearchInfo.text = book.searchInfo?.textSnippet?.let {
            HtmlCompat.fromHtml(
                it,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        }
        bookDescription.text = book.volumeInfo?.description
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        Log.d("item id", item.itemId.toString())
        Log.d("android.R.id.home", android.R.id.home.toString())
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

}
