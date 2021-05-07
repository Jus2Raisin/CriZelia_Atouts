package fr.jus2raisin.atouts.utils;

import fr.jus2raisin.atouts.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AtoutsUtils
{

    public static void giveAtout(final Player player, String atouts)
    {
        if(atouts.equalsIgnoreCase("force"))
        {
            if(FileUtils.getDurability(player, atouts) > 0)
            {
                FileUtils.force.replace(player.getUniqueId(), FileUtils.getDurability(player, atouts)-1);
                player.playSound(player.getLocation(), Sound.DRINK, 2.0F, 2.0F);
                giveEffect(player, new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
            }
        } else if(atouts.equalsIgnoreCase("rapidite")) {
            if(FileUtils.getDurability(player, atouts) > 0)
            {
                FileUtils.rapidite.replace(player.getUniqueId(), FileUtils.getDurability(player, atouts)-1);
                player.playSound(player.getLocation(), Sound.DRINK, 2.0F, 2.0F);
                giveEffect(player, new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            }
        } else if(atouts.equalsIgnoreCase("Resistance au Feu")) {
            if(FileUtils.getDurability(player, atouts) > 0)
            {
                FileUtils.feu.replace(player.getUniqueId(), FileUtils.getDurability(player, atouts)-1);
                player.playSound(player.getLocation(), Sound.DRINK, 2.0F, 2.0F);
                giveEffect(player, new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
            }
        } else if(atouts.equalsIgnoreCase("haste")) {
            if(FileUtils.getDurability(player, atouts) > 0)
            {
                FileUtils.haste.replace(player.getUniqueId(), FileUtils.getDurability(player, atouts)-1);
                player.playSound(player.getLocation(), Sound.DRINK, 2.0F, 2.0F);
                giveEffect(player, new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1));
            }
        } else if(atouts.equalsIgnoreCase("resistance")) {
            if(FileUtils.getDurability(player, atouts) > 0)
            {
                FileUtils.resistance.replace(player.getUniqueId(), FileUtils.getDurability(player, atouts)-1);
                player.playSound(player.getLocation(), Sound.DRINK, 2.0F, 2.0F);
                giveEffect(player, new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
            }
        }




    }

    public static void giveEffect(final Player player, PotionEffect potion)
    {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run()
            {
              player.sendMessage("§d§lAtouts §f§l» §aVous venez de reçevoir un Atout.");
              player.addPotionEffect(potion);
            }
        }, 20L);
    }



}
