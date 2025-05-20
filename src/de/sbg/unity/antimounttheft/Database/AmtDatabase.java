package de.sbg.unity.antimounttheft.Database;

import de.sbg.unity.antimounttheft.AntiMountTheft;
import de.sbg.unity.antimounttheft.amtConsole;
import net.risingworld.api.database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import net.risingworld.api.Timer;

public class AmtDatabase {

    public final TabNpc npc;
    public final TabMembers member;

    private final Database database;
    private final Connection connection;
    private Timer saveTimer;
    private final amtConsole Console;
    private final AntiMountTheft plugin;

    public AmtDatabase(AntiMountTheft plugin, amtConsole Console) {
        this.plugin = plugin;
        this.Console = Console;
        this.database = plugin.getSQLiteConnection(plugin.getPath() + "/Database/AMT.db");
        connection = database.getConnection();
        npc = new TabNpc();
        member = new TabMembers();
    }

    public void createDatabse() {

        database.execute("PRAGMA foreign_keys = ON");

        database.execute("CREATE TABLE IF NOT EXISTS Npc ("
                + "ID INTEGER PRIMARY KEY NOT NULL, " //AUTOINCREMENT
                + "UID BIGINT, "
                + "Name TXT, "
                + "Owner TXT, "
                + "Spezial INTEGER, "
                + "More TXT "
                + "); ");
        database.execute("CREATE TABLE IF NOT EXISTS Members ("
                + "ID INTEGER PRIMARY KEY NOT NULL, " //AUTOINCREMENT
                + "NpcID INTEGER, "
                + "MemberUID TXT, "
                + "More TXT "
                + "); ");
    }

    public void saveAll() throws  SQLException {
        npc.save();
        member.save();
        Console.sendInfo("SaveTimer", "Save all to databse!");
    }

    public void laodAll() throws  SQLException {
        npc.load();
        member.load();
        Console.sendInfo("SaveTimer", "Load all from databse!");
    }

    public void startSaveTimer() {
        saveTimer = new Timer(plugin.Config.DatabaseSaveTime * 60, 0, -1, () -> {
            try {
            saveAll();
            } catch (SQLException ex) {
                //TODO MSG
            }
        });
        Console.sendInfo("SaveTimer", "Start timer!");
    }

    public void stopSaveTimer() {
        saveTimer.kill();
        Console.sendInfo("SaveTimer", "Stop timer!");
    }

    public Timer getSaveTimer() {
        return saveTimer;
    }

    public Connection getConnection() {
        return connection;
    }

    public class TabNpc {

        public void load() {

        }

        public void save() {

        }

        public void add() {

        }

        public void remove() {

        }
    }

    public class TabMembers {

        public void load() {

        }
        
        public void save() {
            
        }
        
        public void add() {
            
        }
        
        public void remove() {
            
        }
    }

}
