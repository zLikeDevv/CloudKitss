package alien.gaming.menuaceitar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import alien.gaming.utils.Metodos;

public class Menus implements Listener {
	// Duplicaçao de codigo, me desculpe rafael .-.\\
	public static void confirmaPvP(Player p) {
		Inventory pvp = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarpv = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit PvP)", Material.WOOL);
		aceitarpv.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit PvP", Material.STONE_SWORD);

		ItemStack naoaceitarpv = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit PvP)", Material.WOOL);
		naoaceitarpv.setDurability((short) 14);

		pvp.setItem(0, aceitarpv);
		pvp.setItem(4, naoaceitarpv);
		pvp.setItem(2, icone);

		p.openInventory(pvp);
	}

	public static void confirmaPhantom(Player p) {
		Inventory phantom = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarph = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Phantom)", Material.WOOL);
		aceitarph.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Phantom", Material.FEATHER);

		ItemStack naoaceitarph = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Phantom)", Material.WOOL);
		naoaceitarph.setDurability((short) 14);

		phantom.setItem(0, aceitarph);
		phantom.setItem(4, naoaceitarph);
		phantom.setItem(2, icone);

		p.openInventory(phantom);
	}

	public static void confirmaSonic(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Sonic)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Sonic", Material.LAPIS_ORE);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Sonic)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	public static void confirmaKangaroo(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Kangaroo)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Kangaroo", Material.FIREWORK);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Kangaroo)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	public static void confirmaMago(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Mago)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Mago", Material.GLOWSTONE_DUST);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Mago)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	public static void confirmaHulk(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Hulk)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Hulk", Material.LEAVES_2);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Hulk)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	public static void confirmaNinja(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Ninja)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Ninja", Material.COAL);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Ninja)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	public static void confirmaThor(Player p) {
		Inventory sonic = Bukkit.createInventory(p, InventoryType.HOPPER);

		ItemStack aceitarsc = Metodos.criarItem(ChatColor.GREEN, "Aceitar §7(Kit Thor)", Material.WOOL);
		aceitarsc.setDurability((short) 5);

		ItemStack icone = Metodos.criarItem(ChatColor.GREEN, "Kit Thor", Material.STONE_AXE);

		ItemStack naoaceitarsc = Metodos.criarItem(ChatColor.RED, "Nao desejo §7(Kit Thor)", Material.WOOL);
		naoaceitarsc.setDurability((short) 14);

		sonic.setItem(0, aceitarsc);
		sonic.setItem(4, naoaceitarsc);
		sonic.setItem(2, icone);

		p.openInventory(sonic);
	}

	@EventHandler
	public void pvp(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		/// pvp
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit PvP)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/pvp");
			p.setGameMode(GameMode.ADVENTURE);
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit PvP)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit PvP")) {
			e.setCancelled(true);
			p.setGameMode(GameMode.ADVENTURE);
		}
		// phantom
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Phantom)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Phantom");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Phantom)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Phantom")) {
			e.setCancelled(true);
			p.setGameMode(GameMode.ADVENTURE);
		}
		// sonic
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Sonic)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Sonic");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Sonic)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Sonic")) {
			e.setCancelled(true);
			p.setGameMode(GameMode.ADVENTURE);
		}
		// kangaroo
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Kangaroo)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Kangaroo");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Kangaroo)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Kangaroo")) {
			e.setCancelled(true);
			p.setGameMode(GameMode.ADVENTURE);
		}
		// mago
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Mago)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Mago");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Mago)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Mago")) {
			e.setCancelled(true);
			p.setGameMode(GameMode.ADVENTURE);
		}
		// Hulk
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Hulk)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Hulk");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Hulk)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Hulk")) {
			e.setCancelled(true);
		}
		// ninja
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Ninja)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/Ninja");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Ninja)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Ninja")) {
			e.setCancelled(true);
		}
		//thor
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.GREEN + "Aceitar §7(Kit Thor)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/thor");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName()
				.equalsIgnoreCase(ChatColor.RED + "Nao desejo §7(Kit Thor)")) {
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§a§l >> Seleçao de kit foi cancelada!");
			p.setGameMode(GameMode.ADVENTURE);
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Thor")) {
			e.setCancelled(true);
		}
	}
}
