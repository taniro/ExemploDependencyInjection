package tads.eaj.ufrn.exemplodependencyinjection

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: BookRepository) : ViewModel() {
        val livros = repository.getBooks().asLiveData()

        fun insert(book: Book){
                viewModelScope.launch {
                        withContext(Dispatchers.IO){
                                repository.save(book)
                        }
                }
        }
}