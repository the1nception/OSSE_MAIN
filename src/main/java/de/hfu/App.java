package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args )
    {
        try {
            /**
             * Javadoc Kommentar: Buffered Reader liest String ein
             * @param eingabe ist der Buffered Reader
             */
            BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
            String s = eingabe.readLine();
            String caps = s.toUpperCase();
            /**
             * Änderungsnachweis
             * @param caps ist der String mit Großbuchstaben
             */
            System.out.println(caps);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
