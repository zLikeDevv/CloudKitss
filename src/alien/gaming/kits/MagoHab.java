package alien.gaming.kits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;

public class MagoHab implements Listener {
	public static ArrayList<Player> cooldown = new ArrayList<>();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (ArraysAPI.mago.contains(p)) && (p.getItemInHand().getType() == Material.GLOWSTONE_DUST)) {
			e.setCancelled(true);
			p.updateInventory();
			if (cooldown.contains(p)) {
				p.sendMessage("§a§l >> Kit em Cooldown!");
				return;
			}

			Random random = new Random();
			int i = random.nextInt(7);

			if (i == 0) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0));
				p.sendMessage("§a§l Voce teve uma magia de sucesso entao recebeu o efeito de §6§lForça");
			}
			if (i == 1) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 300, 0));
				p.sendMessage("§a§l Voce teve falta de sorte e recebeu o efeito de §6§lFraqueza");
			}

			if (i == 2) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
				p.sendMessage("§a§l Voce teve falta de sorte e recebeu o efeito de §6§lCegueira");
			}
			if (i == 3) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0));
				p.sendMessage("§a§l Voce teve uma magia de sucesso entao recebeu o efeito de §6§lVelocidade");
			}

			if (i == 4) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 0));
				p.sendMessage("§a§l Voce teve uma magia de sucesso entao recebeu o efeito de §6§lRegeneração");
			}

			if (i == 5) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
				p.sendMessage("§a§l Voce recebeu o efeito §6Veneno");
			}
			if (i == 6) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0));
				p.sendMessage("§a§l Voce recebeu o efeito §6Resistencia");
			}

			cooldown.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					cooldown.remove(p);
					p.sendMessage("§a§l >> Voce pode usar novamente!");
				}
			}, 30 * 20L);
		}
	}
}