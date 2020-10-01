/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingressoronconi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riccardo Ronconi
 */
public class ThVisualizza extends Thread {

    /**
     * Oggetto della classe /c DatiCondivisi che indica i dati condivisi dei
     * thread
     */
    private DatiCondivisi ptrDati;

    /**
     * @brief costruttore che inizializza il thread di lettura
     *
     * @param[in] oggetto della classe /c DatiCondivisi che indica quali sono i
     * dati condivisi dai vari thread in questa sessione
     */
    ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    /**
     * @brief override del metodo run() della classe /c Thread
     */
    public void run() {

        ptrDati.waitCheAbbiaCercato();
        ptrDati.visualizzaRisultati();
        ptrDati.signalCheHoVisualizzato();//semaforo inutile (l'ho messo per casi futuri), tanto eseguo tutto solo una volta.
    }
}
