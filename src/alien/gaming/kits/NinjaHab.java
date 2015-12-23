package alien.gaming.kits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;

public class NinjaHab implements Listener {
	public static HashMap<Player, Player> a = new HashMap<Player, Player>();
	public static HashMap<Player, Long> b = new HashMap<Player, Long>();
	public static List<Player> cooldownbk = new ArrayList<Player>();

	@EventHandler
	public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player))
				&& ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (ArraysAPI.ninja.contains(localPlayer1)) {
				a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						NinjaHab.cooldownbk.remove(localPlayer1);
					}
				}, 200L);
			}
		}
	}

	@SuppressWarnings("unused")
	@EventHandler
	public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		if ((paramPlayerToggleSneakEvent.isSneaking()) && (ArraysAPI.ninja.contains(localPlayer1))
				&& (a.containsKey(localPlayer1))) {
			Player localPlayer2 = (Player) a.get(localPlayer1);
			if ((localPlayer2 != null) && (!localPlayer2.isDead())) {
				String str = null;
				if (b.get(localPlayer1) != null) {
					long l = ((Long) b.get(localPlayer1)).longValue() - System.currentTimeMillis();
					DecimalFormat localDecimalFormat = new DecimalFormat("##");
					int i = (int) l / 1000;
					str = localDecimalFormat.format(i);
				}
				if ((b.get(localPlayer1) == null)
						|| (((Long) b.get(localPlayer1)).longValue() < System.currentTimeMillis())) {
					if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D) {
						localPlayer1.teleport(localPlayer2.getLocation());
						localPlayer1.sendMessage("§a§l >> Teleportado");
						b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
					} else {
						localPlayer1.sendMessage("§c§l >> O Ultimo player hitado está muito longe ");
					}
				} else
					localPlayer1.sendMessage("§a§l >> Kit em Cooldown!");
			}
		}
	}
}