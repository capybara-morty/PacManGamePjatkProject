import javax.swing.*;

public class Ghost{
    ImageIcon redghost = new ImageIcon("PNGs/redGhost.png");
    ImageIcon purpleghost = new ImageIcon("PNGs/purpleGhost.png");
    ImageIcon blueghost = new ImageIcon("PNGs/BlueGhost.png");
    ImageIcon pinkboost = new ImageIcon("PNGs/PinkBoost.png");
    ImageIcon redboost = new ImageIcon("PNGs/RedBoost.png");
    ImageIcon greenboost = new ImageIcon("PNGs/GreaanBoost.png");
    ImageIcon ghostTypee;
    ImageIcon boostType;
    int boost;
    int locationX;
    int locationY;
    int directionX;
    int directionY;
    boolean eatable;
    boolean boostcharge;

    public Ghost(ImageIcon ghostType, ImageIcon boosttype, int boost){
        this.ghostTypee = ghostType;
        this.boostType = boosttype;
        this.boost = boost;
        this.locationX = -1;
        this.locationY = -1;
        this.directionX = 0;
        this.directionY = 0;
        this.eatable = false;
        boostcharge = false;
    }

    public Ghost createNewGhost(String ghostType){
        Ghost  ghostToRet = null;
        if (ghostType.equals("red")){
            ghostToRet = new Ghost(redghost, redboost, 1);
        } else if (ghostType.equals("blue")) {
            ghostToRet = new Ghost(blueghost, greenboost, 2);
        } else if (ghostType.equals("purple")) {
            ghostToRet = new Ghost(purpleghost, pinkboost, 3);
        }
        return ghostToRet;
    }

    public ImageIcon getBoostType() {
        return boostType;
    }
    public ImageIcon getGhostType(){
        return ghostTypee;
    }

    public int getBoost() {
        return boost;
    }
    public void findClosest(ImageIcon[][] mtx){
        int destx = 0;
        int desty = 0;
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[1].length; j++) {
                if(mtx[i][j].equals(new ImageIcon("PNGs/Screenshot 2023-02-04 180901.png"))){
                    destx = i;
                    desty = j;
                }
            }
        }
        if(desty > 0 && destx > 0){
            if(locationX - destx > locationY - desty){
                directionX = -1;
                directionY = 0;
            } else if (locationX - destx < locationY - desty) {
                directionX = 0;
                directionY = -1;
            }
        } else if (desty < 0 && destx < 0) {
            if(locationX - destx < locationY - desty){
                directionX = -1;
                directionY = 0;
            } else if (locationX - destx > locationY - desty) {
                directionX = 0;
                directionY = -1;
            }
        } else if (desty > 0 && destx < 0) {
            if(locationX - destx > locationY - desty) {
                directionX = -1;
                directionY = 0;
            } else if (locationX - destx > locationY - desty) {
                directionX = 0;
                directionY = -1;
            }
        } else if (desty < 0 && destx > 0) {
            if (locationX - destx > locationY - desty) {
                directionX = 0;
                directionY = -1;
            }else if(locationX - destx > locationY - desty) {
                directionX = -1;
                directionY = 0;
            }
        } 
    }
}
