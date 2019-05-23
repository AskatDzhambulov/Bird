package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;         //РИСОВАНИЯ ИЗОБРОЖЕНИЯ
	Backround bgr;             //ЗАДНИЙ ФОН
	Bird bird;                 //ПТИЦА
	Obstacles obstacles;       //ПРИПЯТСВИЯ
	boolean gameOver;          //ЭЛЕМЕНТ ПОЗВОЛЯЮЩИЙ ПРОИГРЫВАТЬ
	Texture restartTexture;    //ЭЛЕМЕНТ ПОЗВОЛЯЮЩИЙ ПЕРЕЗАПУСКАТЬ ИГРУ

	@Override
	public void create () {                //НЕОБХОДИМЫЕ ЭЛЕМЕНТЫ
		batch = new SpriteBatch();
		bgr = new Backround();
		bird = new Bird();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture = new Texture("RestartBtn.png");   // ИЗОБРОЖЕНИЕ КНОПКИ "RESTART"
	}

	@Override
	public void render () {              //ОТРИСОВКА САМОЙ ИГРЫ
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);            // ЦВЕТ ФОНА
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bgr.render(batch);        // ОТРИСОВКА ФОНА
		obstacles.render(batch);     // ОТРИСОВКА ПРИПЯТСВИЙ
		if (!gameOver) {
			bird.render(batch);      // ОТРИСОВКА ПТИЦЫ
		}else
			batch.draw(restartTexture,200,200);   // ОТРИСОКА КНОПКИ "RESTART"  И КООРДИНАТЫ
		batch.end();
	}

	public void update() {    // МЕТОД ВЫПОЛНЯЮЩИЙ МАТЕМАТИЧЕСКИЙ ПОДСЧЕТ
		bgr.update();           // ПОДСЧЕТ ФОНА
		bird.update();          // ПОДСЧЕТ ПТИЦЫ
		obstacles.update();     // ПОДСЧЕТ ПРИПЯТСВИЙ
		for (int i = 0; i <obstacles.obs.length ; i++) {
			if (bird.posit.x>obstacles.obs[i].posit.x && bird.posit.x < obstacles.obs[i].posit.x+50){
				if(!obstacles.obs[i].emptySpace.contains(bird.posit)){
					gameOver = true;
				}
			}

		}
		if (bird.posit.y < 0 || bird.posit.y > 600) {    // ПТИЦА ПРОИГРЫВЕТ
			gameOver = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)&& gameOver){   // С ПОМОЩЬЮ КЛАВИШИ "enter" ПОСЛЕ ПРОИШРЫША ПЕРЕЗАПУСКАЕТСЯ
			recreate();
		}
	}

	@Override
	public void dispose () {    // МЕТОД ЗАГРУЖАЮЩИЙ ВСЕ НЕОБХОДИМЫЕ ДАННЫЕ
		batch.dispose();
	}
	public void recreate(){  // МЕТОД ПЕРЕЗАПУСКА ПОСЛЕ ПРОИГРЫША
		bird.recreate();
		obstacles.recreate();
		gameOver = false;
	}
}
