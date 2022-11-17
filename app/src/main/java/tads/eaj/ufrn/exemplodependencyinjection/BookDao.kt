package tads.eaj.ufrn.exemplodependencyinjection

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface BookDao {
    @Query("select * from Book")
    fun listAll():Flow<List<Book>>

    @Insert
    fun insert(b:Book)
}