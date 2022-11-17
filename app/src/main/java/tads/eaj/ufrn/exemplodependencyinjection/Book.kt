package tads.eaj.ufrn.exemplodependencyinjection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    val nome:String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}