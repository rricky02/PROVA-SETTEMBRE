package testingressoronconi;

/**
 *
 * @author Riccardo Ronconi
 * @version 0.1
 *
 * @file Semafori.java
 *
 * @brief classe semplice che gestisce la Wait e la Signal di un generico
 * semaforo
 *
 */
public class Semafori {

    /**
     * intero che indica il valore di inizializzazione del semaforo
     */
    private int valore;

    /**
     * @brief costruttore che inizializza il semaforo
     *
     * @param[in] val intero che indica il valore di inizializzazione del
     * semaforo
     */
    public Semafori(int val) {
        this.valore = val;
    }

    /**
     * @brief metodo che gestisce la Wait del semaforo
     */
    synchronized public void Wait() {
        while (valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valore--;
    }

    /**
     * @brief metodo che gestisce la Signal del semaforo
     */
    synchronized public void Signal() {
        valore++;
        notify();
    }
}
