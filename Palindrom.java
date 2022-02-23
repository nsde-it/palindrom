// Palindrom-Erkennung
import basis.*;

public class Palindrom {
    private Fenster fenster;
    private Knopf kEnde;
    private TextFeld tEingabe, tAusgabe, richtigFalsch;
    private BeschriftungsFeld bTitel;
    private String text, ursprungsText, textErkennung, ursprungsTextErkennung;
   
    
    public Palindrom() {
        fenster = new Fenster("Palindrom", 400, 200);
        bTitel = new BeschriftungsFeld("Palindrom",150,40,100,30);
        bTitel.setzeSchriftGroesse(20);
        tEingabe = new TextFeld(50, 90, 300, 20);
        tAusgabe = new TextFeld(50, 120, 300, 20);
        tAusgabe.setzeBenutzbar(false);
        kEnde = new Knopf("Ende", 50, 150, 100, 30);
        tEingabe.setzeText("Ella rüffelte Detlef für alle");
        richtigFalsch = new TextFeld(240, 150, 110, 30);
        richtigFalsch.setzeBenutzbar(false);
        
        fuehreAus();
        
    } //Master
    
    public void fuehreAus() {
        
        while (!kEnde.wurdeGedrueckt()) {
            Hilfe.kurzePause();
            
            if (tEingabe.textWurdeGeaendert()) {
            //Implementiere hier den Code, der den Text einliest,
            //mit der passenden Methode umdreht und ausgibt
                bearbeitetAusgabe();
                
            }
        }
        fenster.gibFrei();
    } //fuehreAus
    
     private void bearbeitetAusgabe() {
        ursprungsText = tEingabe.text();
         
        if (ursprungsText.equals("")) { //wenn es nix umzudrehen gibt
            return; //direkt aufhören
        }
        //Implementiere hier den Code, der den String umdreht.
        
        text = "";
        
        for (int i = ursprungsText.length()-1; i >= 0; i += (-1))
        {
            text = text + ursprungsText.charAt(i);
        }
        
        tAusgabe.setzeText(text);
        
        textErkennung           = text.         toLowerCase().replace("!", "").replace("?", "").replace(".", "").replace(",", "").replace(":", "").replace("„", "").replace("“", "").replace("-", "").replace(";", "").replace("(", "").replace(")", "").replace(" ", "");
        ursprungsTextErkennung  = ursprungsText.toLowerCase().replace("!", "").replace("?", "").replace(".", "").replace(",", "").replace(":", "").replace("„", "").replace("“", "").replace("-", "").replace(";", "").replace("(", "").replace(")", "").replace(" ", "");
        
        if (text.equals(ursprungsText) && !ursprungsText.equals("")) {
            richtigFalsch.setzeText("Palindrom: Perfekt");
        }
        else if (textErkennung.equals(ursprungsTextErkennung) && !ursprungsText.equals("")) {
            richtigFalsch.setzeText("Palindrom: Richtig");
        }   
        else
        {
            richtigFalsch.setzeText("Palindrom: Falsch");
        }
    }
    
} //bearbeitetAusgabe
