package omari.SuperPowers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperPowers extends JavaPlugin {

	static float defWalkSpeed = 0.2f;
	boolean firstPoweralreadyTriggered = false;
	Player player;

	public void onEnable() {
		getLogger().info(("peter 9-30"));
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender instanceof Player) {
			 Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("cat")) {
			//sender.sendMessage("big butts. peter 9-30");
			AvatarState.catAttack(sender);
		}
		
		if (command.getName().equalsIgnoreCase("glass")) {
			//Player p = (Player) sender;
			//rainMaker(p);
			AvatarState.earthBend(p);
		}
		
		if (command.getName().equalsIgnoreCase("flash")) {
			//Player p = (Player) sender;
			//rainMaker(p);
			//sender.sendMessage("walk speed:" + p.getWalkSpeed());
			turnOtherPowersOff(p, true);
			FlashState.flashPoint(p, true);
		}
		if (command.getName().equalsIgnoreCase("kazaam")) {
			//Player p = (Player) sender;
			//rainMaker(p);
			Kazaam.rainFood(p);
		}	  
		if (command.getName().equalsIgnoreCase("shazam")) {
			turnOtherPowersOff(p, false);
			ShazamState.Shazam(sender);
		}	
		
		if (command.getName().equalsIgnoreCase("debug")) {
			Debug.debugStuff(sender);
		}
		
	    }
	        return true;
	}
	

	
	public void setDefaults(Player playa)
	{
		
		
	}
	
	public void turnOtherPowersOff(Player thePlaya, boolean turnOffShazamToo)
	{//shazam too boolean is true for all superpower calls that aren't shazam
		FlashState.flashPoint(thePlaya,false);
		//turn AvatarState Off
		if (turnOffShazamToo)
		{
			ShazamState.Shazam((CommandSender)thePlaya);
		}
	}
//	
//	public void Shazam(boolean turnOn)
//	{
//		if (!turnOn) 
//		{
//			//undo Shazaming
//			if (playersInShazamState.contains(player))
//			{playersInShazamState.remove(player);
//			}
//			player.setAllowFlight(false);
//			player.setWalkSpeed(defWalkSpeed);
//		}
//		else
//		{
//			playersInShazamState.add(player);
//			player.setAllowFlight(true);
//			player.setWalkSpeed(defWalkSpeed*2);
//		}
//	}
//	


}
