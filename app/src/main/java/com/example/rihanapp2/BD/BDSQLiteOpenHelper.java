package com.example.rihanapp2.BD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class BDSQLiteOpenHelper extends SQLiteOpenHelper {

    //declara una varibale constante para el nombre
    public static final String  DATABASE_NAME = "RApp2.bd";
    public static final String  TABLE_NAME = " BilletesyMonedasGlobal";
    public static final String  TABLE_NAME02 = "Usuario_Billetes_Monedas";



    public BDSQLiteOpenHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL(" CREATE TABLE  "  + TABLE_NAME + " (ID_BM INTEGER PRIMARY KEY AUTOINCREMENT , TIPO text NOT NULL, VALOR real NOT NULL, CANTIDAD INTEGER )");

        //db2.execSQL(" CREATE TABLE  " + TABLE_NAME02 + "(ID_U INTEGER PRIMARY KEY AUTOINCREMENT, ID_BM INTEGER NOT NULL ,CANTIDAD INTEGER , FOREIGN KEY (ID_BM) REFERENCES BilletesyMonedasGlobal(ID))");
        //db2.execSQL("CREATE TRIGGER fk_usumb_bg BEFORE INSERT ON Usuario_Billetes_Monedas FOR EACH ROW BEGIN SELECT CASE WHEN((SELECT IB_BM FROM BilletesyMonedasGlobal where IB_BM "=new" IB_BM ) is null ) ");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //db2.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME02);
        onCreate(db2);
    }
}