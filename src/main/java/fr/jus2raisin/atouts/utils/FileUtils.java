package fr.jus2raisin.atouts.utils;

import fr.jus2raisin.atouts.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FileUtils
{
    public static Map<UUID, Integer> force = new HashMap<>();
    public static Map<UUID, Integer> rapidite = new HashMap<>();
    public static Map<UUID, Integer> feu = new HashMap<>();
    public static Map<UUID, Integer> resistance = new HashMap<>();
    public static Map<UUID, Integer> haste = new HashMap<>();

    public static void createProfil(final Player player) throws IOException, InvalidConfigurationException {
        File file = new File(Main.getInstance().getDataFolder(), player.getUniqueId()+".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        if(!file.exists())
        {
            yaml.set("force.durability", 0);
            force.put(player.getUniqueId(), 0);
            yaml.set("rapidite.durability", 0);
            rapidite.put(player.getUniqueId(), 0);
            yaml.set("feu.durability", 0);
            feu.put(player.getUniqueId(), 0);
            yaml.set("resistance.durability", 0);
            resistance.put(player.getUniqueId(), 0);
            yaml.set("haste.durability", 0);
            haste.put(player.getUniqueId(), 0);
            saveCustomYml(yaml, file);
        }
        else
        {
            yaml.load(file);
            force.put(player.getUniqueId(), yaml.getInt("force.durability"));
            rapidite.put(player.getUniqueId(), yaml.getInt("rapidite.durability"));
            feu.put(player.getUniqueId(), yaml.getInt("feu.durability"));
            resistance.put(player.getUniqueId(), yaml.getInt("resistance.durability"));
            haste.put(player.getUniqueId(), yaml.getInt("haste.durability"));
        }


    }

    public static Integer getDurability(final Player player, String atouts)
    {
        if(atouts.equalsIgnoreCase("force"))
        {
            return force.get(player.getUniqueId());
        } else if(atouts.equalsIgnoreCase("rapidite"))
        {
            return rapidite.get(player.getUniqueId());

        } else if(atouts.equalsIgnoreCase("Resistance au Feu"))
        {
            return feu.get(player.getUniqueId());

        }  else if(atouts.equalsIgnoreCase("haste"))
        {
            return haste.get(player.getUniqueId());

        }  else if(atouts.equalsIgnoreCase("Resistance"))
        {
            return resistance.get(player.getUniqueId());
        }

        return null;
    }

    public static String playerHasAtout(final Player player, String atouts)
    {
        if(atouts.equalsIgnoreCase("force"))
        {
            if(force.get(player.getUniqueId()) > 0)
            {
                return "§aAcheté §2§l✔";
            }
            else
            {
                return "§cNon-Acheté §4§l✖";
            }
        } else if(atouts.equalsIgnoreCase("Resistance au Feu")) {
            if(feu.get(player.getUniqueId()) > 0)
            {
                return "§aAcheté §2§l✔";
            }
            else
            {
                return "§cNon-Acheté §4§l✖";
            }
        } else if(atouts.equalsIgnoreCase("Resistance")) {
            if (resistance.get(player.getUniqueId()) > 0) {
                return "§aAcheté §2§l✔";
            } else {
                return "§cNon-Acheté §4§l✖";
            }
        } else if(atouts.equalsIgnoreCase("Rapidite")) {
            if (rapidite.get(player.getUniqueId()) > 0) {
                return "§aAcheté §2§l✔";
            } else {
                return "§cNon-Acheté §4§l✖";
            }
        } else if(atouts.equalsIgnoreCase("haste")) {
            if (haste.get(player.getUniqueId()) > 0) {
                return "§aAcheté §2§l✔";
            } else {
                return "§cNon-Acheté §4§l✖";
            }
        }


        return "§cNon-Acheté §4§l✖";
    }

    public static void saveProfil(final Player player)
    {
        File file = new File(Main.getInstance().getDataFolder(), player.getUniqueId()+".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        yaml.set("force.durability", getDurability(player, "force"));
        yaml.set("haste.durability", getDurability(player, "haste"));
        yaml.set("rapidite.durability", getDurability(player, "rapidite"));
        yaml.set("resistance.durability", getDurability(player, "resistance"));
        yaml.set("feu.durability", getDurability(player, "Resistance au Feu"));
        saveCustomYml(yaml, file);

    }

    public static void setAtouts(final Player player, String atouts, int durability)
    {
        if(atouts.equalsIgnoreCase("force"))
        {
            force.replace(player.getUniqueId(), (force.get(player.getUniqueId())+durability));
        } else if(atouts.equalsIgnoreCase("Resistance au Feu")) {
            feu.replace(player.getUniqueId(), (feu.get(player.getUniqueId())+durability));
        } else if(atouts.equalsIgnoreCase("haste")) {
            haste.replace(player.getUniqueId(), (haste.get(player.getUniqueId())+durability));
        } else if(atouts.equalsIgnoreCase("rapidite")) {
            rapidite.replace(player.getUniqueId(), (rapidite.get(player.getUniqueId())+durability));
        } else if(atouts.equalsIgnoreCase("Resistance")) {
            resistance.replace(player.getUniqueId(), (resistance.get(player.getUniqueId())+durability));
        }
    }


    private static void saveCustomYml(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
