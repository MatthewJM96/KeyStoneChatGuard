package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.API.FoulLanguage;

import java.util.PriorityQueue;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.TimeParser;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.MySQL.ExecuteQuery;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.ConfigValues;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.Storage.SpamValues;

public class FoulLanguageGuard {
	
	KeyStoneChatGuard plugin = KeyStoneChatGuard.plugin;
	static boolean mysql = ConfigValues.usemysql;	
	static Logger log = KeyStoneChatGuard.log;
	private static PriorityQueue<Player> recentchatlist = new PriorityQueue<Player>();
	
	public static PriorityQueue<Player> getRecentChatList() {
		return recentchatlist;
	}
	
	
	
	
	/**
	 * Checks a player's offence count for spamming and returns the value
	 * 
	 * @param player
	 * @return boolean
	 */
	public static int checkOffenceCount(Player player) {
		
		String name = player.getName();
		int count = 0;
		
		if (mysql) {
			
			//RemovalRate is in milliseconds while the config value is in minutes - config value * 60 * 1000 = configvalue * 60000
			int removalRate = ConfigValues.foulcountremovalrate * 60000;
			count = Integer.parseInt(ExecuteQuery.getString("SELECT offenceCount FROM ks_spamlist WHERE playerName = '" + name + "'", 0));
			String latestCountRemoval = ExecuteQuery.getString("SELECT latestCountRemoval FROM ks_spamlist WHERE playerName = '" + name + "'", 0);
			
			int diff = TimeParser.timeDifferenceToCurrent(latestCountRemoval);
			
			if (diff > removalRate) {
				
				int totalDiff = (int) Math.floor(diff / removalRate);				
				count -= totalDiff;
				double remainder = diff % removalRate;				
				int leftOver;
				String newLatestRemoval = null;
				
				if (remainder != 0) {
					
					//Multiplied by 1000 to get time in seconds
					leftOver = (int) remainder * removalRate / 1000;
					
					newLatestRemoval = TimeParser.updateTime(leftOver, "seconds");
					
				}
				
				if (newLatestRemoval != null) {
				
				ExecuteQuery.executeQuery("INSERT INTO ks_spamlist(offenceCount, latestCountRemoval) VALUES(" + count + ", " + newLatestRemoval + ") WHERE playerName = '" + name + "'");
				
				} else {
					
					log.info("Error updating offence count!");
					
				}
				
			}
			
		} else {
			
			//RemovalRate is in milliseconds while the config value is in minutes - config value * 60 * 1000 = configvalue * 60000
			int removalRate = ConfigValues.foulcountremovalrate * 60000;
			int index;
			index = SpamValues.playerName.indexOf(name);
			count = SpamValues.offenceCount.get(index);
			String latestCountRemoval = SpamValues.latestRemovalCount.get(index);
			
			int diff = TimeParser.timeDifferenceToCurrent(latestCountRemoval);
			
			if (diff > removalRate) {
				
				int totalDiff = (int) Math.floor(diff / removalRate);				
				count -= totalDiff;
				double remainder = diff % removalRate;				
				int leftOver;
				String newLatestRemoval = null;
				
				if (remainder != 0) {
					
					//Multiplied by 1000 to get time in seconds
					leftOver = (int) remainder * removalRate / 1000;
					
					newLatestRemoval = TimeParser.updateTime(leftOver, "seconds");
					
				}
				
				if (newLatestRemoval != null) {
					
				SpamValues.latestRemovalCount.set(index, newLatestRemoval);
				
				} else {
					
					log.info("Error updating offence count!");
					
				}
				
			}
			
		}
		
		return count;
		
	}
	
	/**
	 * Gets the punishment due to the player for their spamming indiscretions
	 * 
	 * @param player
	 * @return String
	 */
	public static String getPunishment(Player player) {
		
		int count = checkOffenceCount(player);
		
		for (int x = (ConfigValues.spamcounttopunish.size() - 1); x >= 0; x--) {
			
			String s = "nothing";
			
			if (count > ConfigValues.spamcounttopunish.get(x)) {
				
				s = ConfigValues.spampunsihmentorder.get(x);
				return s;
				
			} else {
				
				if (x == 0) {
					return s;
				}
				
			}
			
		}
		
		return "nothing";
		
	}

}
