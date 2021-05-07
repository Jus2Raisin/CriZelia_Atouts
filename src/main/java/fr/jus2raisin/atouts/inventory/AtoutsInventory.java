package fr.jus2raisin.atouts.inventory;

import fr.jus2raisin.atouts.utils.AtoutsUtils;
import fr.jus2raisin.atouts.utils.FileUtils;
import fr.jus2raisin.atouts.utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;

public class AtoutsInventory implements InventoryProvider {

    public static final SmartInventory ATOUTS = SmartInventory.builder()
            .id("atouts")
            .provider(new AtoutsInventory())
            .size(3, 9)
            .title("§f§l» §d§lAtouts §f- §bAccueil §f§l«")
            .build();

    private final Random random = new Random();


    @Override
    public void init(Player player, InventoryContents contents) {
        contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setDisplayName("§f§l» §d§lAtouts §f- §bBoutique §f§l«").build(),
                e -> player.sendMessage(ChatColor.GOLD + "§cShop")));

        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.INK_SACK, (short) 1).setDisplayName("§6§l» §cQuittez le menu d'Accueil. §6§l«").setGlow(true).build(),
                e -> player.closeInventory()));

        contents.set(1, 3, ClickableItem.of(getAtout(player, (short) 8258,"Rapidite")
                ,e -> AtoutsUtils.giveAtout(player, "Rapidite")));

        contents.set(1, 2, ClickableItem.of(getAtout(player, (short) 8259,"Resistance au Feu")
                ,e -> AtoutsUtils.giveAtout(player, "Resistance au Feu")));

        contents.set(1, 4, ClickableItem.of(getAtout(player, (short) 8201,"Force")
                ,e -> AtoutsUtils.giveAtout(player, "Force")));

        contents.set(1, 5, ClickableItem.of(getAtout(player, (short) 8234,"Resistance")
                ,e -> AtoutsUtils.giveAtout(player, "Resistance")));

        contents.set(1, 6, ClickableItem.of(getAtout(player, (short) 8259,"Haste")
                ,e -> AtoutsUtils.giveAtout(player, "Haste")));


    }

    @Override
    public void update(Player player, InventoryContents contents) {
        /*int state = contents.property("state", 0);
        contents.setProperty("state", state + 1);

        if(state % 5 != 0)
            return;*/

        contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setDisplayName("§f§l» §d§lAtouts §f- §bBoutique §f§l«").build(),
                e -> player.sendMessage(ChatColor.GOLD + "§cShop")));

        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.INK_SACK, (short) 1).setDisplayName("§6§l» §cQuittez le menu d'Accueil. §6§l«").setGlow(true).build(),
                e -> player.closeInventory()));

        contents.set(1, 3, ClickableItem.of(getAtout(player, (short) 8258,"Rapidite")
                ,e -> AtoutsUtils.giveAtout(player, "Rapidite")));

        contents.set(1, 2, ClickableItem.of(getAtout(player, (short) 8259,"Resistance au Feu")
                ,e -> AtoutsUtils.giveAtout(player, "Resistance au Feu")));

        contents.set(1, 4, ClickableItem.of(getAtout(player, (short) 8201,"Force")
                ,e -> AtoutsUtils.giveAtout(player, "Force")));

        contents.set(1, 5, ClickableItem.of(getAtout(player, (short) 8234,"Resistance")
                ,e -> AtoutsUtils.giveAtout(player, "Resistance")));

        contents.set(1, 6, ClickableItem.of(getAtout(player, (short) 8259,"Haste")
                ,e -> AtoutsUtils.giveAtout(player, "Haste")));

    }

    private ItemStack getAtout(Player player, short data, String atouts)
    {
        return new ItemBuilder(Material.POTION, (short) data)
                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                .addItemFlag(ItemFlag.HIDE_POTION_EFFECTS)
                .setAmount(1)
                .setDisplayName("§8∙ §7Atout : §6"+atouts)
                .setLore(Arrays.asList(" ", "§6│ §7Status : §b"+FileUtils.playerHasAtout(player, atouts)
                        , "§6│ §7Usage restant : §b"+FileUtils.getDurability(player, atouts), " "))
                .build();
    }

}
