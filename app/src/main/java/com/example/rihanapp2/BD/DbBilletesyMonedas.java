package com.example.rihanapp2.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.rihanapp2.entidades.BilletesyMonedas;

import java.util.ArrayList;

public class DbBilletesyMonedas extends BDSQLiteOpenHelper{

    Context context;


    public DbBilletesyMonedas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarDatos(String TIPO,String VALOR){

        long ID=0;

        try{
            BDSQLiteOpenHelper basededatos = new BDSQLiteOpenHelper(context);
            SQLiteDatabase db = basededatos.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("TIPO ",TIPO);
            values.put("VALOR",VALOR);

            ID = db.insert(TABLE_NAME,null,values);

        }catch (Exception ex){
            ex.toString();
        }

        return ID;
    }
    //sacamos este metodo porqu vemos la base dedatos desde el programa BDBROWSE FOR QLITE
    public ArrayList<BilletesyMonedas>mostrarBilletesyMonedas(){
        BDSQLiteOpenHelper basededatos = new BDSQLiteOpenHelper(context);
        SQLiteDatabase db = basededatos.getWritableDatabase();

        ArrayList<BilletesyMonedas> listaBilletesMonedas = new ArrayList<>();
        BilletesyMonedas billetesyMonedas =null;
        Cursor cursorBilletesMonedas = null;

        cursorBilletesMonedas = db.rawQuery("SELECT * FROM  " + TABLE_NAME,null);

        if (cursorBilletesMonedas.moveToFirst()){
            do{
                billetesyMonedas = new BilletesyMonedas();
                billetesyMonedas.setID(cursorBilletesMonedas.getInt(0));
                billetesyMonedas.setTIPO(cursorBilletesMonedas.getString(1));
                billetesyMonedas.setVALOR(cursorBilletesMonedas.getString(2));
                listaBilletesMonedas.add(billetesyMonedas);
            }while (cursorBilletesMonedas.moveToNext());

        }
        cursorBilletesMonedas.close();
        return listaBilletesMonedas;

    }





}
