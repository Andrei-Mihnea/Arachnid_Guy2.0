package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.keyH = key;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player/AFK.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player/down1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/Player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Player/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Player/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Player/right3.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/Player/up3.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true) {

            if (keyH.up == true && keyH.left == true) {
                direction = "up";
                y -= speed - 1;
                x -= speed - 1;
            } else if (keyH.up == true && keyH.right == true) {
                direction = "up";
                y -= speed - 1;
                x += speed - 1;
            } else if (keyH.down == true && keyH.left == true) {
                direction = "down";
                y += speed - 1;
                x -= speed - 1;
            } else if (keyH.down == true && keyH.right == true) {
                direction = "down";
                y += speed - 1;
                x += speed - 1;
            } else if (keyH.up == true) {
                direction = "up";
                y -= speed;
            } else if (keyH.down == true) {
                direction = "down";
                y += speed;
            } else if (keyH.left == true) {
                direction = "left";
                x -= speed;
            } else if (keyH.right == true) {
                direction = "right";
                x += speed;
            }

            ++spriteCounter;
            if (spriteCounter > 6) {
                if (spriteNumb == 1) {
                    spriteNumb = 2;
                } else if (spriteNumb == 2) {
                    spriteNumb = 3;
                } else if (spriteNumb == 3) {
                    spriteNumb = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){

        //g2.setColor(Color.blue);

        //g2.fillRect(x,y,gp.TILE_SIZE,gp.TILE_SIZE);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNumb == 1) {
                    image = up1;
                }
                if(spriteNumb == 2) {
                    image = up2;
                }
                if(spriteNumb == 3) {
                    image = up3;
                }
                break;
            case "down":
                if(spriteNumb == 1) {
                    image = down1;
                }
                if(spriteNumb == 2) {
                    image = down2;
                }
                if(spriteNumb == 3) {
                    image = down3;
                }
                break;
            case "left":
                if(spriteNumb == 1) {
                    image = left1;
                }
                if(spriteNumb == 2) {
                    image = left2;
                }
                if(spriteNumb == 3) {
                    image = left3;
                }
                break;
            case"right":
                if(spriteNumb == 1) {
                    image = right1;
                }
                if(spriteNumb == 2) {
                    image = right2;
                }
                if(spriteNumb == 3) {
                    image = right3;
                }
                break;

        }
        g2.drawImage(image,x,y,gp.TILE_SIZE*2,gp.TILE_SIZE*2,null);
    }
}
