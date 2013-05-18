package com.fluidbot.bot.script.api.tools;

import com.fluidbot.bot.script.ScriptContext;

/**
 * Client settings
 * @author tommo
 *
 */
public class Settings {
	
	public static final int TOGGLE_RUN = 173;
	
	private ScriptContext ctx;
	
	public Settings(ScriptContext ctx) {
		this.ctx = ctx;
	}
	
	/**
	 * Returns the setting value at the given index
	 * @param index The index in the settings array
	 * @return The value in the array at the index, or -1 if something went wrong
	 */
	public int get(int index) {
		int[] settings = ctx.getClient().getWidgetSettings();
		if (settings != null && index < settings.length) {
			return settings[index];
		}
		return -1;
	}

}
