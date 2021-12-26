package switchservers.switchserver.main.Switchserver.utils;

import org.bukkit.ChatColor;


public class Chat {

    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
