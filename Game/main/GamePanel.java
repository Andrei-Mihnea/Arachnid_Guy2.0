package main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Setari ecran
    final int ORIGINAL_TILE_SIZE = 16;//16x16 tile
    final int SCALE = 3;
    public int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;//48x48 tile
    final int MAX_SCREEN_COL = 16;
    final int MAX_SCREEN_ROW = 12;

    final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);

    int playerX = 100;

    final int FPS = 60;
    int playerY = 100;
    int playerSpeed = 4;




    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.magenta);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        double delta = 0;

        long lastTime = System.nanoTime();
        long timer = 0;
        long currentTime;
        int drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta +=(currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {

                update();
                repaint();
                delta--;
                ++drawCount;
            }
            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
