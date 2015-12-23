package alien.gaming.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;

public class SonicHab implements Listener {

	public static ArrayList<Player> cooldownm = new ArrayList<Player>();

	@EventHandler
	public void DropKangaroo(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((ArraysAPI.sonic.contains(p))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			if (p.getItemInHand().getType() == Material.LAPIS_BLOCK) {

				e.setCancelled(true);
				p.updateInventory();
				if (cooldownm.contains(p)) {
					p.sendMessage(" §a§l>> Kit em Cooldown!");
					return;
				}
				p.sendMessage(" §a§l>>  §a§lSonic Usado!");

				p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);

				p.updateInventory();

				final Vector Vector = p.getEyeLocation().getDirection();
				Vector.multiply(5);
				p.setVelocity(Vector);
				cooldownm.add(p);
				List<Entity> Local = p.getNearbyEntities(7.0D, 7.0D, 7.0D);
				for (Entity Inimigos : Local) {
					((LivingEntity) Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 1));

					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							p.setVelocity(Vector);
							p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 22, 1);
						}
					}, 20L);

					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);
						}
					}, 30L);

					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);

						}
					}, 40L);

					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);
						}
					}, 50L);
				}

				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
					}
				}, 60L);

				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						SonicHab.cooldownm.remove(p);
						p.sendMessage(" §a§l>> Voce pode usar novamente!");

					}
				}, 500L);
			}
		}
	}
}