package fr.jus2raisin.atouts.commands;

import fr.jus2raisin.atouts.Main;
import fr.jus2raisin.atouts.inventory.AtoutsInventory;
import fr.jus2raisin.atouts.utils.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ATCommands implements CommandExecutor
{
    private Main main;

    public ATCommands(Main main) { this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player)
        {
            final Player player = (Player) commandSender;
            if(strings.length == 0)
            {
                AtoutsInventory.ATOUTS.open(player);
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
                return true;
            } else if(strings.length <= 4) {
                if(player.hasPermission("atouts.*")) {
                    if(strings[0].equalsIgnoreCase("give"))
                    {
                        if(Bukkit.getPlayer(strings[1]) != null && Bukkit.getPlayer(strings[1]).isOnline())
                        {
                            final Player target = Bukkit.getPlayer(strings[1]);

                            if(NumberUtils.isNumber(strings[2]))
                            {
                                if(strings[3].equalsIgnoreCase("force"))
                                {
                                    target.sendMessage("§d§lAtouts §f§l» §7Vous venez de reçevoir §cForce §7avec §b"+Integer.parseInt(strings[2])+"§7usage(s).");
                                    FileUtils.setAtouts(target, "force", Integer.parseInt(strings[2]));
                                    return true;

                                } else if(strings[3].equalsIgnoreCase("rapidite")) {
                                    target.sendMessage("§d§lAtouts §f§l» §7Vous venez de reçevoir §9Rapidite §7avec §b"+Integer.parseInt(strings[2])+"§7usage(s).");
                                    FileUtils.setAtouts(target, "rapidite", Integer.parseInt(strings[2]));
                                    return true;

                                } else if(strings[3].equalsIgnoreCase("haste")) {
                                    target.sendMessage("§d§lAtouts §f§l» §7Vous venez de reçevoir §eHaste §7avec §b"+Integer.parseInt(strings[2])+"§7usage(s).");
                                    FileUtils.setAtouts(target, "haste", Integer.parseInt(strings[2]));
                                    return true;

                                } else if(strings[3].equalsIgnoreCase("resistance")) {
                                    target.sendMessage("§d§lAtouts §f§l» §7Vous venez de reçevoir §8Resistance §7avec §b"+Integer.parseInt(strings[2])+"§7usage(s).");
                                    FileUtils.setAtouts(target, "resistance", Integer.parseInt(strings[2]));
                                    return true;

                                } else if(strings[3].equalsIgnoreCase("Feu")) {
                                    target.sendMessage("§d§lAtouts §f§l» §7Vous venez de reçevoir §6Resistance au Feu §7avec §b"+Integer.parseInt(strings[2])+"§7usage(s).");
                                    FileUtils.setAtouts(target, "resistance au feu", Integer.parseInt(strings[2]));
                                    return true;

                                } else {
                                    player.sendMessage("§7Atouts disponibles : §bForce, Rapidite, Haste, Resistance,Feu");
                                    return false;
                                }


                            } else {
                                player.sendMessage("§cErreur de syntaxe, veuillez mettre un nombre.");
                                return false;
                            }

                        } else {
                            player.sendMessage("§cJoueur introuvable ou hors-ligne.");
                            return false;
                        }


                    } else {
                        player.sendMessage("§cMauvaise syntaxe, /atouts give <player> <durability> <atouts>");
                        return false;
                    }

                } else {
                    player.sendMessage("§cVous n'avez pas la §6permission §cnécessaire.");
                    return false;
                }
            } else {
                AtoutsInventory.ATOUTS.open(player);
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
                return true;
            }

        }


        return false;
    }
}
