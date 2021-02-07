package fr.youness.ebook.presentation.adapter

import android.content.Context
import android.content.Intent
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.youness.ebook.R
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.data.repository.BookRepository
import fr.youness.ebook.presentation.activity.DetailBookActivity
import fr.youness.ebook.utils.EXTRA_BOOK
import kotlinx.android.synthetic.main.book_item.view.*
import kotlinx.coroutines.coroutineScope

class BookAdapter(val listBook: List<Item>, val clickListener:(Item)->Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    lateinit var context: Context
    lateinit var bookRepository: BookRepository
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Item, clickListener:(Item)->Unit) {
            Picasso
                .with(itemView.context)
                .load(book.volumeInfo?.imageLinks?.smallThumbnail)
                .into(itemView.bookImage)
            itemView.bookTitle.text = book.volumeInfo?.title
            book.volumeInfo?.authors?.forEach { author->
                itemView.bookAuthor.text = author
            }
            itemView.bookSearchInfo.text =
                book.searchInfo?.textSnippet?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY) }
            itemView.bookDescription.text = book.volumeInfo?.description
            itemView.star.setOnClickListener {
                clickListener(book)
            }
        }
    }

    override fun getItemCount(): Int {
        return listBook?.size ?: 0
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = listBook?.get(position)
        return currentBook.let {
            holder.bind(it, clickListener)
            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailBookActivity::class.java)
                intent.putExtra(EXTRA_BOOK, currentBook)
                context.startActivity(intent)
            }
        }
    }
}