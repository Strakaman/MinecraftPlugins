package omari.SuperPowers;
import java.util.ArrayList;

import org.bukkit.entity.Player;

public class FlashState {

	static ArrayList<Player> playersInFlashState = new ArrayList<Player>();
	
	public static void flashPoint(Player p, boolean turnOn)
	{
		if (turnOn)
		{
			p.setWalkSpeed(SuperPowers.defWalkSpeed*4);
			if (!playersInFlashState.contains(p))
	        {
				playersInFlashState.add(p);
				p.sendMessage(p.getName() + " is the fastest player alive!");
	        }
		}
		else
		{
			p.setWalkSpeed(SuperPowers.defWalkSpeed);
			if (playersInFlashState.contains(p))
	        {
				playersInFlashState.remove(p);
	        }
		}
	}
	
	public static boolean pInState(Player p)
	{
		return playersInFlashState.contains(p);
	}
}
