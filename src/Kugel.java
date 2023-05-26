import GLOOP.*;
public class Kugel {
    private GLKugel kugel, kugelTarnung;
    private Loch dasLoch;
    private Spielfeld feld;

    double radius;
    private boolean istAktiv;
    boolean kugelTot = false;
    private double vX, vZ;
    double richtungX = Math.random() * 4 - 2;
    double richtungZ = Math.random() * 4 - 2;

    double feldRandX, feldRandZ;
    int gesammelteKugel;
    double kugelFarbe = Math.random()*10-4;
    int kugeFarbeneu = (int)kugelFarbe;

    double kugelRadius = Math.random()*30+11;
    double kugelhoehe = kugelRadius+10;

    boolean kugelaktiviert = false;
    public Kugel(Spielfeld pSpielfeld, Loch pLoch, double lochRadius) {
        double posX = Math.random()*30;
        double posZ = -Math.random()*30;
        kugel = new GLKugel(posX, kugelhoehe, posZ, kugelRadius-2);
        kugelTarnung = new GLKugel(posX, kugelhoehe, posZ, kugelRadius-1);

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
        if (kugelTot == false) {
            kugel.verschiebe(richtungX, 0, richtungZ);
            kugelTarnung.verschiebe(richtungX, 0, richtungZ);

            kugel.drehe(richtungX, 1, richtungZ);
            kugelTarnung.drehe(richtungX, 1, richtungZ);
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
            if ( kugelaktiviert == false ){
              if (kugelRadius < radius){
                  kugelTarnung.setzeSichtbarkeit(false);
                  kugelaktiviert =true;
              }
            }
        }
    }
      public void fallen(){
        if (kugelTot == true) {
            if (kugel.gibY() >  kugelhoehe+10) {
                kugel.verschiebe(0, -2, 0);
                Sys.warte(1);
            }
        }
    }
    public void getroffen(double pradius) {
        radius = pradius;
        gesammelteKugel = 0;
        if ((kugel.gibX() > dasLoch.gibX() - radius) && (kugel.gibX() < dasLoch.gibX() + radius) && (kugel.gibZ() > dasLoch.gibZ() - radius) && (kugel.gibZ() < dasLoch.gibZ() + radius) && (kugel.gibY() <1000) && (kugelRadius<radius)) {
            gesammelteKugel = 1;
            dasLoch.vergroessern();
            kugel.verschiebe(0,2000,0);
             kugelTot = true;
        }
    }
        public int getroffenZahl() {
                return gesammelteKugel;


        }
}

