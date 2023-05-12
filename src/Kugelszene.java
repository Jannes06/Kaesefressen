import GLOOP.*;

public class Kugelszene {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;
    private Loch dasLoch;

    private GLTafel kugelAnzeige;
     Kugel [] kugeln;
    int timer;

    int gesammelteKugeln =0;
    int kugelanzahl = 10000;
    double lochRadius  = 30;

    public Kugelszene() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Wolke.png");
        tastatur = new GLTastatur();

        kugelAnzeige = new GLTafel(0,100,0,100,100);

        Spielfeld spielfeld = new Spielfeld(1000, 1000);
        dasLoch = new Loch(spielfeld, lochRadius);
        kugeln = new Kugel [kugelanzahl];
        for (int i=0;i<kugelanzahl;i++) {
            kugeln[i]=new Kugel(spielfeld, dasLoch, lochRadius);
        }

           fuehreAus();
       }



    public void fuehreAus() {
        while (0==0) {

            timer = timer +1;
            Steuerung();
            Sys.warte(5);
            kugelRollen();
            kugelFangen();



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
    public void kugelRollen(){
        for (int e = 0; e<kugelanzahl;e++ ){
         kugeln[e].bewege();
        }
    }
    public void kugelFangen() {
        if (timer >500) {
            for (int e = 0; e < kugelanzahl; e++) {
                gesammelteKugeln = gesammelteKugeln + kugeln[e].getroffenZahl();

                kugeln[e].getroffen();
            }
            kugelAnzeige.setzeText(""+gesammelteKugeln,20);

        }
    }
}

