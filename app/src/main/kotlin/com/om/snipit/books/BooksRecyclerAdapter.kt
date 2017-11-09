package com.om.snipit.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.om.snipit.R
import com.om.snipit.books.touchhelper.ItemTouchHelperAdapter
import com.om.snipit.books.touchhelper.ItemTouchHelperViewHolder
import com.om.snipit.database.entities.Book
import kotlinx.android.synthetic.main.list_item_book.view.*

class BooksRecyclerAdapter(
    private val books: MutableList<Book>) : RecyclerView.Adapter<BooksRecyclerAdapter.ItemViewHolder>(), ItemTouchHelperAdapter {

  override fun getItemCount(): Int = books.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_book, parent, false)
    return ItemViewHolder(view)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    holder.itemView.bookTitleTV.text = books[position].title
  }

  override fun onItemMove(fromPosition: Int, toPosition: Int) {
    val previousBook = books.removeAt(fromPosition)
    books.add(if (toPosition > fromPosition) toPosition - 1 else toPosition, previousBook)
    notifyItemMoved(fromPosition, toPosition)
  }

  override fun onItemDismiss(position: Int) {
    books.removeAt(position)
    notifyItemRemoved(position)
  }

  class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(
      itemView), ItemTouchHelperViewHolder {

    override fun onItemSelected() {
    }

    override fun onItemClear() {
    }
  }
}
