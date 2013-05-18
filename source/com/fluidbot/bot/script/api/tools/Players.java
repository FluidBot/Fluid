package com.fluidbot.bot.script.api.tools;

import java.util.ArrayList;
import java.util.List;

import com.fluidbot.bot.script.ScriptContext;
import com.fluidbot.bot.script.api.Player;
import com.fluidbot.bot.util.Filter;
import com.fluidbot.insertion.IPlayer;


/**
 * Player methods
 * @author tommo
 *
 */
public class Players {
	
	private ScriptContext ctx;

	public Players(ScriptContext ctx) {
		this.ctx = ctx;
	}
	
	/**
	 * @return The list of nearby local players
	 */
	public List<Player> getAll() {
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < ctx.getClient().getPlayers().length; i++) {
			if (ctx.getClient().getPlayers()[i] != null) {
				players.add(new Player(ctx, ctx.getClient().getPlayers()[i]));
			}
		}
		return players;
	}
	
	/**
	 * Gets a filtered list of players.
	 * @param filter The filter.
	 * @return The players.
	 */
	public List<Player> getPlayers(Filter<Player> filter) {
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < ctx.getClient().getPlayers().length; i++) {
			IPlayer player = ctx.getClient().getPlayers()[i];
			
			if (player != null) {
				Player rsplayer = new Player(ctx, ctx.getClient().getPlayers()[i]);
				
				if (filter.accept(rsplayer)) {
					players.add(rsplayer);
				}
			}
		}
		return players;
	}
	
	/**
	 * @return The local player instance
	 */
	public Player getLocalPlayer() {
		return new Player(ctx, ctx.getClient().getLocalPlayer());
	}

}
