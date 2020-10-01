/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingressoronconi;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronconi_riccardo
 */
public class TestIngressoRonconi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("***INIZIO DEL PROGRAMMA***");
        
        System.out.println("Scrivere la classe che si vuole cercare: ");
        Scanner s = new Scanner(System.in);
        String classe = s.nextLine();
        DatiCondivisi dc = new DatiCondivisi(classe);
        ThCerca tC0 = new ThCerca(dc, 0);
        ThCerca tC1 = new ThCerca(dc, 1);
        ThCerca tC2 = new ThCerca(dc, 2);
        ThCerca tC3 = new ThCerca(dc, 3);
        ThCerca tC4 = new ThCerca(dc, 4);
        ThCerca tC5 = new ThCerca(dc, 5);
        ThCerca tC6 = new ThCerca(dc, 6);
        ThVisualizza tV = new ThVisualizza(dc);
        
        tC0.start();
        tC1.start();
        tC2.start();
        tC3.start();
        tC4.start();
        tC5.start();
        tC6.start();
        tV.start();
        
        try {
            tC0.join();
            tC1.join();
            tC2.join();
            tC3.join();
            tC4.join();
            tC5.join();
            tC6.join();
            tV.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestIngressoRonconi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
