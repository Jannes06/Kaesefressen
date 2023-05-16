import GLOOP.*;
public class Loch{
    private GLZylinder loch;
    private Spielfeld feld;
    private double vX,vZ;
    private double breite, tiefe;
    double feldRandX,feldRandZ;
    double vergroesserungX = 1.03, vergroesserungY = 1.03;

    public Loch(Spielfeld pSpielfeld, double pRadius) {
       loch = new GLZylinder(10,10,-10,pRadius,1);
       loch.setzeFarbe(0,0,1);
       loch.drehe(90,0,0);
       feld = pSpielfeld;

       feldRandX = feld.gibX();
       feldRandZ = feld.gibZ();

    }

    public void bewegeOben(){
       loch.verschiebe(0,0,-1);
       if (-feldRandZ >loch.gibZ()){
           loch.verschiebe(0,0,1);
       }
    }

    public void bewegeUnten(){
        loch.verschiebe(0,0,1);
        if (feldRandZ <loch.gibZ()){
            loch.verschiebe(0,0,-1);
        }
    }

    public void bewegeRechts(){
        loch.verschiebe(1,0,0);
        if (feldRandX <loch.gibX()){
            loch.verschiebe(-1,0,0);
        }
    }
    public void bewegeLinks(){
        loch.verschiebe(-1,0,0);
        if (-feldRandX >loch.gibX()){
            loch.verschiebe(1,0,0);
        }
    }


    public double gibX(){
        return loch.gibX();


    }
    public double gibZ(){
        return loch.gibZ();


    }
          public void vergroessern(){
            double Y= vergroesserungY*0.987 ;
            double X= vergroesserungX*0.987;

              loch.skaliere(X,Y,1);

          }
}
