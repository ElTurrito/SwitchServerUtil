package switchservers.switchserver.main.Switchserver.handlers;

import org.bukkit.Bukkit;
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
       // if (sender instanceof Player) {
                Player j = (Player) sender;

                //SEND THE PLAYER TO THE SERVER
                if (args.length == 1) {
                    pluginMessage.connect(j, args[0]);
                } else {
                    j.sendMessage(Chat.translate("/send <server>"));
                }


                if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("send")) {

                    }
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        sender.sendMessage(Chat.translate("&cThe player '" + args[1] + "' is offline!"));
                        return true;
                    } else {
                        pluginMessage.connect(target, args[2]);
                        sender.sendMessage(Chat.translate("&aSucessfully sended the player " + target.getName() + " to the server" + args[2]));
                    }
                }
            //}
        //}
        return true;
    }
}
