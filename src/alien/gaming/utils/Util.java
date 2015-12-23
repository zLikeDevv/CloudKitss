package alien.gaming.utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffectType;

public class Util implements Listener {
	@EventHandler
	void russChuva(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	public boolean isDay(World world) {
		long time = world.getTime();
		if (time >= 13400) {
			return time == 0;
		} else {
			return false;
		}
	}

	@EventHandler
	public void onEntityDamageByEntity1(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Player)) {
			Player d = (Player) e.getDamager();
			if ((d.getItemInHand().getType() == Material.DIAMOND_SWORD)
					|| (d.getItemInHand().getType() == Material.WOOD_SWORD)
					|| (d.getItemInHand().getType() == Material.STONE_SWORD)
					|| (d.getItemInHand().getType() == Material.IRON_SWORD)
					|| (d.getItemInHand().getType() == Material.STONE_AXE)
					|| (d.getItemInHand().getType() == Material.FISHING_ROD)
					|| (d.getItemInHand().getType() == Material.WOOD_AXE))
				d.getItemInHand().setDurability((short) 0);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void NerfsDanos(EntityDamageByEntityEvent event) {
		if ((event.getDamager() instanceof Player)) {
			Player player = (Player) event.getDamager();
			if (event.getDamage() > 1.0D) {
				event.setDamage(event.getDamage() - 1.0D);
			}
			if ((event.getDamager() instanceof Player)) {
				if ((player.getFallDistance() > 0.0F) && (!player.isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					int NewDamage = (int) (event.getDamage() * 1.5D) - (int) event.getDamage();
					if (event.getDamage() > 1.0D) {
						event.setDamage(event.getDamage() - NewDamage);
					}
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(1.5D);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(2.5D);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(4.0D);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(5.0D);
				}
				if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
					event.setDamage(event.getDamage() + 1.0D);
				}
				if ((player.getFallDistance() > 0.0F) && (!player.isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.STONE_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.IRON_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if ((player.getFallDistance() > 0.0F)
							&& (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))) {
						if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
							event.setDamage(event.getDamage() + 1.5D);
						}
						if (player.getItemInHand().getType() == Material.STONE_SWORD) {
							event.setDamage(event.getDamage() + 1.5D);
						}
						if (player.getItemInHand().getType() == Material.IRON_SWORD) {
							event.setDamage(event.getDamage() + 1.5D);
						}
						if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							event.setDamage(event.getDamage() + 1.5D);
						}
					}
					if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
							&& (!player.isOnGround())) {
						if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
							event.setDamage(event.getDamage() + 0.5D);
						}
						if (player.getItemInHand().getType() == Material.STONE_SWORD) {
							event.setDamage(event.getDamage() + 0.5D);
						}
						if (player.getItemInHand().getType() == Material.IRON_SWORD) {
							event.setDamage(event.getDamage() + 0.5D);
						}
						if (player.getItemInHand().getType() == Material.DIAMOND_SWORD)
							event.setDamage(event.getDamage() + 0.5D);
					}
				}
			}
		}
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			if (p.getInventory().getChestplate() != null) {
				p.getInventory().getChestplate().setDurability((short) 0);
			}
			if (p.getInventory().getBoots() != null) {
				p.getInventory().getBoots().setDurability((short) 0);
			}
			if (p.getInventory().getLeggings() != null) {
				p.getInventory().getLeggings().setDurability((short) 0);
			}
			if (p.getInventory().getHelmet() != null)
				p.getInventory().getHelmet().setDurability((short) 0);
		}
	}

	@EventHandler
	public void NemPensarNosPlugins(PlayerCommandPreprocessEvent e) {
		if ((e.getMessage().equalsIgnoreCase("/pl")) || (e.getMessage().equalsIgnoreCase("/plugins"))
				|| (e.getMessage().equalsIgnoreCase("/plugin")) || (e.getMessage().equalsIgnoreCase("/bukkit:?"))
				|| (e.getMessage().equalsIgnoreCase("/bukkit:plugin"))
				|| (e.getMessage().equalsIgnoreCase("/bukkit:help")) || (e.getMessage().equalsIgnoreCase("/bukkit:pl"))
				|| (e.getMessage().equalsIgnoreCase("/ver")) || (e.getMessage().equalsIgnoreCase("/help"))
				|| (e.getMessage().equalsIgnoreCase("/bukkit:ver")) || (e.getMessage().equalsIgnoreCase("/logout"))
				|| (e.getMessage().equalsIgnoreCase("/me")) || (e.getMessage().equalsIgnoreCase("/bukkit:me"))
				|| (e.getMessage().equalsIgnoreCase("/?"))) {
			e.setCancelled(true);
			Player p = e.getPlayer();
			p.sendMessage("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=xXx=-=-=-=-=-=-=-=-=-=-=-=-=-|");
			p.sendMessage("§f| §aQue foi? Ah to ligado q ce gosto do pl                  §f|");
			p.sendMessage("§f| §aPlugin feito por Alein-Gaming[NetWork] §f                   |");
			p.sendMessage("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=xXx=-=-=-=-=-=-=-=-=-=-=-=-=-|");

			p.playSound(p.getLocation(), Sound.AMBIENCE_CAVE, 1.0f, 1.0f);

			p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);

			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
		}
	}

	@EventHandler
	void africa(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerColor(SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", " §"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", " §"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", " §"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", " §"));
		}
	}

	@EventHandler
	void naoColocarBlocosNoSurvival(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	void NaoQuebrarBlocosNoSurvival(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void openInvet(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!ArraysAPI.modoSpawn.contains(p)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void formato(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ArraysAPI.modoSpawn.contains(p)) {
			e.setFormat("§7§l§o SPAWN " + ChatColor.RESET + ChatColor.GRAY + p.getDisplayName() + " §6§l>> "
					+ ChatColor.WHITE + e.getMessage().replace("&", "§"));
		} else {
			e.setFormat("§7§l§o ARENA " + ChatColor.RESET + ChatColor.GRAY + p.getDisplayName() + " §6§l>> "
					+ ChatColor.WHITE + e.getMessage().replace("&", "§"));
		}
	}

	@EventHandler
	private void aoLevarDano(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		if (!ArraysAPI.modoSpawn.contains(p)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
}