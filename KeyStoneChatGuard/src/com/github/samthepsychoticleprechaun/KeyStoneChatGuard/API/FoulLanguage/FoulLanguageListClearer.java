package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.API.FoulLanguage;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.ConfigValues;

public class FoulLanguageListClearer extends BukkitRunnable {
	
	static KeyStoneChatGuard plugin = KeyStoneChatGuard.plugin;
	static int period = ConfigValues.spamchatperiod;
	
	public static void initiateSpamListClearer() {
		BukkitTask task = new FoulLanguageListClearer().runTaskTimer(plugin, period, period);
	}
	
	public void run() {
		
		FoulLanguageGuard.getRecentChatList().poll();
		
	}

}
