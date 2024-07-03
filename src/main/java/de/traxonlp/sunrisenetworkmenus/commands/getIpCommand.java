package de.traxonlp.sunrisenetworkmenus.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.traxonlp.sunrisenetworkmenus.SunriseNetworkMenus;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.minimessage.MiniMessage.miniMessage;

public class getIpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        MiniMessage mm = miniMessage();

        if (sender instanceof Player || sender.hasPermission("snm.getip")) {
            if (args.length == 0) {
                player.sendMessage(mm.deserialize("<ff0000>Please define a Player!"));
            } else if (args.length == 1) {
                out.writeUTF("IP");
                out.writeUTF(args.toString());
                player.sendPluginMessage(SunriseNetworkMenus.getInstance(), "BungeeCord", out.toByteArray());

            } else {
                player.sendMessage(mm.deserialize("<ff0000> Please add only one argument!"));
            }


        }

        return false;
    }
}
