package com.example.rihanapp2;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class BDSQLiteOpenHelper extends SQLiteOpenHelper {

    public BDSQLiteOpenHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }

    @Override
    public void onCreate(SQLiteDatabase BasedeDatosSQLiteRihan) {
     //crear la tabla
        BasedeDatosSQLiteRihan.execSQL("create table Usuarios (DNI int primary key, Nombre text, Apellido text, Email text, Contraseña int)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
