package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Billetes_Monedas_BD extends AppCompatActivity implements View.OnClickListener  {

    private TextView  IDB1000,IDB500,IDB200,IDB100,IDB50,IDB20,IDB10;    //ID DE LOS BILLETES
    private TextView  IDM10,IDM5,IDM2,IDM1,IDM50,IDM25;                  //ID DE LAS MONEDAS

    private TextView  TipoBillete,TipoMoneda;

    private TextView  ValorB1000,ValorB500,ValorB200,ValorB100,ValorB50,ValorB20,ValorB10;    //VALORbILLETES
    private TextView  ValorM10,ValorM5,ValorM2,ValorM1,ValorM50,ValorM25;                     //VALORMONEDAS

    private Button    Consulta;

    private EditText  ID,Tipo,Valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billetes_monedas_bd);

        IDB1000 = (TextView) findViewById(R.id.textView55);
        TipoBillete = (TextView) findViewById(R.id.textView63);
        ValorB1000 = (TextView) findViewById(R.id.textView60);

        IDB500 = (TextView) findViewById(R.id.textView64);
        TipoBillete = (TextView) findViewById(R.id.textView68);
        ValorB500 = (TextView) findViewById(R.id.textView67);

        IDB200 = (TextView) findViewById(R.id.textView80);
        TipoBillete = (TextView) findViewById(R.id.textView82);
        ValorB200 = (TextView) findViewById(R.id.textView81);

        IDB100 = (TextView) findViewById(R.id.textView83);
        TipoBillete = (TextView) findViewById(R.id.textView85);
        ValorB100 = (TextView) findViewById(R.id.textView84);

        IDB50 = (TextView) findViewById(R.id.textView88);
        TipoBillete = (TextView) findViewById(R.id.textView86);
        ValorB50 = (TextView) findViewById(R.id.textView90);

        IDB20 = (TextView) findViewById(R.id.textView89);
        TipoBillete = (TextView) findViewById(R.id.textView87);
        ValorB20 = (TextView) findViewById(R.id.textView91);

        IDB10 = (TextView) findViewById(R.id.textView92);
        TipoBillete = (TextView) findViewById(R.id.textView63);
        ValorB10 = (TextView) findViewById(R.id.textView93);

        //MONEDAS
        IDM10=(TextView) findViewById(R.id.textView71);
        TipoMoneda=(TextView) findViewById(R.id.textView70);
        ValorM10=(TextView) findViewById(R.id.textView72);

        IDM5=(TextView) findViewById(R.id.textView78);
        TipoMoneda=(TextView) findViewById(R.id.textView73);
        ValorM5=(TextView) findViewById(R.id.textView98);

        IDM2=(TextView) findViewById(R.id.textView94);
        TipoMoneda=(TextView) findViewById(R.id.textView74);
        ValorM2=(TextView) findViewById(R.id.textView99);

        IDM1=(TextView) findViewById(R.id.textView95);
        TipoMoneda=(TextView) findViewById(R.id.textView75);
        ValorM1=(TextView) findViewById(R.id.textView100);

        IDM50=(TextView) findViewById(R.id.textView96);
        TipoMoneda=(TextView) findViewById(R.id.textView76);
        ValorM50=(TextView) findViewById(R.id.textView101);

        IDM25=(TextView) findViewById(R.id.textView97);
        TipoMoneda=(TextView) findViewById(R.id.textView77);
        ValorM25=(TextView) findViewById(R.id.textView102);

        Consulta = (Button)findViewById(R.id.button2);
        Consulta.setOnClickListener(this);

        ID    = (EditText)findViewById(R.id.id_consulta);
        Tipo  = (EditText)findViewById(R.id.tipo_consulta);
        Valor = (EditText)findViewById(R.id.valor_consulta);






        //SQLite
        // Gets the data repository in write mode
        BDSQLiteOpenHelper admin = new BDSQLiteOpenHelper(this,"BilletesyMonedas",null,1);
        SQLiteDatabase BasedeDatosBilletesMonedas = admin.getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues BilleteMonedas = new ContentValues();

        BilleteMonedas.put("ID",String.valueOf(IDB1000));
        BilleteMonedas.put("Tipo", String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor", String.valueOf(ValorB1000));

        BilleteMonedas.put("ID",String.valueOf(IDB500));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB500));

        BilleteMonedas.put("ID",String.valueOf(IDB200));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB200));

        BilleteMonedas.put("ID",String.valueOf(IDB100));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB100));

        BilleteMonedas.put("ID",String.valueOf(IDB50));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB50));

        BilleteMonedas.put("ID",String.valueOf(IDB20));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB20));

        BilleteMonedas.put("ID",String.valueOf(IDB10));
        BilleteMonedas.put("Tipo",String.valueOf(TipoBillete));
        BilleteMonedas.put("Valor",String.valueOf(ValorB10));

        //Monedas
        BilleteMonedas.put("ID",String.valueOf(IDM10));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM10));

        BilleteMonedas.put("ID",String.valueOf(IDM5));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM5));

        BilleteMonedas.put("ID",String.valueOf(IDM2));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM2));

        BilleteMonedas.put("ID",String.valueOf(IDM1));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM1));

        BilleteMonedas.put("ID",String.valueOf(IDM50));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM50));

        BilleteMonedas.put("ID",String.valueOf(IDM25));
        BilleteMonedas.put("Tipo",String.valueOf(TipoMoneda));
        BilleteMonedas.put("Valor",String.valueOf(ValorM25));

        // Insert los datos en la tabla
        //Todo lo que esta comentado aca se probo con el profesor
        //ContentValues values;
        //values=new ContentValues();
       // values.put("Valor",50);

        BasedeDatosBilletesMonedas.insert("BilletesyMonedas", null, BilleteMonedas);
       // BasedeDatosBilletesMonedas.insert("Auto", null, values);
       // BasedeDatosBilletesMonedas.execSQL("insert into BilletesyMonedas values('W10','TipoMoneda','10');");

       // BasedeDatosBilletesMonedas.insert("BilletesyMonedas", null, BilleteMonedas);
        BasedeDatosBilletesMonedas.close();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                ConsultaBD();
                break;
            case R.id.imageView113:
                startActivity(new Intent(this, AjustesMenu.class));
                break;

        }
    }

    private void ConsultaBD() {
        BDSQLiteOpenHelper adminconsulta = new BDSQLiteOpenHelper(this,"BilletesyMonedas",null,1);
        SQLiteDatabase basededatosconsulta = adminconsulta.getWritableDatabase();

        String codigoId = ID.getText().toString();

        if (!codigoId.isEmpty()){
            //String query = "SELECT * FROM BilletesyMonedas  WHERE codigoId = " + codigoId;
            //String query = "SELECT * FROM Auto";
            Cursor consultabd = basededatosconsulta.rawQuery("SELECT Tipo, Valor FROM BilletesyMonedas WHERE codigoId =" + codigoId,null);


            if (consultabd.moveToFirst()){
                Tipo.setText(consultabd.getString(0));
                Valor.setText(consultabd.getString(1));
                basededatosconsulta.close();
            }else{
                Toast.makeText(this,"El ID no existe",Toast.LENGTH_SHORT).show();
                basededatosconsulta.close();
            }
        }else{
            Toast.makeText(this,"Debes ingresar el ID del Billete/Moneda a buscar ",Toast.LENGTH_SHORT).show();

        }






    }

}