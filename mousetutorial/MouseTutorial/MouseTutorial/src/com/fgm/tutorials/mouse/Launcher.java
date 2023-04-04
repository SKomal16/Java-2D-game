package com.fgm.tutorials.mouse;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width = 400;
		cfg.height = 350;
		cfg.x = 200;
		cfg. y = 100;
		new LwjglApplication(new MouseTutorial(), cfg);
	}
	
}
