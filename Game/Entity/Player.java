package Entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.keyH = key;

        setDefaultValues();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;

    }

    public void update(){
        if (keyH.up == true && keyH.left == true) {
            y -= speed-1;
            x -= speed-1;
        } else if (keyH.up == true && keyH.right == true) {
            y -= speed-1;
            x += speed-1;
        } else if (keyH.down == true && keyH.left == true) {
            y += speed-1;
            x -= speed-1;
        } else if (keyH.down == true && keyH.right == true) {
            y += speed-1;
            x += speed-1;
        } else if (keyH.up == true){
            y -= speed;
        } else if (keyH.down == true) {
            y += speed;
        } else if (keyH.left == true) {
            x -= speed;
        } else if (keyH.right == true) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.blue);

        g2.fillRect(x,y,gp.TILE_SIZE,gp.TILE_SIZE);
    }
}
