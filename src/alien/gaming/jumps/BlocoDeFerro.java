package alien.gaming.jumps;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import alien.gaming.utils.ArraysAPI;

public class BlocoDeFerro implements Listener {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> RedStone = new ArrayList();

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
			RedStone.remove(p.getName());
			Location loc = e.getTo().getBlock().getLocation();
			Vector sponge = p.getLocation().getDirection().multiply(3).setY(1);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			RedStone.add(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void daroKit(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if ((!ArraysAPI.habilidade.contains(p))
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
			p.sendMessage("§a§l >> Voce nao tinha selecionado nenhum kit, entao vc pegou um kit normal!");
			p.chat("/pvp");
			RedStone.remove(p.getName());
			Location loc = e.getTo().getBlock().getLocation();
			Vector sponge = p.getLocation().getDirection().multiply(3.5).setY(1);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			p.playSound(loc, Sound.BAT_TAKEOFF, 6.0F, 1.0F);
			p.playEffect(loc, Effect.ENDER_SIGNAL, null);
			RedStone.add(p.getName());
			return;
		}
	}

	@EventHandler
	public void onFall(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && (RedStone.contains(p.getName()))) {
				e.setCancelled(true);
				RedStone.remove(p.getName());
			}
		}
	}
}