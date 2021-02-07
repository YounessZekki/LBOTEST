package fr.youness.ebook.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import fr.youness.ebook.R
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.data.repository.BookRepository
import fr.youness.ebook.presentation.adapter.BookAdapter
import fr.youness.ebook.presentation.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_list_book.*
import kotlinx.android.synthetic.main.content_list_book.*

class MyBiblioActivity : AppCompatActivity() {

    lateinit var bookViewModel: BookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_biblio)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        swipe_refresh_list_book.isEnabled = false
        bookViewModel = BookViewModel(this)
        bookViewModel.getBooksFromDB()
            .observe(
                this,
                Observer {
                    setUpBookRecyclerView(it)
                }
            )
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun setUpBookRecyclerView(books: List<Item>) {
        if (books.isEmpty()) list_empty.visibility = View.VISIBLE
        else {
            recycler_view_list_book.apply {
                setHasFixedSize(true)
                swipe_refresh_list_book.isRefreshing = false
                layoutManager = LinearLayoutManager(context)
                adapter = books.let { BookAdapter(it, {selectedItem:Item->listItemClicked(selectedItem)}) }
            }
        }
    }
    private fun listItemClicked(book: Item) {
        Toast.makeText(this, getString(R.string.already_saved_in_my_bibliotheque), Toast.LENGTH_LONG).show()
    }
}
