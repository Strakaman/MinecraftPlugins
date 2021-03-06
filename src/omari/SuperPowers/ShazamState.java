package omari.SuperPowers;
import java.util.ArrayList;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.Achievement;

public class ShazamState extends JavaPlugin {

	static ArrayList<Player> playersInShazamState = new ArrayList<Player>();
	public static void Shazam(CommandSender s)
	{
		Player player = (Player) s;
		Location pLoc = player.getLocation();
		player.getWorld().strikeLightningEffect(pLoc);
		player.getWorld().createExplosion(pLoc.getX(), pLoc.getY(), pLoc.getZ(), 0.0f,false,false);
		if (playersInShazamState.contains(player))
        {
            //undo Shazaming
            s.sendMessage(player.getName() + " has released the powers of Shazam");
            playersInShazamState.remove(player);
            player.setAllowFlight(false);
            player.setWalkSpeed(SuperPowers.defWalkSpeed);
            player.setFlySpeed(SuperPowers.defFlySpeed);
            player.setLevel(5);
            for (Achievement c : Achievement.values())
            {
           	 player.removeAchievement(c);
            }
            
        }
		 else
         {
             //giveShazam powers
             //SuperPowers.defWalkSpeed = player.getWalkSpeed();
             playersInShazamState.add(player);
             s.sendMessage(player.getName() + " called upon the powers of Shazam");
             player.setAllowFlight(true);
             player.setWalkSpeed(SuperPowers.defWalkSpeed*2);
             player.setFlySpeed(SuperPowers.defFlySpeed*2);
             player.setLevel(4000);
             player.awardAchievement(Achievement.BOOKCASE);
             //player.setFoodLevel();
             /*for (Achievement c : Achievement.values())
             {
            	 player.awardAchievement(c);
             }*/
         }
	}
	public static void ShazamOff(Player thePlaya) {
		if (playersInShazamState.contains(thePlaya))
		{
			playersInShazamState.remove(thePlaya);
            thePlaya.setAllowFlight(false);
            thePlaya.setWalkSpeed(SuperPowers.defWalkSpeed);
            thePlaya.setFlySpeed(SuperPowers.defFlySpeed);
            thePlaya.setLevel(5);
            
		}
		
	}
	
	public static boolean pInState(Player p)
	{
		return playersInShazamState.contains(p);
	}
}
