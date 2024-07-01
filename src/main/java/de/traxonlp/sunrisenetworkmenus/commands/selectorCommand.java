package de.traxonlp.sunrisenetworkmenus.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class selectorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;


        Inventory inv = Bukkit.createInventory(null, 27, "§aSelector");

        ItemStack item = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#c6ea8d") + "Survival");
        item.setItemMeta(meta);
        
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta1 = glass.getItemMeta();
        meta1.setDisplayName(net.md_5.bungee.api.ChatColor.of("#c6ea8d") + "");
        glass.setItemMeta(meta1);

        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        inv.setItem(9, glass);
        inv.setItem(10, glass);
        inv.setItem(11, glass);
        inv.setItem(12, glass);
        inv.setItem(13, item);
        inv.setItem(14, glass);
        inv.setItem(15, glass);
        inv.setItem(16, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(24, glass);
        inv.setItem(25, glass);
        inv.setItem(26, glass);




        p.closeInventory();
        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 0.75F);

        return false;
    }
}
