package fr.jus2raisin.atouts;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private static Main instance;
    private static Launcher launcher;

    /*
    TODO: finir l'inventaire puis ajouter un Nofall
    todo: et aussi refaire la commande entierement car y a un soucis

     */


    @Override
    public void onEnable()
    {
        instance = this;
        launcher = new Launcher(this);
    }

    public static Main getInstance() { return instance; }

    public static Launcher getLauncher() { return launcher; }

}
