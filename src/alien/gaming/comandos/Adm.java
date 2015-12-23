package alien.gaming.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Adm implements Listener {
	public static ArrayList<Player> DamageMobs = new ArrayList<Player>();

	@EventHandler
	public void DamageMobs(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getDamager();
		if ((DamageMobs.contains(p)) && ((e.getEntity() instanceof Entity)))
			e.setCancelled(true);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void VerPlayers(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Admin.admin.contains(p) &&(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Player-Info")
				&& p.getItemInHand().getType() == Material.FEATHER)
				&& ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))) {
			Inventory inv = Bukkit.createInventory(p, 54, "§0§nPlayer - Online");
			for (Player players : Bukkit.getOnlinePlayers()) {
				if (!players.getName().equals(p.getName())) {
					ItemStack skull = new ItemStack(Material.getMaterial(397));
					SkullMeta sm = (SkullMeta) skull.getItemMeta();

					skull.setDurability((short) 3);
					sm.hasOwner();
					sm.setOwner(players.getName());
					sm.setDisplayName(players.getName());
					skull.setItemMeta(sm);
					inv.addItem(new ItemStack[] { skull });
					e.setCancelled(true);

				}

				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void onInteract1234(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.BEDROCK) {
			Player r = (Player) e.getRightClicked();
			r.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(1.0D, 1.0D, 1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(-1.0D, 1.0D, -1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(1.0D, 1.0D, -1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(-1.0D, 1.0D, 1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 0.0D, -1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(-1.0D, 0.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(1.0D, 0.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 0.0D, 1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 3.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 2.0D, -1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(-1.0D, 2.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(1.0D, 2.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 2.0D, 1.0D).getBlock().setType(Material.BEDROCK);
			r.getLocation().add(0.0D, 1.0D, -1.0D).getBlock().setType(Material.IRON_FENCE);
			r.getLocation().add(-1.0D, 1.0D, 0.0D).getBlock().setType(Material.IRON_FENCE);
			r.getLocation().add(1.0D, 1.0D, 0.0D).getBlock().setType(Material.IRON_FENCE);
			r.getLocation().add(0.0D, 1.0D, 1.0D).getBlock().setType(Material.IRON_FENCE);
			r.getLocation().add(0.0D, 2.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			r.teleport(r.getLocation().add(0.0D, 0.0D, -0.05D));
		}
	}
}