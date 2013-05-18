package com.fluidbot.component.debug;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import com.fluidbot.bot.script.api.Area;
import com.fluidbot.bot.script.api.GroundItem;
import com.fluidbot.bot.script.api.GroundItem.ModelStackType;
import com.fluidbot.bot.script.api.Model;
import com.fluidbot.bot.script.api.Player;
import com.fluidbot.bot.script.api.Tile;


public class DebugGroundHulls extends Debugger {
	
	private Color color = new Color(255, 1, 1, 60);

	@Override
	public void draw(Graphics2D g) {
		Player player = getContext().players.getLocalPlayer();

		Tile loc = player.getLocation();
		for (GroundItem item : getContext().groundItems.getAll(new Area(new Tile(loc.getX() - 15, loc.getY() - 15), new Tile(loc.getX() + 15, loc.getX() + 15)))) {
			draw(g, item, color);
		}
	}
	
	public void draw(Graphics2D g, GroundItem item, Color color) {
		Model model = item.getModel(ModelStackType.TOP);

		if (model == null || !model.isValid()) return;
		
		g.setColor(color);
		Polygon p = item.hull();
		if (p != null) {
			g.fillPolygon(p);
		}
	}

}
