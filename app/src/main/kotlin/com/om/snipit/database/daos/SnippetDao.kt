package com.om.snipit.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.om.snipit.base.SNIPPET_TABLE_NAME
import com.om.snipit.database.entities.Snippet
import io.reactivex.Flowable

@Dao
interface SnippetDao {
  @get:Query("SELECT * FROM $SNIPPET_TABLE_NAME")
  val getAllSnippets: Flowable<MutableList<Snippet>>

  @Query("SELECT * FROM $SNIPPET_TABLE_NAME WHERE snippetId IN (:snippetIds)")
  fun loadAllByIds(snippetIds: IntArray): Flowable<MutableList<Snippet>>

  @Query("SELECT * FROM $SNIPPET_TABLE_NAME WHERE name LIKE :name LIMIT 1")
  fun findByName(name: String): Snippet

  @Insert
  fun insert(snippet: Snippet)

  @Delete
  fun delete(snippet: Snippet)
}