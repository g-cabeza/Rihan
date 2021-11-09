package com.example.rihanapp2;

public class Singleton {
    private static Singleton instance;
    public int moneda10=0, moneda5=0,moneda2=0,moneda1=0,moneda50=0,moneda25=0;
    public int billete1000=0, billete500=0, billete200=0, billete100=0, billete50=0, billete20=0,billete10=0;
    public static Singleton getInstance()

    {
        if (instance == null)
        {
            // Create the instance
            instance = new Singleton();
        }
        return instance;
    }
    private Singleton()
    {
        // Constructor hidden because this is a singleton
    }
    public void init() {
        moneda10=0;
        moneda5=0;
        moneda2=0;
        moneda1=0;
        moneda50=0;
        moneda25=0;

        billete1000=0;
        billete500=0;
        billete200=0;
        billete100=0;
        billete50=0;
        billete20=0;
        billete10=0;

    }
}