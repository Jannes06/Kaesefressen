import GLOOP.*;
public class Kugel {
    private GLKugel kugel;
    private Loch dasLoch;
    private Spielfeld feld;

    private double radius;
    private boolean istAktiv;
    private double vX, vZ;
    double richtungX = Math.random() * 4 - 2;
    double richtungZ = Math.random() * 4 - 2;

    double feldRandX, feldRandZ;
    int gesammelteKugel;

    public Kugel(Spielfeld pSpielfeld, Loch pLoch, double lochRadius) {
        kugel = new GLKugel(Math.random()*30, 15, -Math.random()*30, 10);
        kugel.setzeFarbe(Math.random(), Math.random(), Math.random());
        kugel.setzeSelbstleuchten(Math.random(), Math.random(), Math.random());

        radius = lochRadius;
        dasLoch = pLoch;
        feld = pSpielfeld;
        feldRandX = feld.gibX();
        feldRandZ = feld.gibZ();
    }

    public void bewege() {
        kugel.verschiebe(richtungX, 0, richtungZ);
        if (-feldRandZ > kugel.gibZ()) {
            richtungZ = richtungZ * -1;
        }
        if (feldRandZ < kugel.gibZ()) {
            richtungZ = richtungZ * -1;
        }
        if (-feldRandX > kugel.gibX()) {
            richtungX = richtungX * -1;
        }
        if (feldRandX < kugel.gibX()) {
            richtungX = richtungX * -1;
        }

    }

    public void getroffen() {
        gesammelteKugel = 0;
        if ((kugel.gibX() > dasLoch.gibX() - radius) && (kugel.gibX() < dasLoch.gibX() + radius) && (kugel.gibZ() > dasLoch.gibZ() - radius) && (kugel.gibZ() < dasLoch.gibZ() + radius) && kugel.gibY() <5000) {
            gesammelteKugel = 1;
            radius =radius +1 ;
            dasLoch.vergroessern();
            kugel.verschiebe(-100000,5000,0);
        }

    }
        public int getroffenZahl() {
                return gesammelteKugel;


        }
}

