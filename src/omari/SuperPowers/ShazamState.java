package omari.SuperPowers;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;

public class ShazamState extends JavaPlugin {

	static ArrayList<Player> playersInShazamState = new ArrayList<Player>();
	public static void Shazam(CommandSender s)
	{
		Player player = (Player) s;
		Location pLoc = player.getLocation();
		player.getWorld().strikeLightning(pLoc);
		player.getWorld().createExplosion(pLoc.getX(), pLoc.getY(), pLoc.getZ(), 0.0f,false,false);
		if (playersInShazamState.contains(player))
        {
            //undo Shazaming
            s.sendMessage(player.getName() + " has released the powers of Shazam");
            playersInShazamState.remove(player);
            player.setAllowFlight(false);
            player.setWalkSpeed(SuperPowers.defWalkSpeed);
        }
		 else
         {
             //giveShazam powers
             SuperPowers.defWalkSpeed = player.getWalkSpeed();
             playersInShazamState.add(player);
             s.sendMessage(player.getName() + " called upon the powers of Shazam");
             player.setAllowFlight(true);
             player.setWalkSpeed(SuperPowers.defWalkSpeed*2);
         }
	}
}
