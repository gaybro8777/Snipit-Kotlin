package com.om.snipit.books

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.om.snipit.R
import com.om.snipit.models.Book
import com.om.snipit.ui.ItemTouchHelperAdapter
import com.om.snipit.ui.ItemTouchHelperViewHolder
import kotlinx.android.synthetic.main.list_item_book.view.*
import org.jetbrains.anko.backgroundColor
import timber.log.Timber

class BooksRecyclerAdapter(
    private val books: MutableList<Book>) : RecyclerView.Adapter<BooksRecyclerAdapter.ItemViewHolder>(), ItemTouchHelperAdapter {

  override fun getItemCount(): Int = books.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_book, parent, false)
    return ItemViewHolder(view)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    holder.itemView.bookTitleTV.text = books[position].title
    Timber.d("onBindViewHolder")
  }

  override fun onItemMove(fromPosition: Int, toPosition: Int) {
    val previousBook = books.removeAt(fromPosition)
    books.add(if (toPosition > fromPosition) toPosition - 1 else toPosition, previousBook)
    notifyItemMoved(fromPosition, toPosition)
    Timber.d("onItemMove")
  }

  override fun onItemDismiss(position: Int) {
    books.removeAt(position)
    notifyItemRemoved(position)
    Timber.d("onItemDismiss")
  }

  class ItemViewHolder(itemView: View) :
      ItemTouchHelperViewHolder, RecyclerView.ViewHolder(itemView) {

    override fun onItemSelected() {
      Timber.d("Item clicked!")
      itemView.backgroundColor = Color.LTGRAY

    }

    override fun onItemClear() {
//      itemView.backgroundColor = 0
      Timber.d("Item cleared!")
    }
  }
}
