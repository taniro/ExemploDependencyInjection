package tads.eaj.ufrn.exemplodependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.ViewModelProvider


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var viewmodel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val b1 = Book("Witcher")
        val b2 = Book("Harry Potter")
        val b3 = Book("Lord of the Rings")
        viewmodel.insert(b1)
        viewmodel.insert(b2)
        viewmodel.insert(b3)

        viewmodel.livros.observe(this){
            it?.forEach {
                Log.i("AULA", it.nome)
            }
        }
    }
}