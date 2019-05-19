package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 posit;
    float vy;
    float gravity;

    public Bird() {                          // КООРДИНАТЫ ПТИЦЫ
        img = new Texture("bird1.png");      // ИЗОБРОЖЕНИЕ ПТИЦЫ
        posit = new Vector2(100,400);
        vy = 0;
        gravity = -0.7f;
    }
    public void render(SpriteBatch batch){   // ОТРИСОВКА ПТИЦЫ
        batch.draw(img,posit.x,posit.y);
    }
    public void update(){                        // ПОДСЧЕТ
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {   // С ПОМОЩИ КЛАВИШИ "space" ВЗЛЕТАЕТ
            vy = 8;
        }
        vy += gravity;
        posit.y +=vy;
    }
    public void recreate() {     // ПЕРЕЗАПУСК ПОСЛЕ ПРОИГРЫША
        posit = new Vector2(100,400);
        vy = 0;
    }
}