import GLOOP.*;
public class Spielfeld{
    private GLQuader untergrund, seiteHinten, seiteVorne, seiteLinks, seiteRechts;
    private double breite, tiefe;

    public Spielfeld(double pBreite, double pTiefe){
        breite = pBreite;
        tiefe = pTiefe;
        untergrund = new GLQuader(0,0,0, breite,20,tiefe);
        untergrund.setzeTextur("src/img/Tisch.png");
        seiteHinten = new GLQuader(0,5,-tiefe/2,breite,15,10);
        seiteVorne = new GLQuader(0,5,tiefe/2,breite,15,10);
        seiteLinks = new GLQuader(-breite/2,5,0,10,15,tiefe);
        seiteRechts = new GLQuader(breite/2,5,0,10,15,tiefe);

        seiteRechts.setzeTextur("src/img/img.png");
        seiteLinks.setzeTextur("src/img/img.png");
        seiteHinten.setzeTextur("src/img/img.png");
        seiteVorne.setzeTextur("src/img/img.png");



    }



    public double gibX(){
       return breite/2;


    }
    public double gibZ(){
        return tiefe/2;


    }
}
