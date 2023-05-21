import GLOOP.*;
public class Kugel {
    private GLKugel kugel;
    private Loch dasLoch;
    private Spielfeld feld;

    double radius;
    private boolean istAktiv;
    private double vX, vZ;
    double richtungX = Math.random() * 4 - 2;
    double richtungZ = Math.random() * 4 - 2;

    double feldRandX, feldRandZ;
    int gesammelteKugel;
    double kugelFarbe = Math.random()*10-4;
    int kugeFarbeneu = (int)kugelFarbe;

    double kugelRadius = Math.random()*30+10;
    double kugelhoehe = kugelRadius+10;
    public Kugel(Spielfeld pSpielfeld, Loch pLoch, double lochRadius) {
        kugel = new GLKugel(Math.random()*30, kugelRadius, -Math.random()*30, kugelRadius);


        kugelTexturSetzung();

        radius = lochRadius;
        dasLoch = pLoch;
        feld = pSpielfeld;
        feldRandX = feld.gibX();
        feldRandZ = feld.gibZ();
    }
    public void kugelTexturSetzung(){

        if (kugeFarbeneu < 0 ){
            kugel.setzeTextur("src/img/KugelSchwarz8.png");

        }
        else {
            if (kugeFarbeneu == 1) {
                kugel.setzeTextur("src/img/KugelGelb9.png");
            }
            if (kugeFarbeneu == 2) {
                kugel.setzeTextur("src/img/KugelBlau10.png");
            }
            if (kugeFarbeneu == 3) {
                kugel.setzeTextur("src/img/KugelRot11.png");
            }
            if (kugeFarbeneu == 4) {
                kugel.setzeTextur("src/img/KugelLila12.png");
            }
            if (kugeFarbeneu == 5) {
                kugel.setzeTextur("src/img/KugelGruen14.png");
            }
            if (kugeFarbeneu == 0) {
                kugel.setzeTextur("src/img/KugelOrange13.png");
            }
        }
    }


    public void bewege() {
        kugel.verschiebe(richtungX, 0, richtungZ);
        kugel.drehe(richtungX,1,richtungZ);
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

    public void getroffen(double radius) {
        gesammelteKugel = 0;
        if ((kugel.gibX() > dasLoch.gibX() - radius) && (kugel.gibX() < dasLoch.gibX() + radius) && (kugel.gibZ() > dasLoch.gibZ() - radius) && (kugel.gibZ() < dasLoch.gibZ() + radius) && (kugel.gibY() <5000) && (kugelRadius<radius)) {
            gesammelteKugel = 1;
            dasLoch.vergroessern();
            kugel.verschiebe(-100000,5000,0);
        }
    }
        public int getroffenZahl() {
                return gesammelteKugel;


        }
}

