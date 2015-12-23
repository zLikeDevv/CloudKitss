package alien.gaming.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.util.Vector;

import alien.gaming.principal.Main;

public class Drop implements Listener {

	@EventHandler
	public void sumiudrops(ItemSpawnEvent e) {
		Item sumiudrops = e.getEntity();

		Vector v = new Vector();
		v.setY(1);
		sumiudrops.setVelocity(v);
		sumiudrops.setPickupDelay(1000);
	}

	@EventHandler
	public void sumiuDrop(ItemSpawnEvent e) {
		final Item sumiudrop = e.getEntity();
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				sumiudrop.setPickupDelay(50);
				sumiudrop.getWorld().playEffect(sumiudrop.getLocation(), Effect.SMOKE, 55);
				sumiudrop.remove();
			}
		}, 32L);
	}

	@EventHandler
	public static void NoDrpar(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.VINE) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BONE) {
			e.setCancelled(true);
		}
	}
}