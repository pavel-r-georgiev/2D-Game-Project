package com.puffeh.rain.level;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.level.tile.Tile;

public class Level {
    
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
    
	public static Level spawn= new SpawnLevel("/levels/spawn.png");
	
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();

	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
		

	}

	protected void loadLevel(String path) {

	}
	

	protected void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
				}
			}
	}
		// Grass = 0xFF00FF00
		// Flower = 0xFFFFFF00
		// Rock = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x>= width|| y>=height)return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_spawn_floor)return Tile.spawn_floor;
		if (tiles[x + y * width] == Tile.col_spawn_grass)return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.col_spawn_dirt)return Tile.spawn_dirt;
		if (tiles[x + y * width] == Tile.col_spawn_flower)return Tile.spawn_flower;
		if (tiles[x + y * width] == Tile.col_spawn_hedge)return Tile.spawn_hedge;
		if (tiles[x + y * width] == Tile.col_spawn_rock)return Tile.spawn_rock;
		if (tiles[x + y * width] == Tile.col_spawn_wall)return Tile.spawn_wall;
		if (tiles[x + y * width] == Tile.col_spawn_water)return Tile.spawn_water;
		return Tile.voidTile;
	}
}
