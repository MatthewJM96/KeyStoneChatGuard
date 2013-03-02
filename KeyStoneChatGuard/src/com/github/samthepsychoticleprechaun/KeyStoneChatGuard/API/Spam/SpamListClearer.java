package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.API.Spam;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.ConfigValues;

public class SpamListClearer extends BukkitRunnable {
	
	static KeyStoneChatGuard plugin = KeyStoneChatGuard.plugin;
	static int period = ConfigValues.spamchatperiod;
	
	public static void initiateSpamListClearer() {
		BukkitTask task = new SpamListClearer().runTaskTimer(plugin, period, period);
	}
	
	public void run() {
		
		SpamGuard.getRecentChatList().poll();
		
	}

}
