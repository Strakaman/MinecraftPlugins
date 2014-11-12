package omari.SuperPowers;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperPowers extends JavaPlugin {

	ArrayList<Player> playersInShazamState = new ArrayList<Player>();
	float defWalkSpeed;
	boolean firstPoweralreadyTriggered = false;
	Player player;

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		  /*sender.sendMessage("Hello Omari S. on " + (Calendar.MONTH + 1) + "-"
		  + (Calendar.DAY_OF_MONTH) + "-" + (Calendar.YEAR));*/
		 
		if (sender instanceof Player) {
			if (!firstPoweralreadyTriggered)
			{
				firstPoweralreadyTriggered = true;
				Player player = (Player) sender;
				setDefaults(player);
			}
			
			if (command.getName().toUpperCase().equals(("SHAZAM"))) {
				Location pLoc = player.getLocation();
				player.getWorld().strikeLightning(pLoc);
				player.getWorld().createExplosion(pLoc.getX(), pLoc.getY(), pLoc.getZ(), 0,false,true);
				if (playersInShazamState.contains(player))
				{
					//undo Shazaming
					sender.sendMessage(player.getName() + " has released the powers of Shazam");
					Shazam(false);
				}
				else
				{
					//giveShazam powers
					sender.sendMessage(player.getName() + " has unleashed the powers of Shazam");
					Shazam(true);
				}
			}
			if (command.getName().toUpperCase().equals(("FLASH")))
			{
				turnAllPowersOff();
				Flash(true);
			}
		}
		return true;

	}
	
	public void setDefaults(Player playa)
	{
		defWalkSpeed = playa.getWalkSpeed();
		
	}
	
	public void turnAllPowersOff()
	{
		Flash(false);
		Shazam(false);
	}
	
	public void Shazam(boolean turnOn)
	{
		if (!turnOn) 
		{
			//undo Shazaming
			if (playersInShazamState.contains(player))
			{playersInShazamState.remove(player);
			}
			player.setAllowFlight(false);
			player.setWalkSpeed(defWalkSpeed);
		}
		else
		{
			playersInShazamState.add(player);
			player.setAllowFlight(true);
			player.setWalkSpeed(defWalkSpeed*2);
		}
	}
	public void Flash(boolean turnOn)
	{
		if (turnOn)
		{
			player.setWalkSpeed(defWalkSpeed*4);
		}
		else
		{
			player.setWalkSpeed(defWalkSpeed);
		}
	}

	@Override
	public void onDisable() {
		// TODO Auto-gener
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

}
