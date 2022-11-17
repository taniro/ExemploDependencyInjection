package tads.eaj.ufrn.exemplodependencyinjection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun getDatabase(app:Application):AppDatabase{
        return AppDatabase.invoke(app)
    }

    @Singleton
    @Provides
    fun getDao(database: AppDatabase):BookDao{
        return database.bookDao()
    }
}