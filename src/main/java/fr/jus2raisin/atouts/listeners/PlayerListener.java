package fr.jus2raisin.atouts.listeners;

import fr.jus2raisin.atouts.Main;
import fr.jus2raisin.atouts.utils.FileUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class PlayerListener implements Listener {

    private Main main;

    public PlayerListener(Main main) { this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws IOException, InvalidConfigurationException {
        FileUtils.createProfil(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        FileUtils.saveProfil(event.getPlayer());
    }

}



