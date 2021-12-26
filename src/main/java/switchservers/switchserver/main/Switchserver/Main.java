package switchservers.switchserver.main.Switchserver;


import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import switchservers.switchserver.main.Switchserver.handlers.Command;
import switchservers.switchserver.main.Switchserver.handlers.pluginMessage;
import switchservers.switchserver.main.Switchserver.utils.Chat;

public final class Main extends JavaPlugin {

    private static Main instance;
    ConsoleCommandSender console = Bukkit.getConsoleSender();
    @Override
    public void onEnable() {
        setInstance(this);
        console.sendMessage(Chat.translate("&aPlugin sucessfully enabled!."));
        this.getCommand("send").setExecutor(new Command(this));

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new pluginMessage());
    }

    @Override
    public void onDisable() {
        console.sendMessage(Chat.translate("&cDisabling..."));
    }

    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }
}
