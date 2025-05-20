/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.sbg.unity.antimounttheft;

import de.sbg.unity.antimounttheft.Database.AmtDatabase;
import de.sbg.unity.configmanager.ConfigData;
import de.sbg.unity.configmanager.ConfigManager;
import java.io.IOException;
import net.risingworld.api.Plugin;

/**
 *
 * @author pott
 */
public class AntiMountTheft extends Plugin{
    
    public  amtConfig Config;
    private amtConsole Console;
    public AmtDatabase databse;
    
    
    @Override
    public void onEnable() {
        Console.sendInfo("Enabled");
        boolean loadConfig = false;
        try  {
            Config = new amtConfig();
            Config.iniConfig();
            loadConfig = true;
        } catch (IOException ex) {
            Console.sendErr("ini", "Can not load Config!");
        }
        if (loadConfig) {
            this.databse = new AmtDatabase(this, Console);
            
        }
    }

    @Override
    public void onDisable() {
        Console.sendInfo("Disabled");
    }

    public class amtConfig {
        
        public int Debug, DatabaseSaveTime;
        public boolean DatabaseSavePlayer;
        
        private final ConfigManager manager;
        private final ConfigData config;
        
        public amtConfig() throws IOException{
            manager = (ConfigManager)getPluginByName("ConfigManager");
            config = manager.newConfig(getDescription("name"), getPath());
        }
        
        public void iniConfig() throws IOException{
            config.addCommend("# AntiMountTheft-Config");
            config.addCommend("# Debug-Modus (0 = off; 1 = on)");
            config.addSetting("Debug", 0);
            config.CreateConfig();
            config.addEmptyLine();
            config.addCommend("# Database-Save-Time in minutes");
            config.addSetting("DatabaseSaveTime", 5);
            config.addEmptyLine();
            config.addCommend("# Database-Save at player disconnect");
            config.addSetting("DatabaseSavePlayer", true);
            
            
            Debug = Integer.parseInt(config.getSetting("Debug"));
        }
        
    }
    
}
