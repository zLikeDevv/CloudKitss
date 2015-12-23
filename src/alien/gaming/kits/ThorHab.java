package alien.gaming.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;
public class ThorHab implements Listener {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Player> cooldown = new ArrayList();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void Thor(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) {
			if ((p.getItemInHand().getType().equals(Material.STONE_AXE))) {
				if (this.cooldown.contains(p)) {
					p.sendMessage("§a§l >> Kit em cooldown!");
					return;
				}
				if (ArraysAPI.thor.contains(p) && (!(cooldown.contains(p)))) {
					Location loc = b.getLocation();
					p.getWorld().strikeLightning(loc);
					cooldown.add(p);
					p.getWorld().createExplosion(loc, 5, true);
				}
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					@SuppressWarnings("unused")
					public void run() {
						cooldown.remove(p);
						for (int i = 0; i < 1; i++) {
							p.sendMessage("§a§l >> O Cooldown acabou");
							return;
						}
					}
				}, 700L);
			}

		}
	}
}
