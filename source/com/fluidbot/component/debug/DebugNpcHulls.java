package com.fluidbot.component.debug;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import com.fluidbot.bot.script.api.Actor;
import com.fluidbot.bot.script.api.Model;
import com.fluidbot.bot.script.api.Npc;


public class DebugNpcHulls extends Debugger {
	
	private Color color = new Color(255, 1, 1, 60);

	@Override
	public void draw(Graphics2D g) {
		for (Npc npc : context.npcs.getAll()) {
			draw(g, npc, color);
		}
	}
	
	public void draw(Graphics2D g, Actor actor, Color color) {
		Model model = actor.getModel();

		if (model == null || !model.isValid()) return;
		
		g.setColor(color);
		Polygon p = actor.hull();
		if (p != null) {
			g.fillPolygon(p);
		}
	}

}
