import GLOOP.*;
public class Kugel {
    private GLKugel kugel;
    private Loch dasLoch;
    private Spielfeld feld;

    private double radius;
    private boolean istAktiv;
    private double vX, vZ;
    int richtung;

    double feldRandX, feldRandZ;
    public Kugel(Spielfeld pSpielfeld) {
        kugel = new GLKugel(10, 10, -10, 10);


    feld = pSpielfeld;
    feldRandX = feld.gibX();
    feldRandZ =feld.gibZ();
}
    public void bewege() {
     kugel.verschiebe(richtung,0,0);
        if (-feldRandX >kugel.gibZ()){
            richtung =-1;
            if (feldRandX <kugel.gibZ()){
                richtung =1;
        }
    }
}
