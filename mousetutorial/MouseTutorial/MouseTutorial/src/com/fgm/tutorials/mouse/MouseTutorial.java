package com.fgm.tutorials.mouse;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MouseTutorial extends ApplicationAdapter {
	
	private Texture level1;
	
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	private SpriteBatch sb;
	private BitmapFont font;
	
	public static final int WIDTH = 256;
	public static final int HEIGHT = 224;
	
	private Vector3 screenCoordinates;
	private Vector3 worldCoordinates;
	
	public void create() {
		
		level1 = new Texture(Gdx.files.internal("res/level1.png"));
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, WIDTH, HEIGHT);
		
		sb = new SpriteBatch();
		
		font = new BitmapFont();
		font.setColor(0, 0, 0, 1);
		
		screenCoordinates = new Vector3();
		worldCoordinates = new Vector3();
		
	}
	
	public void render() {
		
		// get coordinates
		screenCoordinates.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		
		worldCoordinates.set(screenCoordinates);
		cam.unproject(worldCoordinates);
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		
		// handle input
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			cam.position.set(cam.position.x + 100 * dt, cam.position.y, 0);
			cam.update();
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			cam.position.set(cam.position.x - 100 * dt, cam.position.y, 0);
			cam.update();
		}
		
		// draw
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(level1, 0, 0);
		sb.end();
		
		sb.setProjectionMatrix(hudCam.combined);
		sb.begin();
		font.draw(sb, "screen coordinates", 10, HEIGHT - 10);
		font.draw(sb, (int) screenCoordinates.x + ", " + (int) screenCoordinates.y, 150, HEIGHT - 10);
		font.draw(sb, "world coordinates", 10, HEIGHT - 30);
		font.draw(sb, (int) worldCoordinates.x + ", " + (int) worldCoordinates.y, 150, HEIGHT - 30);
		sb.end();
		
		
	}
	
}









