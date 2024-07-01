package de.traxonlp.sunrisenetworkmenus;

import de.traxonlp.sunrisenetworkmenus.commands.discordCommand;
import de.traxonlp.sunrisenetworkmenus.commands.selectorCommand;
import de.traxonlp.sunrisenetworkmenus.commands.transferPlayerCommand;
import de.traxonlp.sunrisenetworkmenus.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class SunriseNetworkMenus extends JavaPlugin {

    private static SunriseNetworkMenus instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        commandRegistration();
        saveDefaultConfig();
        Bukkit.getLogger().fine("[SNM] Loaded Correctly!");


        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new InventoryClickListener(), this);

    }

    public static SunriseNetworkMenus getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().fine("[SNM] Shutting Down...");
    }

    public static String getPrefix() {
        return net.md_5.bungee.api.ChatColor.of("#c6ea8d") + "[" + net.md_5.bungee.api.ChatColor.of("#d8cc98") + "S" + net.md_5.bungee.api.ChatColor.of("#ebaea3") + "N"+ net.md_5.bungee.api.ChatColor.of("#fe90af") + "]";
    }

    public void commandRegistration() {
        getCommand("selector").setExecutor(new selectorCommand());
        getCommand("dclink").setExecutor(new discordCommand(this));
        getCommand("transfer").setExecutor(new transferPlayerCommand());
    }
}
