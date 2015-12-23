package alien.gaming.seletores;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import alien.gaming.principal.Main;
import alien.gaming.utils.Metodos;
import net.milkbowl.vault.economy.EconomyResponse;

public class Loja implements Listener {
	public static EconomyResponse r;

	public static void seletorDeVips(Player p) {
		Inventory inventario = Bukkit.createInventory(p, 54, "§a§lLoja-Vips");

		ItemStack vipI = Metodos.criarItem(ChatColor.GREEN, "Vip-I §7(Clique)", Material.IRON_BLOCK,
				Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		ItemStack vipII = Metodos.criarItem(ChatColor.GREEN, "Vip-II §7(Clique)", Material.GOLD_BLOCK,
				Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		ItemStack vipIII = Metodos.criarItem(ChatColor.GREEN, "Vip-III §7(Clique)", Material.DIAMOND_BLOCK,
				Enchantment.LOOT_BONUS_BLOCKS, 0, true);

		ItemStack vidro = Metodos.criarItem(ChatColor.GREEN, "   ", Material.STAINED_GLASS_PANE);
		vidro.setDurability((short) 5);
		inventario.setItem(11, vipI);
		inventario.setItem(13, vipII);
		inventario.setItem(15, vipIII);
		for (int i = 0; i < inventario.getSize(); i++) {
			while (inventario.getItem(i) == null) {
				inventario.setItem(i, vidro);
			}
		}

		p.openInventory(inventario);
	}

	public static void seletorDeKits(Player p) {
		Inventory inventario = Bukkit.createInventory(p, 27, "§a§lLoja-Kits");

		ItemStack vipI = Metodos.criarItem(ChatColor.GREEN, "Sonic§7 (500.00 Dollars)", Material.LAPIS_BLOCK);
		ItemStack vidro = Metodos.criarItem(ChatColor.GREEN, "   ", Material.STAINED_GLASS_PANE);
		vidro.setDurability((short) 5);
		inventario.setItem(14, vipI);
		for (int i = 0; i < inventario.getSize(); i++) {
			while (inventario.getItem(i) == null) {
				inventario.setItem(i, vidro);
			}
		}

		p.openInventory(inventario);
	}

	public static void seletorDeTiposLoja(Player p) {
		Inventory inventario = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack vips = Metodos.criarItem(ChatColor.GREEN, "Loja-Vips", Material.IRON_BLOCK,
				Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		ItemStack kits = Metodos.criarItem(ChatColor.GREEN, "Loja-Kits", Material.DIAMOND_BLOCK,
				Enchantment.LOOT_BONUS_BLOCKS, 0, true);

		ItemStack vidro = Metodos.criarItem(ChatColor.GREEN, "   ", Material.STAINED_GLASS_PANE);
		vidro.setDurability((short) 5);
		inventario.setItem(0, vips);

		inventario.setItem(4, kits);
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
				&& (p.getItemInHand().getType() == Material.DIAMOND) && (p.getItemInHand().getItemMeta()
						.getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Loja §7(BuyCraft)"))) {
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
			seletorDeTiposLoja(p);
		}
	}

	@SuppressWarnings("deprecation")
	public static void verificaSonic(Player p) {
		if (!Main.perms.has(p, "alien.sonic")) {
			if (Main.econ.has(p.getName(), 500.00D)) {
				Main.econ.withdrawPlayer(p.getName(), 500.00D);
				p.sendMessage("§a§l >> Perdeste 500.00 Dollars por comprar o kit sonic, Relogue-se para receber o kit!");
				for (World world : Bukkit.getServer().getWorlds()) {
					Main.perms.playerAdd(world, p.getName(), "alien.sonic");
				}
				p.closeInventory();
			} else {
				p.sendMessage("§a§l >> Nao tens XP suficiente!");
				p.closeInventory();
			}
		} else {
			p.sendMessage("§a§l >> Ja tens esse kit!");
			p.closeInventory();
		}
	}

	@EventHandler
	public void ClickInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		// DentroDoSeletorDeVips\\
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Vip-I §7(Clique)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage(Main.getPlugin().getConfig().getString("siteVipI").replace("&", "§"));
			Main.getPlugin().saveConfig();
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Vip-II §7(Clique)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage(Main.getPlugin().getConfig().getString("siteVipII").replace("&", "§"));
			Main.getPlugin().saveConfig();
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Vip-III §7(Clique)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage(Main.getPlugin().getConfig().getString("siteVipIII").replace("&", "§"));
			Main.getPlugin().saveConfig();
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "  ")) {
			e.setCancelled(true);
		}
		// DentroDoSeletorDeKits\\
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Loja-Vips")) {
			e.setCancelled(true);
			p.closeInventory();
			seletorDeVips(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Loja-Kits")) {
			e.setCancelled(true);
			seletorDeKits(p);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Sonic§7 (500.00 Dollars)")) {
			e.setCancelled(true);

			verificaSonic(p);
		}
	}
}
