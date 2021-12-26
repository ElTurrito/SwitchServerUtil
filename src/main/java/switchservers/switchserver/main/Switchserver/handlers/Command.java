package switchservers.switchserver.main.Switchserver.handlers;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import switchservers.switchserver.main.Switchserver.Main;
import switchservers.switchserver.main.Switchserver.utils.Chat;

public class Command implements CommandExecutor {

    private pluginMessage pluginMessage = new pluginMessage();

    private final Main main;
    public Command(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player j = (Player) sender;

            //SEND THE PLAYER TO THE SERVER
            if (command.getName().equalsIgnoreCase("send")) {
                if (args.length == 1) {
                    pluginMessage.connect(j, args[0]);
                } else {
                    j.sendMessage(Chat.translate("/send <server>") );
                }
            }
        }

        return true;
    }
}
