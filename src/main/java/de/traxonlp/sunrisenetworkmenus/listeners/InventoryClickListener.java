package de.traxonlp.sunrisenetworkmenus.listeners;

import de.traxonlp.sunrisenetworkmenus.SunriseNetworkMenus;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class InventoryClickListener implements Listener {
    @SuppressWarnings({"NullableProblems"})
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();

            if (p.getOpenInventory().getTitle().equals("§aSelector")) {
                if (e.getCurrentItem() != null || e.getCurrentItem().getType() != Material.AIR) {
                    e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                    e.setCancelled(true);

                    p.closeInventory();
                    p.sendMessage(SunriseNetworkMenus.getPrefix() + "Connecting to Survival...");
                    p.performCommand("transfer gameworld");

                }
                if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    e.setCancelled(true);

                    p.playSound(p.getLocation(), Sound.ENTITY_CAT_DEATH, 0.5F, 0.3F);
                }
                }
            }
        }
    }
}
