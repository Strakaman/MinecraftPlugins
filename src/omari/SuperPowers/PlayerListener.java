package omari.SuperPowers;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener implements Listener{
	SuperPowers powerLinkedToListener; //just in case we need to reference the main java plugin for some reason?
	
	public PlayerListener(SuperPowers SP)
	{
		powerLinkedToListener = SP;
	}
	
	//called whenever a player right clicks
	@EventHandler
	public void playerRightClicked(PlayerInteractEntityEvent event) {
	    event.getPlayer().sendMessage("Dawg, you can't right click" + event.getRightClicked() + "right now.");
	   
	}
	
	//called whenever a player left clicks
		@EventHandler
		public void playerLeftClicked(PlayerInteractEvent event) {
		   if (!event.hasItem())
		   {
			   event.getPlayer().sendMessage("Strength of Hercules!");		
		   }
		   if (event.getPlayer().getItemInHand().getType() == Material.FIREBALL) {
			   event.getPlayer().launchProjectile(Fireball.class);
		   }
		}
		
	//called whenever an entity damages another
				@EventHandler
				public void entitydamageotherentity(EntityDamageByEntityEvent event) {
				  //if the entity is hit by someone in the shazam state, they take extra damage
					Entity damager = event.getDamager();
				  if (damager instanceof Player)
				  {
					  Player p = (Player) damager;
					  if (ShazamState.playersInShazamState.contains(p))
					  {
						  //take 3x as must damage as you just took
						  Damageable d = (Damageable)event.getEntity();
						  d.damage(event.getDamage());
						  d.damage(event.getDamage());
					  }
				  }
				}
}
