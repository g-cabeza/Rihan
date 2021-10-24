package com.example.rihanapp2;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class BDSQLiteOpenHelper extends SQLiteOpenHelper {

    String B1000,B500,B200,B100,B50,B20,B10;
    String M10,M5,M2,M1,M50,M25;
    String Moneda,Billete;



    public BDSQLiteOpenHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase BasedeDatosSQLiteRihan) {
     //crear la tabla
        BasedeDatosSQLiteRihan.execSQL("create table BilletesyMonedas (ID int primary key, Tipo text, Valor int)");

        // Gets the data repository in write mode
        BDSQLiteOpenHelper admin = new BDSQLiteOpenHelper(this,"BilletesyMonedas",null,1);
        SQLiteDatabase BasedeDatosBilletesMonedas = admin.getWritableDatabase();

       // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("ID", B1000);
        values.put("Tipo", Billete);
        values.put("Valor", 1000);

        values.put("ID", B500);
        values.put("Tipo", Billete);
        values.put("Valor", 500);

        values.put("ID", B200);
        values.put("Tipo", Billete);
        values.put("Valor", 200);

        values.put("ID", B100);
        values.put("Tipo", Billete);
        values.put("Valor", 100);

        values.put("ID", B50);
        values.put("Tipo", Billete);
        values.put("Valor", 50);

        values.put("ID", B20);
        values.put("Tipo", Billete);
        values.put("Valor", 20);

        values.put("ID", B10);
        values.put("Tipo", Billete);
        values.put("Valor", 10);

        //Monedas
        values.put("ID", M10);
        values.put("Tipo", Moneda);
        values.put("Valor", 10);

        values.put("ID", M5);
        values.put("Tipo", Moneda);
        values.put("Valor", 5);

        values.put("ID", M2);
        values.put("Tipo", Moneda);
        values.put("Valor", 2);

        values.put("ID", M1);
        values.put("Tipo", Moneda);
        values.put("Valor", 1);

        values.put("ID", M50);
        values.put("Tipo", Moneda);
        values.put("Valor", 0.50);

        values.put("ID", M25);
        values.put("Tipo", Moneda);
        values.put("Valor", 0.25);



       // Insert los datos en la tabla
        BasedeDatosBilletesMonedas.insert("BilletesyMonedas", null, values);
        BasedeDatosBilletesMonedas.close();

        //CREAMOS LA OTRA TABLA DE  MONEDA/BILLETE Y CANTIDAD

        BasedeDatosSQLiteRihan.execSQL("create table UsuarioIDCantidad (ID int primary key, Cantidad int)");












    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}
