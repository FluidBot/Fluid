package com.fluidbot.bot.ui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.fluidbot.Configuration;
import com.fluidbot.bot.Bot;


/**
 * Wraps a jpanel with the enclosed bot and applet instances
 * @author tommo
 *
 */
public class BotPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Bot bot;
	private BotLogger logger;
	private BotLoadingIcon loading;
	
	public BotPanel(Bot bot) {
		this.bot = bot;
		setBorder(null);
		setLayout(new BorderLayout());
		logger = new BotLogger();
		loading = new BotLoadingIcon();
		loading.setPreferredSize(new Dimension(Configuration.BOT_APPLET_WIDTH, Configuration.BOT_APPLET_HEIGHT));
		add(loading, BorderLayout.CENTER);
		add(logger.createScrollPane(), BorderLayout.SOUTH);
	}
	
	public void loadApplet() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				remove(loading);
				bot.getApplet().setPreferredSize(new Dimension(Configuration.BOT_APPLET_WIDTH, Configuration.BOT_APPLET_HEIGHT));
				add(bot.getApplet(), BorderLayout.CENTER);
		        try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        validate();
			}
		});
	}
	
	public Bot getBot() {
		return bot;
	}
	
	public Applet getApplet() {
		return bot.getApplet();
	}
	
	public BotLogger getLogger() {
		return logger;
	}

}
