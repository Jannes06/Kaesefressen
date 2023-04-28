import GLOOP.*;
public class Loch{
    private GLZylinder loch;
    private Spielfeld feld;
    private double vX,vZ;
    private double breite, tiefe;

    public Loch() {
       loch = new GLZylinder(10,10,-10,50,1);
       loch.setzeFarbe(0,0,1);
       loch.drehe(90,0,0);

    }

    public void bewegeOben(){
       loch.verschiebe(0,0,-1);
    }

    public void bewegeUnten(){
        loch.verschiebe(0,0,1);
    }

    public void bewegeRechts(){
        loch.verschiebe(1,0,0);
    }
    public void bewegeLinks(){
        loch.verschiebe(-1,0,0);
    }

}
