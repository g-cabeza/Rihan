package com.example.rihanapp2;

    public class Singleton2  {
        private static Singleton2 instance;

        public int billete1000=0, billete500=0, billete200=0, billete100=0, billete50=0, billete20=0,billete10=0;
        public static Singleton2 getInstance()

        {
            if (instance == null)
            {
                // Create the instance
                instance = new Singleton2();
            }
            return instance;
        }
        private Singleton2()
        {
            // Constructor hidden because this is a singleton
        }
        public void init() {

            billete1000=0;
            billete500=0;
            billete200=0;
            billete100=0;
            billete50=0;
            billete20=0;
            billete10=0;

        }
    }


