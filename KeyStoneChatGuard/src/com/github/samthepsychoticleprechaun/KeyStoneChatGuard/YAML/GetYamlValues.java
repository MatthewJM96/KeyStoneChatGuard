package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.Storage.FoulLanguageValues;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.Storage.SpamValues;

public class GetYamlValues {
	
	public static boolean getSpamValues() {
		
		FileConfiguration spam = KeyStoneChatGuard.spam;
		Logger log = KeyStoneChatGuard.log;
		
		try {
			
			SpamValues.playercount = spam.getInt("playercount");
			
			for(int x = 1; x <= SpamValues.playercount; x++) {
				
				SpamValues.playerName.add(spam.getString("id" + x +".playerName"));
				SpamValues.offenceCount.add(spam.getInt("id" + x +".offenceCount"));
				SpamValues.latestRemovalCount.add(spam.getString("id" + x +".latestRemovalCount"));
				
			}
			
		} catch (Exception e) {
			log.info("Error getting string values!");
			e.printStackTrace();
			return false;			
		}
		
		return true;
		
	}
	
	public static boolean getFoulLanguageValues() {
		
		FileConfiguration spam = KeyStoneChatGuard.spam;
		Logger log = KeyStoneChatGuard.log;
		
		try {
			
			FoulLanguageValues.playercount = spam.getInt("playercount");
			
			for(int x = 1; x <= FoulLanguageValues.playercount; x++) {
				
				FoulLanguageValues.playerName.add(spam.getString("id" + x +".playerName"));
				FoulLanguageValues.offenceCount.add(spam.getInt("id" + x +".offenceCount"));
				FoulLanguageValues.latestRemovalCount.add(spam.getString("id" + x +".latestRemovalCount"));
				
			}
			
		} catch (Exception e) {
			log.info("Error getting string values!");
			e.printStackTrace();
			return false;			
		}
		
		return true;
		
	}

}
