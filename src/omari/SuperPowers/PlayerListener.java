package omari.SuperPowers;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener{
	SuperPowers powerLinkedToListener; //just in case we need to reference the main java plugin for some reason?
	ArrayList<EntityDamageEvent.DamageCause> torchImmunity; 
	public PlayerListener(SuperPowers SP)
	{
		powerLinkedToListener = SP;
		torchImmunity = new ArrayList<EntityDamageEvent.DamageCause>();
		torchImmunity.add(EntityDamageEvent.DamageCause.FIRE);
		torchImmunity.add(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION);
		torchImmunity.add(EntityDamageEvent.DamageCause.FIRE_TICK);
		torchImmunity.add(EntityDamageEvent.DamageCause.LAVA);
		torchImmunity.add(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION);
		
	}
	
	//called whenever a player right clicks
	@EventHandler
	public void playerRightClicked(PlayerInteractEntityEvent event) {
	    //event.getPlayer().sendMessage("Dawg, you can't right click" + event.getRightClicked() + "right now.");
		 if (HumanTorch.playersInTorchState.contains(event.getPlayer()))
		   {
			 	  Player player = event.getPlayer();
				  Location pLoc = player.getLocation();
				  player.getWorld().createExplosion(pLoc.getX(), pLoc.getY(), pLoc.getZ(), 3f,true,false); 
		   }
	}
	
	//called whenever a player left clicks
		@EventHandler
		public void playerLeftClicked(PlayerInteractEvent event) {
		   if (!event.hasItem())
		   {
			   //event.getPlayer().sendMessage("Strength of Hercules!");		
		   }
		   if (HumanTorch.playersInTorchState.contains(event.getPlayer()))
		   {
			  if (event.getAction().equals(Action.LEFT_CLICK_AIR)){
			   event.getPlayer().launchProjectile(Fireball.class);
			  }
		   }
		   if (ShazamState.playersInShazamState.contains(event.getPlayer()))
		   {
			  if (event.getAction().equals(Action.RIGHT_CLICK_AIR)){
				 }
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
						  d.damage(event.getDamage());
					  }
				  }
				}
				
				//called whenever the player dies
				   @EventHandler
				    public void playerDied(PlayerDeathEvent event) {
				      powerLinkedToListener.turnOtherPowersOff(event.getEntity(),true);
				    }
				   
				 //called whenever the player takes damage
				   @EventHandler
				    public void playerTakeDamage(EntityDamageEvent event) {
				     if (torchImmunity.contains(event.getCause()))
				     {
				    	 if (event.getEntity() instanceof Player)
				    	 {
				    		 Player pp = (Player)event.getEntity();
				    		 if (HumanTorch.playersInTorchState.contains(pp))
				    		 {
				    			 event.setCancelled(true); //should theoretically stop torch ppl from taking damage due to being on fire
				    			 pp.setFireTicks(pp.getFireTicks()+1); //should theoretically allow them to be on fire infinitely
				    		 }
				    	 }
				     }
				    }
				    
				   
}
