package com.puffeh.rain.level.tile;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;

public class VoidTIle extends Tile {

	public VoidTIle(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);
	}
}
