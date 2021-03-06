package com.fluidbot.bot.script.api.generic;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Represents a model-backed entity susceptible to having a generated convex hull
 * @author tommo
 *
 */
public interface Hullable {
	
	/**
	 * Generates a convex hull based on the backing model
	 * @return The convex {@link Polygon} hull
	 */
	public Polygon hull();
	
	/**
	 * Generates a clickable point within the hull
	 * @param polygon The convex polygon hull generated by <code>hull()</code>
	 * @return The Point representing the click pint
	 */
	public Point hullPoint(Polygon polygon);

}
