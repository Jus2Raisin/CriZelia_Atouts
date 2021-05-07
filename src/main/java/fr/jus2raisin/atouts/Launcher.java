package fr.jus2raisin.atouts;

import fr.jus2raisin.atouts.commands.ATCommands;
import fr.jus2raisin.atouts.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Launcher {

    public Launcher(Main main)
    {
        PluginManager pm = Bukkit.getPluginManager();
        main.getCommand("atouts").setExecutor(new ATCommands(main));
        pm.registerEvents(new PlayerListener(main), main);
    }
}
