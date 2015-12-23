package alien.gaming.kits;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;


public class PhantomHab  implements Listener   {
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.FEATHER) {
			if(ArraysAPI.phantom.contains(p) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if(ArraysAPI.cooldown.contains(p.getName())){
					p.sendMessage(ChatColor.RED + "Voce esta em cooldown");
				}else{
					p.setAllowFlight(true);
					p.setFlying(true);
					p.getInventory().setHelmet(new ItemStack(Material.WOOL));
					p.getInventory().setChestplate(new ItemStack(Material.WOOL));
					p.getInventory().setLeggings(new ItemStack(Material.WOOL));
					p.getInventory().setBoots(new ItemStack(Material.WOOL));
					p.sendMessage(ChatColor.BLUE + "Voce Pode voar por 5 segundos :D");
					p.updateInventory();
					ArraysAPI.adicionaCoolDown(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

						public void run() {
							p.setAllowFlight(false);
							p.setFlying(false);
							p.getInventory().setHelmet(new ItemStack(Material.AIR));
							p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
							p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
							p.getInventory().setBoots(new ItemStack(Material.AIR));
							p.sendMessage(ChatColor.BLUE + "Voce Esta Caindo!");
						}
					}, 05 * 20);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						
						public void run(){
							ArraysAPI.removeCoolDown(p);
							p.sendMessage("O Cooldown acabou!");
						}
					}, 30 * 20);
	
				}
			}
		}
	}
}