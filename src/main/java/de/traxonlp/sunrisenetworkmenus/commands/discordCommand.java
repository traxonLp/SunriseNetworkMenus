package de.traxonlp.sunrisenetworkmenus.commands;

import de.traxonlp.sunrisenetworkmenus.SunriseNetworkMenus;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class discordCommand implements CommandExecutor {

    private final SunriseNetworkMenus plugin;
    public discordCommand(SunriseNetworkMenus plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        p.sendMessage(ChatColor.WHITE+ "The discord Link is "+ this.plugin.getConfig().getString("dclink"));
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1.0F);
        return false;
    }
}
