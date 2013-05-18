package com.fluidbot;

import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.pushingpixels.substance.api.skin.SubstanceOfficeBlack2007LookAndFeel;
import com.fluidbot.bot.ui.BotErrorDialog;
import com.fluidbot.bot.ui.BotVersionChecker;
import com.fluidbot.bot.ui.BotWindow;
import com.fluidbot.bot.util.VSecruityManager;

public class Application {
	
	public static BotWindow window;

	public static void main(String[] args) {
		if(args.length == 1 && args[0].equals("-dev"))
			Configuration.OFFLINE = true;

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					/*
					 * Must disable the strict EDT checking for substance
					 * (almost must be set before the LAF is changed)
					 */
			       	System.setProperty("insubstantial.checkEDT", "false");
			       	System.setProperty("insubstantial.logEDT", "false");
					UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());
					JFrame.setDefaultLookAndFeelDecorated(true);
					JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			       		System.setSecurityManager(new VSecruityManager());
			       	
			       	Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
						@Override
						public void uncaughtException(final Thread t, final Throwable e) {
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									BotErrorDialog.show("Error in thread: " + t.getName(), e);
								}
							});
						}
			       	});
					
			       	Configuration.mkdirs();
			       	
					if(Configuration.OFFLINE) {
						window = new BotWindow();
						window.init(false);
					} else new BotVersionChecker();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}