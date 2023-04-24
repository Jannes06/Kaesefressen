import GLOOP.*;
public class Fischjagdt {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;

    private Box dieBox;
    private Fisch kugel1, kugel2, kugel3;

    public Fischjagdt() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Wolke.png");
        tastatur = new GLTastatur();

        Spielfeld spielfeld = new Spielfeld(1000, 1000);

        fuehreAus();
    }

    public void fuehreAus() {

    }
}

