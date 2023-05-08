import GLOOP.*;

public class Kugelszene {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;
    private Loch dasLoch;
    private Kugel kugel1, kugel2, kugel3;

    public Kugelszene() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Wolke.png");
        tastatur = new GLTastatur();

        Spielfeld spielfeld = new Spielfeld(1000, 1000);
        dasLoch = new Loch(spielfeld);
        kugel1 = new Kugel(spielfeld);

           fuehreAus();
       }



    public void fuehreAus() {
        while (0==0) {
            Steuerung();
            Sys.warte(5);
        }
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

