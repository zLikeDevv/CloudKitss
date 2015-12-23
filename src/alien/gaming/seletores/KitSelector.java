package alien.gaming.seletores;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import alien.gaming.menuaceitar.Menus;
import alien.gaming.utils.Metodos;

public class KitSelector implements Listener {

	public static void seletorDeKits(Player p) {

		Inventory inventario = Bukkit.createInventory(p, 54, "§7Kits");

		ItemStack pvp = Metodos.criarItem(ChatColor.GREEN, "Kit PvP", Material.STONE_SWORD);
		ItemStack phantom = Metodos.criarItem(ChatColor.GREEN, "Kit Phantom", Material.FEATHER);
		ItemStack sonic = Metodos.criarItem(ChatColor.GREEN, "Kit Sonic", Material.LAPIS_BLOCK);
		ItemStack kangaroo = Metodos.criarItem(ChatColor.GREEN, "Kit Kangaroo", Material.FIREWORK);
		ItemStack mago = Metodos.criarItem(ChatColor.GREEN, "Kit Mago", Material.GLOWSTONE_DUST);
		ItemStack hulk = Metodos.criarItem(ChatColor.GREEN, "Kit Hulk", Material.LEAVES);
		ItemStack ninja = Metodos.criarItem(ChatColor.GREEN, "Kit Ninja", Material.COAL);
		ItemStack thor = Metodos.criarItem(ChatColor.GREEN, "Kit Thor", Material.STONE_AXE);
		ItemStack vidro = Metodos.criarItem(ChatColor.GREEN, "   ", Material.STAINED_GLASS_PANE);

		vidro.setDurability((short) 14);
		inventario.clear();
		inventario.setItem(0, vidro);
		inventario.setItem(1, vidro);
		inventario.setItem(7, vidro);
		inventario.setItem(8, vidro);
		inventario.setItem(9, vidro);
		inventario.addItem(pvp);

		if (p.hasPermission("alien.phantom")) {
			inventario.addItem(phantom);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.sonic")) {
			inventario.addItem(sonic);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.kangaroo")) {
			inventario.addItem(kangaroo);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.mago")) {
			inventario.addItem(mago);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.hulk")) {
			inventario.addItem(hulk);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.ninja")) {
			inventario.addItem(ninja);
		} else {
			inventario.addItem();
		}
		if (p.hasPermission("alien.thor")) {
			inventario.addItem(thor);
		} else {
			inventario.addItem();
		}
		for (int i = 0; i < inventario.getSize(); i++) {
			while (inventario.getItem(i) == null) {
				inventario.setItem(i, vidro);
			}
		}

		p.openInventory(inventario);
	}

	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)
				|| (e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_AIR))
				&& (p.getItemInHand().getType() == Material.FEATHER)
				&& (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Kits"))) {
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
			seletorDeKits(p);
		}
	}

	@EventHandler
	public void ClickInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit PvP")) {
			p.closeInventory();
			Menus.confirmaPvP(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "   ")) {
			e.setCancelled(true);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Phantom")) {
			p.closeInventory();
			Menus.confirmaPhantom(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Sonic")) {
			p.closeInventory();
			Menus.confirmaSonic(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Kangaroo")) {
			p.closeInventory();
			Menus.confirmaKangaroo(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Mago")) {
			p.closeInventory();
			Menus.confirmaMago(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Hulk")) {
			p.closeInventory();
			Menus.confirmaHulk(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Ninja")) {
			p.closeInventory();
			Menus.confirmaNinja(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Thor")) {
			p.closeInventory();
			Menus.confirmaThor(p);
		}
	}
}
