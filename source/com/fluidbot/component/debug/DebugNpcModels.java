package com.fluidbot.component.debug;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import com.fluidbot.bot.script.api.Actor;
import com.fluidbot.bot.script.api.Model;
import com.fluidbot.bot.script.api.Npc;
import com.fluidbot.bot.util.Perspective;
import com.fluidbot.bot.util.Vec3;


public class DebugNpcModels extends Debugger {
	
	private Color color = new Color(1, 200, 1, 85);

	@Override
	public void draw(Graphics2D g) {
		for (Npc npc : context.npcs.getAll()) {
			drawModel(g, npc, color);
		}
	}
	
	public void drawModel(Graphics2D graphics, Actor actor, Color color) {
		Model model = actor.getModel();

		if (model == null || !model.isValid()) return;
		Vec3[][] vectors = model.getVectors();

		graphics.setColor(color);

		int gx = actor.getLocation().getGx();
		int gy = actor.getLocation().getGy();
		for (Vec3[] points : vectors) {
			Vec3 pa = points[0];
			Vec3 pb = points[1];
			Vec3 pc = points[2];
			
			Point a = Perspective.trans_tile_cam(getContext().getClient(), gx + (int) pa.x, gy + (int) pc.x, 0 - (int) pb.x);
			Point b = Perspective.trans_tile_cam(getContext().getClient(), gx + (int) pa.y, gy + (int) pc.y, 0 - (int) pb.y);
			Point c = Perspective.trans_tile_cam(getContext().getClient(), gx + (int) pa.z, gy + (int) pc.z, 0 - (int) pb.z);
			
			if (Perspective.on_screen(a) && Perspective.on_screen(b) && Perspective.on_screen(c)) {
				graphics.drawPolygon(new Polygon(new int[] {
						a.x, b.x, c.x
				}, new int[] {
						a.y, b.y, c.y
				}, 3));
			}
		}
	}

}
