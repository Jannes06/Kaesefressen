import GLOOP.*;

public class Kugelfang {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;
    private Loch dasLoch;
    private Kugel kugel1, kugel2, kugel3;

    public Kugelfang() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);
        dasLoch = new Loch();
        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Wolke.png");
        tastatur = new GLTastatur();
        kugel1 = new Kugel();
        Spielfeld spielfeld = new Spielfeld(1000, 1000);
       while (0==0) {
           fuehreAus();
       }
    }


    public void fuehreAus() {

            Steuerung();
Sys.warte(5);
    }

    public void Steuerung() {

        if (tastatur.oben()) {
            dasLoch.bewegeOben();
        }
        if (tastatur.unten()) {
            dasLoch.bewegeUnten();
        }
        if (tastatur.rechts()) {
            dasLoch.bewegeRechts();
        }
        if (tastatur.links()) {
            dasLoch.bewegeLinks();
        }
    }


}

