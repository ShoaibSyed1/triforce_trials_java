package com.shoaib.triforcetrials;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.logging.Logger;

public class TriforceTrials extends ApplicationAdapter {
	public static Logger logger = Logger.getGlobal();

	private Scene scene;

	public TriforceTrials() {
		this.scene = new Scene();
	}

	@Override
	public void create () {
		this.scene.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.scene.update();
	}
	
	@Override
	public void dispose () {
	}
}
