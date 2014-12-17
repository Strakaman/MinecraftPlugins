package omari.SuperPowers;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {
	SuperPowers powerLinkedToListener; // just in case we need to reference the
										// main java plugin for some reason?
	ArrayList<EntityDamageEvent.DamageCause> torchImmunity;
	ArrayList<EntityDamageEvent.DamageCause> shazamImmunity;
	
	public PlayerListener(SuperPowers SP) {
		powerLinkedToListener = SP;
		torchImmunity = new ArrayList<EntityDamageEvent.DamageCause>();
		shazamImmunity = new ArrayList<EntityDamageEvent.DamageCause>();
		torchImmunity.add(EntityDamageEvent.DamageCause.FIRE);
		torchImmunity.add(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION);
		torchImmunity.add(EntityDamageEvent.DamageCause.FIRE_TICK);
		torchImmunity.add(EntityDamageEvent.DamageCause.LAVA);
		torchImmunity.add(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION);
		shazamImmunity.add(EntityDamageEvent.DamageCause.STARVATION);
		shazamImmunity.add(EntityDamageEvent.DamageCause.LIGHTNING);

	}

	// called whenever a player right clicks
	@EventHandler
	public void playerRightClicked(PlayerInteractEntityEvent event) {
		// event.getPlayer().sendMessage("Dawg, you can't right click" +
		// event.getRightClicked() + "right now.");		
		/*if (HumanTorch.playersInTorchState.contains(event.getPlayer())) {
			Location pLoc = event.getPlayer().getLocation();
			event.getPlayer().getWorld().createExplosion(pLoc.getX(), pLoc.getY(),
					pLoc.getZ(), 3f, true, false);
		}
		if (ShazamState.playersInShazamState.contains(event.getPlayer()))
		{
			
		}*/
		
		
	}

	// called whenever a player left clicks
	@EventHandler
	public void playerLeftClicked(PlayerInteractEvent event) {
		if (!event.hasItem()) {
			// event.getPlayer().sendMessage("Strength of Hercules!");
		}
		if (HumanTorch.playersInTorchState.contains(event.getPlayer())) {
			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
				event.getPlayer().launchProjectile(Fireball.class);
			}
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR)||event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				Location pLoc = event.getPlayer().getLocation();
				event.getPlayer().getWorld().createExplosion(pLoc.getX(), pLoc.getY(),
						pLoc.getZ(), 3f, true, false);
			}
		}
		if (ShazamState.playersInShazamState.contains(event.getPlayer())) {
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				event.getPlayer().getWorld().strikeLightning(event.getClickedBlock().getLocation());
			}
			}
			
		
		if (event.getPlayer().getItemInHand().getType() == Material.FIREBALL) {
			event.getPlayer().launchProjectile(Fireball.class);
		}
	}

	// called whenever an entity damages another
	@EventHandler
	public void entitydamageotherentity(EntityDamageByEntityEvent event) {
		// if the entity is hit by someone in the shazam state, they take extra
		// damage
		Entity damager = event.getDamager();
		if (damager instanceof Player) {
			Player p = (Player) damager;
			if (ShazamState.playersInShazamState.contains(p)) {
				// take 10x as must damage as you just took
				event.setDamage(event.getDamage()*10);
			}
		}
	}

	//called whenever the player moves
	@EventHandler
	public void playerMoved(PlayerMoveEvent event) {
		if (HumanTorch.playersInTorchState.contains(event.getPlayer())){
		Material m = event.getPlayer().getLocation().getBlock().getType();
	    if (m == Material.STATIONARY_WATER || m == Material.WATER) {
	        // player is in water
	    	HumanTorch.flameOff(event.getPlayer()); //should depower you if you hit water
	      }
		}
		if (event.getFrom().getY() == event.getTo().getY())
		{
		if (FlashState.playersInFlashState.contains(event.getPlayer()))
		 {	
			//first check if you are above water, if so turn it into sand so you can theoretically run above it
			//reuse same Location variable?
			//first location grab is under flash
			Location FlashLoc = new Location(event.getPlayer().getWorld(), event.getTo().getX(), event.getTo().getY()-1, event.getTo().getZ());
			Block underBlock = event.getPlayer().getWorld().getBlockAt(FlashLoc);
			if (underBlock.getType() == Material.WATER)
			{
				underBlock.setType(Material.ICE);
			}
			double deltaX = event.getTo().getX() - event.getFrom().getX();
			double deltaZ = event.getTo().getZ() - event.getFrom().getZ();
			FlashLoc = new Location(event.getPlayer().getWorld(), event.getTo().getX()+Math.signum(deltaX), event.getTo().getY(), event.getTo().getZ()+Math.signum(deltaZ));
			underBlock = event.getPlayer().getWorld().getBlockAt(FlashLoc);
			underBlock.breakNaturally();
			FlashLoc = new Location(event.getPlayer().getWorld(), event.getTo().getX()+Math.signum(deltaX), event.getTo().getY()+1, event.getTo().getZ()+Math.signum(deltaZ));
			underBlock = event.getPlayer().getWorld().getBlockAt(FlashLoc);
			underBlock.breakNaturally();
			//if (event.getTo().get)

		 //event.getPlayer().sendMessage("haha"); //debugging
		 }
		}
	}
	
	// called whenever the player dies
	@EventHandler
	public void playerDied(PlayerDeathEvent event) {
		powerLinkedToListener.turnOtherPowersOff(event.getEntity(), true);
	}

	// called whenever the player takes damage
	@EventHandler
	public void playerTakeDamage(EntityDamageEvent event) {
		if (shazamImmunity.contains(event.getCause())) {
			if (event.getEntity() instanceof Player) {
				if (ShazamState.playersInShazamState.contains((Player) event.getEntity())) {
					event.setCancelled(true); // should theoretically give
												// shazam the stamina of atlas
				}
			}
		}

		if (torchImmunity.contains(event.getCause())) {
			if (event.getEntity() instanceof Player) {
				Player pp = (Player) event.getEntity();
				if (HumanTorch.playersInTorchState.contains(pp)) {
					event.setCancelled(true); // should theoretically stop torch ppl from taking damage due to being on fire
					pp.setFireTicks(pp.getFireTicks() + 1); // should theoretically allow them to be on fire indefinitely
				}
			}
		}
	}

}
