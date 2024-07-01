package de.traxonlp.sunrisenetworkmenus.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.traxonlp.sunrisenetworkmenus.SunriseNetworkMenus;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static net.kyori.adventure.text.minimessage.MiniMessage.miniMessage;

public class transferPlayerCommand implements CommandExecutor {
    @Override

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) commandSender;
        String server = args[0];
        MiniMessage mm = miniMessage();
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        String servers = SunriseNetworkMenus.getInstance().getConfig().getString("servers");

        if (commandSender instanceof Player) {

            if (args.length == 1) {
                out.writeUTF("Connect");
                out.writeUTF(server);
                player.sendMessage(mm.deserialize("<gradient:#FF512F:#DD2476>Transferring Player..."));
                player.sendPluginMessage(SunriseNetworkMenus.getInstance(), "BungeeCord", out.toByteArray());
                }
            else if (args.length < 1) {
                player.sendMessage(mm.deserialize("<red>Please provide <server> only!"));
                player.sendMessage(mm.deserialize("<white>Available Servers: "+"<#7ECCED>" + servers));
                }
            else if (args.length == 0){
                player.sendMessage(mm.deserialize("<red>No Server provided!"));
                player.sendMessage(mm.deserialize("<white>Available Servers: "+"<#7ECCED>" + servers));
                player.sendMessage(mm.deserialize("<red>/transfer <server>"));
                }

            }
        else {
            player.sendMessage(mm.deserialize("<red> This command can only be executed by a Player!"));
        }
        return false;
        }
    }

