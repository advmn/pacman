package Test2;



import java.awt.image.BufferedImage;

public class PacMan implements Runnable{

    private KeyHandler keyHandler;
    private MapaGry mapaGry;
    int scorePoints;
    private BufferedImage PMOup,
            PMOdown,
            PMOleft,
            PMOright,
            PMSup,
            PMSdown,
            PMSleft,
            PMSright;
    int wiersz;
    int kolumna;

    public PacMan(KeyHandler keyHandler, MapaGry mapaGry) {
        this.keyHandler = keyHandler;
        this.mapaGry = mapaGry;
        setDefoultPacMan();
    }

    private void setDefoultPacMan(){
        mapaGry.setValueAt(5, 1,1);
        wiersz = 1;
        kolumna = 1;
        scorePoints = 0;
    }

    private void uploadImages(){

    }

    public void update(){
        if(keyHandler.up == true && (int)(mapaGry.getValueAt(wiersz-1,kolumna))!=1){
            mapaGry.setValueAt(0,wiersz,kolumna);
            mapaGry.setValueAt(5,wiersz-1,kolumna);
            wiersz--;
        } else if(keyHandler.down == true && (int)(mapaGry.getValueAt(wiersz+1,kolumna))!=1){
            mapaGry.setValueAt(0,wiersz,kolumna);
            mapaGry.setValueAt(5,wiersz+1,kolumna);
            wiersz++;
        } else if(keyHandler.left == true && (int)(mapaGry.getValueAt(wiersz,kolumna-1))!=1){
            mapaGry.setValueAt(0,wiersz,kolumna);
            mapaGry.setValueAt(5,wiersz,kolumna-1);
            kolumna--;
        } else if(keyHandler.right == true && (int)(mapaGry.getValueAt(wiersz,kolumna+1))!=1){
            mapaGry.setValueAt(0,wiersz,kolumna);
            mapaGry.setValueAt(5,wiersz,kolumna+1);
            kolumna++;
        }
    }

    @Override
    public void run() {
        while(true){
            update();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}