package com.fluidbot.bot.script;

import com.fluidbot.bot.Bot;
import com.fluidbot.bot.accounts.Account;
import com.fluidbot.bot.script.api.tools.Bank;
import com.fluidbot.bot.script.api.tools.Camera;
import com.fluidbot.bot.script.api.tools.Equipment;
import com.fluidbot.bot.script.api.tools.Game;
import com.fluidbot.bot.script.api.tools.GroundItems;
import com.fluidbot.bot.script.api.tools.Inventory;
import com.fluidbot.bot.script.api.tools.Keyboard;
import com.fluidbot.bot.script.api.tools.Menu;
import com.fluidbot.bot.script.api.tools.Mouse;
import com.fluidbot.bot.script.api.tools.Navigation;
import com.fluidbot.bot.script.api.tools.Npcs;
import com.fluidbot.bot.script.api.tools.Objects;
import com.fluidbot.bot.script.api.tools.Players;
import com.fluidbot.bot.script.api.tools.Settings;
import com.fluidbot.bot.script.api.tools.Skills;
import com.fluidbot.bot.script.api.tools.Widgets;
import com.fluidbot.bot.script.randevent.RandomEventPool;
import com.fluidbot.insertion.IClient;


/**
 * The context in which a script executes.
 * @author tommo
 *
 */
public class ScriptContext {
	
	/**
	 * The client instance linked to this script context
	 */
	private IClient client;
	
	/**
	 * The bot instance controlling this script
	 */
	private Bot bot;
	
	/**
	 * The account which is running this script
	 */
	private Account account;
	
	/**
	 * This script context's utility instances
	 */
	public Game game;
	public Mouse mouse;
	public Npcs npcs;
	public Players players;
	public Keyboard keyboard;
	public Camera camera;
	public Menu menu;
	public Inventory inventory;
	public Objects objects;
	public Bank bank;
	public Widgets widgets;
	public Navigation navigation;
	public GroundItems groundItems;
	public Skills skills;
	public Settings settings;
	public Equipment equipment;
	public RandomEventPool randomEvents;

	public ScriptContext(Bot bot, IClient client, Account account) {
		this.bot = bot;
		this.client = client;
		this.account = account;
		this.game = new Game(this);
		this.mouse = new Mouse(this);
		this.npcs = new Npcs(this);
		this.players = new Players(this);
		this.keyboard = new Keyboard(this);
		this.camera = new Camera(this);
		this.menu = new Menu(this);
		this.inventory = new Inventory(this);
		this.objects = new Objects(this);
		this.bank = new Bank(this);
		this.widgets = new Widgets(this);
		this.navigation = new Navigation(this);
		this.groundItems = new GroundItems(this);
		this.skills = new Skills(this);
		this.settings = new Settings(this);
		this.equipment = new Equipment(this);
	}
	
	/**
	 * @return The client instance belonging to this context
	 */
	public IClient getClient() {
		return client;
	}
	
	/**
	 * @return The bot instance
	 */
	public Bot getBot() {
		return bot;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
