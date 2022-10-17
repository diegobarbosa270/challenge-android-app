package com.dob.desafioapp.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dob.desafioapp.domain.entity.Card

@Database(entities = [Card::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase() {

    abstract val cardDAO: ICardDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getIntanceDatabase(context: Application): AppDataBase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "challenge-db"
                    )
                        .build()
                }
            }

            return INSTANCE
        }

        fun destroyerInstance() {
            INSTANCE = null
        }
    }

}