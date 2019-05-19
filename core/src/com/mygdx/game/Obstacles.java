package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair {         // СТЕНА
        Vector2 posit;
        float speed;
        int offset;
        Rectangle emptySpace;

        public WallPair(Vector2 pos) {   // КООРДИНАТЫ СТЕНЫ
            posit = pos;
            speed = 2;           // CКОРОСТЬ ПОСЛЕДУЮЙЩИХ СТЕН
            offset = new Random().nextInt(180);    // CЛУЙНОЕ РАСПОЛОЖЕНИЕ СТЕН
            emptySpace = new Rectangle(posit.x,posit.y - offset + 300,50,betweenDis);  // ЭЛЕМЕНТ ПОЗВОЛЯЮЩИЙ ПРОИГРАТЬ
        }
        public void update() {       // ПОДСЧЕТ
            posit.x -= speed;
            if(posit.x <- 50) {
                posit.x = 800;
                offset = new Random().nextInt(180);
            }
            emptySpace.x = posit.x;
        }
    }
    static WallPair[] obs;
    Texture txt;
    int betweenDis; // ДИСТАНЦИЯ МЕЖДУ СТЕН

    public Obstacles() {
        txt = new Texture("wall.png");  // ИЗОБРОЖЕНИЕ СТЕН
        obs = new WallPair[4];     // КОЛИЧЕСТВО СТЕН
        betweenDis = 250;          // РАСТОЯНИЕ
        int startPosX = 400;       // НАЧАЛЬНЫЕ КООРДИНАТЫ СЬЕН
        for (int i = 0; i <obs.length ; i++) {
            obs[i] = new WallPair((new Vector2(startPosX,0)));
            startPosX += 220;
        }
    }
    public void render(SpriteBatch batch) {         // ОТРИСОВКА ПРИПЯТСВИЙ
        for (int i = 0; i <obs.length ; i++) {
            batch.draw(txt,obs[i].posit.x,obs[i].posit.y);
            batch.draw(txt,obs[i].posit.x,obs[i].posit.y + betweenDis + txt.getHeight() - obs[i].offset);   // ВЕРХНИЕ СТЕНЫ
        }
    }
    public void update(){                        // ПОДСЧЕТ
        for (int i = 0; i <obs.length ; i++) {
            obs[i].update();
        }
    }
    public void recreate(){         // ПЕРЕЗАПУСК ПОСЛЕ ПРОИГРЫША
        int startPosX = 400;
        for (int i = 0; i <obs.length ; i++) {
            obs[i] = new WallPair((new Vector2(startPosX,0)));
            startPosX += 220;
        }

    }
}