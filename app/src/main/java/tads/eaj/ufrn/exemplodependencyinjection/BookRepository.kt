package tads.eaj.ufrn.exemplodependencyinjection

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookDao: BookDao) {

    fun getBooks(): Flow<List<Book>> {
        return bookDao.listAll()
    }

    fun save(book: Book){
        return bookDao.insert(book)
    }
}