package com.github.samthepsychoticleprechaun.KeyStoneChatGuard;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML.LoadYaml;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML.SaveYaml;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.MySQL.CreateTable;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.ConfigValues;

public class KeyStoneChatGuard extends JavaPlugin {
	
	public static KeyStoneChatGuard plugin;
	public static Logger log;
	
	public static File configFile;
	public static File spamFile;
	public static File foulLanguageFile;
	public static FileConfiguration config;
	public static FileConfiguration spam;
	public static FileConfiguration foulLanguage;
	
	@Override
	public void onEnable() {
		
		//Sets the plugin value for other classes
		plugin = this;
		
		//Gets the plugin's logger
		log = plugin.getLogger();
		
		//Creates and Loads necessary files
		spamFile = new File(getDataFolder(), "spam.yml");
		foulLanguageFile = new File(getDataFolder(), "foullanguage.yml");
		spam = new YamlConfiguration();
		foulLanguage = new YamlConfiguration();
		LoadYaml.loadYamls();
		
		//Creates necessary MySQL tables if MySQL is enabled
		if(ConfigValues.usemysql) {
			CreateTable.createTable("ks_spamlist", "playerName VARCHAR(16), offenceCount VARCHAR(3), latestCountRemoval VARCHAR(16)");
			CreateTable.createTable("ks_foullanglist", "playerName VARCHAR(16), offenceCount VARCHAR(3), latestCountRemoval VARCHAR(16)");
		}
		
		
	}
	
	@Override
	public void onDisable() {
		
		//Saves all changes to files while server was live
		SaveYaml.saveYamls();
		
	}
	
}
