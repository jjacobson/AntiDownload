package com.jjacobson.antidownload;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by HP1 on 3/17/2016.
 */
public class AntiDownload extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        new MessageListener(this);
    }

}
