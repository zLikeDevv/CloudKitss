package alien.gaming.kits;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import alien.gaming.utils.ArraysAPI;

@SuppressWarnings({ "unchecked", "rawtypes" })

public class KangarooHab implements Listener {
	public static ArrayList<Player> Habilidades = new ArrayList();
	public static ArrayList<Player> KangarooMC = new ArrayList();

	@EventHandler
	public void DropKangaroo(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			p.sendMessage(ChatColor.GRAY + ChatColor.ITALIC.toString() + "Opa Quase Dropei Meu FireRocket");
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void InteractKangaroo(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((ArraysAPI.kangaroo.contains(p)) && (p.getItemInHand().getType() == Material.FIREWORK)) {
			if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)
					|| (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				e.setCancelled(true);
			}
			if (!KangarooMC.contains(p)) {
				if (!p.isSneaking()) {
					p.setFallDistance(-3.0F);
					Vector Vector = p.getEyeLocation().getDirection();
					Vector.multiply(1.0F);
					Vector.setY(0.8F);
					p.setVelocity(Vector);
				} else {

					p.setFallDistance(-3.0F);
					Vector Vector = p.getEyeLocation().getDirection();
					Vector.multiply(1.0F);
					Vector.setY(0.64D);
					p.setVelocity(Vector);
				}
				KangarooMC.add(p);
			}
		}
	}

	@EventHandler
	public void Move(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (KangarooMC.contains(p)) {
			Block B = p.getLocation().getBlock();
			if ((B.getType() != Material.AIR) || (B.getRelative(BlockFace.DOWN).getType() != Material.AIR))
				KangarooMC.remove(p);
		}
	}
}
