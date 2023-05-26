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
    int kugelanzahl = 80;
    double lochRadius  = 17;

    double verkleinerungsFaktor = 1.05;

    public Kugelszene() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        tastatur = new GLTastatur();

        kugelAnzeige = new GLTafel(-300,400,0,100,100);
        kugelAnzeige.setzeKamerafixierung(true);

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
            if (gesammelteKugeln == kugelanzahl || tastatur.enter()){
                spielBeenden();
            }
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
                if (kugeln[e].getroffenZahl()>0){
                    lochRadius = lochRadius + kugeln[e].getroffenZahl()/ verkleinerungsFaktor ;
                    verkleinerungsFaktor = verkleinerungsFaktor+0.08;
                }
                kugeln[e].getroffen(lochRadius);
            }
            int kugelUebrig = kugelanzahl- gesammelteKugeln;
            kugelAnzeige.setzeText(" Uebrige Kugeln:  "+kugelUebrig,20);
            if (kugelUebrig == 0 ) {
                kugelAnzeige.setzeText(" Gewonnen ;)  ",20);

            }
        }
    }
    public void spielBeenden (){
        while (0==0){
        for (int e = 0; e < kugelanzahl; e++) {
            kugeln[e].fallen();
        }
        }
        }
}

