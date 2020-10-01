/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingressoronconi;

/**
 *
 * @author Riccardo Ronconi
 * @version 0.1
 *
 * @file DatiCondivisi.java
 *
 * @brief classe che gestisce i dati condivisi dai processi (thread)
 *
 */
public class DatiCondivisi {

    private String classeDaTrovare;
    private String[] prof;
    private Semafori semFineVisualizzazione, semFineRicerca;
    private String[] risultatoRicerca;
    private String orari;

    /**
     * @brief costruttore che inizializza i semafori e quindi i dati condivisi
     *
     */
    DatiCondivisi(String classe) {
        classeDaTrovare = classe;
        orari = "ORA,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,tot ore";
        prof[0] = "AGOSTONI G.,2BI,2CI LFS,1AI LFS,.,.,.,2CI,1AI,1BI LFS,2AI,.,.,-,-,-,-,-,-,1BI,2BI LFS,1CI LFS,.,2AI,.,1CI,2CI,1AI,.,2AI LFS,.,1CI,1BI,2BI,.,.,18";
        prof[1] = "ALI' M.,3AL,4BS,.,4AL,5AS,.,5AL,5BL,.,4BL,3AS,.,-,-,-,-,-,-,4BS,3BS,3AL,4BL,.,.,.,.,4AL,3BS,4AS,.,3AS,5BL,5AL,5AS,4AS,20";
        prof[2] = "ALIPRANDI S.,4AM LI5,4AM LI5,4BE,.,3EE,.,.,.,5AM LSM,5AM LSM,3EE LSM,3EE LSM,-,-,-,-,-,-,.,.,.,4BE LSM,4BE LSM,4AM,4AM,5AM LSM,.,4BE,5BM LSM,.,.,.,5BM LSM,5BM LSM,3EE,18";
        prof[3] = "ANDREACCHI S.,5AI LI6,1CI LI4,4BI LI7,5BI LI7,.,.,3BI LI7,3BI LI7,5BI LI7,4CI LI7,4CI LI7,.,5AI LI6,5AI LI6,.,4BI LI7,4BI LI7,.,.,5BI LI7,5BI LI7,.,.,.,.,.,1CI LI4,3BI LI7,4CI LI7,.,-,-,-,-,-,18";
        prof[4] = "ASTA L.,-,-,-,-,-,-,.,.,.,4AM,2AM,2AM,3EE,3EE,.,4AM,2AM,.,2AM,4AM,4AM,.,.,.,3EE,3EE,2AM,4AM,.,.,4AM,3EE,3EE,.,2AM,18";
        prof[5] = "BALLABIO M.L.,5D,2B,1D,.,5AI,.,.,.,2B,5AI,2C,5D,.,.,1D,5D,2C,.,,,,,,,.,5AI,1D,2C,2B,.,-,-,-,-,-,15";
        prof[6] = "BARDI P.,.,.,1BM LI4,5AI LI6,1CM LI4,.,-,-,-,-,-,-,1AM LI4,.,1CM LI4,.,.,.,5AI LI6,5AI LI6,1BM LI4,.,1AM LI4,.,1AC LI2,1AC LI2,1BC LI2,1BC LI2,.,.,5AI LI6,5AI LI6,4AI LI6,4AI LI6,3AI LI6,18";

        for (int i = 0; i < 8; i++) {
            risultatoRicerca[i] = "";
        }

        semFineVisualizzazione = new Semafori(1); //inizializzato a 1 per poter far cominciare il programma.
        semFineRicerca = new Semafori(0);
    }

    void cercaProf(int prof) {

        String ora[] = this.prof[prof].split(",");
        String ris = "";

        for (int i = 0; i < ora.length; i++) { //in teoria sono 38 le celle del vettore ora[], comprese le classi, il nome del professore nella prima cella e il numero totale delle ore nell'ultima cella.
            if (ora[i].toLowerCase().equals(classeDaTrovare.toLowerCase())) {
                ris += ora[0] + "," + i + ",";
            }
        }
        risultatoRicerca[prof] = ris; //la stringa che ho è formata da: il nome del professore e il numero dell'ora in cui è stata trovata la classe.
        //i vettori prof[] e risultatoRicerca[] sono praticamente "paralleli".
    }

    void visualizzaRisultati() {
        boolean trovatoQualcosa = false;
        for (int i = 0; i < risultatoRicerca.length; i++) {
            if (!risultatoRicerca[i].equals("")) {
                trovatoQualcosa = true;
            }
        }

        if (trovatoQualcosa) { //se ho trovato qualcosa, visualizzo!

            String riga[];
            for (int i = 0; i < risultatoRicerca.length; i++) {
                riga = risultatoRicerca[i].split(","); //splitto i vari professori dai vari orari.

                for (int j = 0; j < riga.length; j++) //visualizzo il singolo risultato
                {
                    if (j % 0 == 2) {
                        System.out.println("Professore: " + riga[j]);
                    } else {
                        System.out.println("Ora: " + riga[j]);
                    }
                }
            }
        } else {
            System.out.println("Non ho trovato nulla...");
        }
        //------------------------------------------------------
        //------------------------------------------------------
        //NON HO FINITO QUESTO METODO: è tardi e devo fare ancora fare il diagramma delle classi e GitHub!!!
        //------------------------------------------------------
        //------------------------------------------------------
    }

    void waitCheAbbiaVisualizzato() {
        semFineVisualizzazione.Wait();
    }

    void waitCheAbbiaCercato() {
        semFineRicerca.Wait();
    }

    void signalCheHoVisualizzato() {
        semFineVisualizzazione.Signal();
    }

    void signalCheHoRicercato() {
        semFineRicerca.Signal();
    }

}
