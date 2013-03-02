package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.Storage.SpamValues;

public class SaveYaml {
	
	private static Logger log = KeyStoneChatGuard.log;
	
	/**
	 * Saves all files in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveYamls() {
		
		saveConfig();		
		saveSpam();		
		saveFoulLanguage();
		
		return true;
		
	}
	
	/**
	 * Saves config FileConfiguration of KeyStoneChatGuard to "config.yml" in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveConfig() {
		
		File configFile = KeyStoneChatGuard.configFile;
		FileConfiguration config = KeyStoneChatGuard.config;
		
		try {
			config.save(configFile);			
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error while saving config file!");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Saves spam FileConfiguration of KeyStoneChatGuard to "spam.yml" in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveSpam() {
		
		File spamFile = KeyStoneChatGuard.spamFile;
		FileConfiguration spam = KeyStoneChatGuard.spam;
		
		for(int x = 0; x <= (SpamValues.playerName.size() -1); x++) {
			
			SetYamlValues.setSpamValues("id" + (x + 1) + ".playerName", SpamValues.playerName.get(x));
			SetYamlValues.setSpamValues("id" + (x + 1) + ".offenceCount", SpamValues.offenceCount.get(x));
			SetYamlValues.setSpamValues("id" + (x + 1) + ".latestRemovalCount", SpamValues.latestRemovalCount.get(x));
			
		}
		
		try {
			spam.save(spamFile);			
		} catch (FileNotFoundException e) {
			log.info("Spam file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error while saving spam file!");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	/**
	 * Saves foul language FileConfiguration of KeyStoneChatGuard to "foullanguage.yml" in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveFoulLanguage() {
		
		File spamFile = KeyStoneChatGuard.spamFile;
		FileConfiguration spam = KeyStoneChatGuard.spam;
		
		for(int x = 0; x <= (SpamValues.playerName.size() -1); x++) {
			
			SetYamlValues.setSpamValues("id" + (x + 1) + ".playerName", SpamValues.playerName.get(x));
			SetYamlValues.setSpamValues("id" + (x + 1) + ".offenceCount", SpamValues.offenceCount.get(x));
			SetYamlValues.setSpamValues("id" + (x + 1) + ".latestRemovalCount", SpamValues.latestRemovalCount.get(x));
			
		}
		
		try {
			spam.save(spamFile);			
		} catch (FileNotFoundException e) {
			log.info("Spam file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error while saving spam file!");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
}
