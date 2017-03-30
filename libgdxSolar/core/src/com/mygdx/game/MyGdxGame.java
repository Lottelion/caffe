package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	boolean canMove = true;
	Planet[] planet = new Planet[4];
	double time[] = new double[4];
	@Override
	public void create () {
		for (int i = 0; i < 4; i++){
			planet[i] = new Planet();
			time[i] = 0.01 + i;
		}
		planet[0].setCoordinates(400, 400); //Солнце
		planet[1].setCoordinates(600, 600); //Планета без спутника
		planet[2].setCoordinates(900, 700); //Планета со спутником
		planet[3].setCoordinates(1000, 750); //Спутник

		planet[1].setRadius(130);
		planet[2].setRadius(290);
		planet[3].setRadius(60);

		planet[1].setSpeed(0.06);
		planet[2].setSpeed(0.03);
		planet[3].setSpeed(0.20);

		planet[1].setPoint(400, 400);
		planet[2].setPoint(400, 400);

		batch = new SpriteBatch();
		img = new Texture("solar.jpg");

		for (int i = 0; i < 4; i++){
				planet[i].setRegion(img, 100 * i, 0, 98, 97);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			canMove = !canMove;
		}
		batch.begin();
		if (canMove) {
			for (int i = 0; i < 4; i++) {
				planet[3].setPoint(planet[2].getX(), planet[2].getY());
				time[i] = time[i] + planet[i].getSpeed();
				if (i != 0) {
					planet[i].move(time[i]);
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			batch.draw(planet[i].getRegion(), planet[i].getX(), planet[i].getY(), 50, 50);
		}
		batch.end();
	}
}
