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
        BasedeDatosSQLiteRihan.execSQL("create table BilletesyMonedas (ID int primary key, Tipo text, Valor int)");
        //BasedeDatosSQLiteRihan.execSQL("create table Auto (Valor int)");

        //CREAMOS LA OTRA TABLA DE  MONEDA/BILLETE Y CANTIDAD

        BasedeDatosSQLiteRihan.execSQL("create table UsuarioIDCantidad (Cantidad int,ID int,foreign key(ID) references BilletesyMonedas(ID))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS BilletesyMonedas");

        db.execSQL("DROP TABLE IF EXISTS UsuarioIDCantidad");
    }

}
