package omari.SuperPowers;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HumanTorch {

	static ArrayList<Player> playersInTorchState = new ArrayList<Player>();
	
	public static void flameOn(CommandSender s)
	{
		Player p = (Player)s;
		if (!playersInTorchState.contains(p))
				{
					playersInTorchState.add(p);
					
				}
		p.setFireTicks(30);
		p.setAllowFlight(true);
		
	}
	
	public static void flameOff(Player play)
	{
		if (playersInTorchState.contains(play))
		{
			playersInTorchState.remove(play);
            play.setAllowFlight(false);
            play.setFireTicks(0);
		}
	}
}
