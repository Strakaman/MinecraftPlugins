package omari.SuperPowers;

import java.util.List;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class SuperPowers extends JavaPlugin {

	static float defWalkSpeed = 0.2f;
	static float defFlySpeed = 0.1f;
	Player player;

	public void onEnable() {
		getLogger().info(("peter 9-30"));
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender instanceof Player) {
			 Player p = (Player) sender;
		
		if (command.getName().equalsIgnoreCase("avatarState")) {
			turnOtherPowersOff(p, true);
			AvatarState.avatarOn(p);
		}
		AvatarState.commandAvatar(p, command);

		
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
			
	        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        p.sendMessage("Debug is real repeat");
	        scheduler.scheduleAsyncDelayedTask(this, new Monta(this, p), 0L);
			
		}	  
		if (command.getName().equalsIgnoreCase("shazam")) {
			turnOtherPowersOff(p, false);
			ShazamState.Shazam(sender);
		}	
		
		if (command.getName().equalsIgnoreCase("debug")) {
			Debug.debugStuff(sender);
			sender.sendMessage("Debugging");
		}
		if (command.getName().equalsIgnoreCase("flameon")) {
			turnOtherPowersOff(p, true);
			HumanTorch.flameOn(sender);
		}
		if (command.getName().equalsIgnoreCase("revert")) {
			turnOtherPowersOff(p, true);
		}
		
		if (command.getName().equalsIgnoreCase("cerebro"))
		{
			Cerebro(p);
		}
	    }
	        return true;
	}
	
	
	private void Cerebro(Player p) {
		// TODO Auto-generated method stub
		Player[] listofPlayers = Bukkit.getOnlinePlayers(); 
		for (Player pro : listofPlayers)
		{
			if (!(pro.equals(p))) //skip yourself because you shouldn't find yourself with Cerebro
			{
				if (playerPoweredUp(pro))
				{
					p.sendMessage(pro.getName() + ": was found at X: " + pro.getLocation().getX() + " Y: " + pro.getLocation().getY() + " Z: " + pro.getLocation().getZ());
					pro.sendMessage(p.getName() + "has scanned for you. Beware....");
				}
			}
		}
	}

	public void setDefaults(Player playa)
	{
		
		
	}
	
	public void turnOtherPowersOff(Player thePlaya, boolean turnOffShazamToo)
	{//shazam too boolean is true for all superpower calls that aren't shazam
		FlashState.flashPoint(thePlaya,false);
		AvatarState.avatarOff(thePlaya);
		HumanTorch.flameOff(thePlaya);
		//turn AvatarState Off
		if (turnOffShazamToo)
		{
			ShazamState.ShazamOff(thePlaya);
		}
	}
	
	public boolean playerPoweredUp(Player pp)
	{
		return (AvatarState.pInState(pp)||(ShazamState.pInState(pp)||(FlashState.pInState(pp)||(HumanTorch.pInState(pp)))));
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
