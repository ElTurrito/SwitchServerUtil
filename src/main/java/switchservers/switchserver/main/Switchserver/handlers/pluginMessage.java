package switchservers.switchserver.main.Switchserver.handlers;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import switchservers.switchserver.main.Switchserver.Main;

public class pluginMessage implements PluginMessageListener {

    private Main main = Main.getInstance();

    @Override
    public void onPluginMessageReceived(String channel, Player j, byte[] message) {
        if(!channel.equals("BungeeCord"))return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subchannel = input.readUTF();
    }

    //CONNECT THE PLAYER TO THE SERVER
    public void connect(Player j, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);
        j.sendPluginMessage(main, "BungeeCord", output.toByteArray());
    }
}