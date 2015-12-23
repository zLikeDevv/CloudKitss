package alien.gaming.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Metodos {

	public static ItemStack criarItem(ChatColor cor, String nome, Material material) {
		ItemStack item = new ItemStack(material);
		ItemMeta zitem = item.getItemMeta();
		zitem.setDisplayName(cor + nome);
		item.setItemMeta(zitem);

		return item;
	}

	public static ItemStack criarItem(ChatColor cor, String nome, Material material, short corDoBloco) {
		ItemStack item = new ItemStack(material);
		ItemMeta zitem = item.getItemMeta();
		zitem.setDisplayName(cor + nome);
		item.setDurability((short) corDoBloco);
		item.setItemMeta(zitem);

		return item;
	}

	public static ItemStack criarItem(ChatColor cor, String nome, Material material, int tamanho) {
		ItemStack item = new ItemStack(material);
		ItemMeta zitem = item.getItemMeta();
		zitem.setDisplayName(cor + nome);
		item.setAmount(tamanho);
		item.setItemMeta(zitem);

		return item;
	}

	public static ItemStack criarItem(ChatColor cor, String nome, Material material, Enchantment enchant, int tanto,
			boolean vddOrFalse) {
		ItemStack item = new ItemStack(material);
		ItemMeta zitem = item.getItemMeta();
		zitem.setDisplayName(cor + nome);
		zitem.addEnchant(enchant, tanto, vddOrFalse);
		item.setItemMeta(zitem);

		return item;
	}

	public static void seletores(Player p) {
		ItemStack kits = criarItem(ChatColor.AQUA, "Kits", Material.FEATHER);
		ItemStack lojaBuy = criarItem(ChatColor.AQUA, "Loja §7(BuyCraft)", Material.DIAMOND);
		ItemStack bussola = criarItem(ChatColor.AQUA, "Warps", Material.COMPASS);
		ItemStack ajuda = criarItem(ChatColor.AQUA, "Ajuda", Material.BONE);
		ItemStack gadgets = criarItem(ChatColor.AQUA, "Gadgets", Material.PAPER);
		ItemStack vine = criarItem(ChatColor.AQUA, "  ", Material.VINE);

		// Setando\\
		p.getInventory().setItem(0, kits);
		p.getInventory().setItem(1, vine);
		p.getInventory().setItem(2, lojaBuy);
		p.getInventory().setItem(3, vine);
		p.getInventory().setItem(4, bussola);
		p.getInventory().setItem(5, vine);
		p.getInventory().setItem(6, ajuda);
		p.getInventory().setItem(7, vine);
		p.getInventory().setItem(8, gadgets);
	}
	public static void kitAdmin(Player p){
		ItemStack feather = criarItem(ChatColor.GREEN, "Player-Info", Material.FEATHER);
		ItemStack bed = criarItem(ChatColor.GREEN, "Prender-Player", Material.BEDROCK);
		
		p.getInventory().setItem(0, feather);
		p.getInventory().setItem(8, bed);
		
	}
}
