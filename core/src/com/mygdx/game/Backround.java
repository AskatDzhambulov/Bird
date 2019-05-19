package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Backround {
    class BgrPicture{
        private Texture tx;    // ФОН
        private Vector2 pos;   // КООРДИНАТЫ


        public BgrPicture(Vector2 pos) {
            tx = new Texture("back.png");      // ИЗОБРОЖЕНИ ЗАДНЕГО ФОНА
            this.pos = pos;
        }
    }

    private  int speed;           // СКОРОСТЬ ДВИЖЕНИЯ ФОНА
    private BgrPicture[] backr;
    public Backround() {

        speed = 4;
        backr = new BgrPicture[2];
        backr[0]= new BgrPicture(new Vector2(0,0));
        backr[1]= new BgrPicture(new Vector2(800,0));
    }
    public void render(SpriteBatch batch) {
        for (int i = 0; i <backr.length ; i++) {
            batch.draw(backr[i].tx,backr[i].pos.x,backr[i].pos.y);   // ОТРИСОВКА ЗАДНЕГО ФОНА

        }
    }
    public void update(){                                // ПОДЧСЕТ
        for (int i = 0; i <backr.length ; i++) {
            backr[i].pos.x -= speed;
        }

        if(backr[0].pos.x <-800) {
            backr[0].pos.x = 0;
            backr[1].pos.x = 800;
        }

    }
}