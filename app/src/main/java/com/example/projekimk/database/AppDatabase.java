package com.example.projekimk.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projekimk.database.dao.DatabaseDao;



//untuk entitas model database
@Database(entities = {DatabaseModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}