package com.jjacobson.antidownload;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 * Created by HP1 on 3/17/2016.
 */
public class MessageListener implements PluginMessageListener {

    private AntiDownload plugin;
    private String command;

    public MessageListener(AntiDownload plugin) {
        this.plugin = plugin;
        this.command = color(plugin.getConfig().getString("command"));
        this.plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "WDL|INIT", this);
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (channel.equals("WDL|INIT")) {
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command.replace("%player%", player.getName()));
        }
    }

    private String color(String command) {
        return ChatColor.translateAlternateColorCodes('&', command);
    }
}
