package omari.SuperPowers;

import java.util.ArrayList;

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
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender instanceof Player) {
		if (command.getName().equalsIgnoreCase("cat")) {
			//sender.sendMessage("big butts. peter 9-30");
			AvatarState.catAttack(sender);
		}
		
		if (command.getName().equalsIgnoreCase("glass")) {
			Player p = (Player) sender;
			//rainMaker(p);
			AvatarState.rainMaker(p);
		}
		
		if (command.getName().equalsIgnoreCase("flash")) {
			Player p = (Player) sender;
			//rainMaker(p);
			//sender.sendMessage("walk speed:" + p.getWalkSpeed());
			FlashState.flashPoint(p, true);
		}
		if (command.getName().equalsIgnoreCase("kazaam")) {
			Player p = (Player) sender;
			//rainMaker(p);
			Kazaam.rainFood(p);
		}	  
		if (command.getName().equalsIgnoreCase("shazam")) {
			ShazamState.Shazam(sender);
		}	
		
	    }
	        return true;
	}
	

	
	public void setDefaults(Player playa)
	{
		
		
	}
	
//	public void turnAllPowersOff()
//	{
//		Flash(false);
//		Shazam(false);
//	}
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
