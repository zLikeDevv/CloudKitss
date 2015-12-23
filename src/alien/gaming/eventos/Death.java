package alien.gaming.eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.ScoreB;
import net.milkbowl.vault.economy.EconomyResponse;

public class Death implements Listener {
	public static EconomyResponse r;

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		String Kit = "§aNenhum";
		ScoreB.setScoreBoard(p, Kit);
		p.sendMessage("§a§l >> Tu morres-te!");
		e.setDeathMessage(null);
		ArraysAPI.removeTudo(p);
		// LaicosoDev™ - [ImperialCoders] - [WomboTeam] - I Love Java<3
		ArraysAPI.adicionaModoSpawn(p);
		ArraysAPI.removeCoolDown(p);
		e.getDrops().clear();
		Location coords = p.getLocation();
		coords.getWorld().strikeLightningEffect(coords);
		Block block = coords.getBlock();
		block.setType(Material.AIR);
		p.teleport(p.getWorld().getSpawnLocation());
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getKiller();
		Player otro = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			p.sendMessage("§a§l >> Voce matou o jogador: " + otro.getName());
			r = Main.econ.depositPlayer(p.getName(), 10.00D);
			if (r.transactionSuccess()) {
				p.sendMessage("§a§l >> Voce ganhou mais 10 Dollars");
			} else {
				p.sendMessage(
						"§c§l Sua economia de dollars nao estao funcionando, fale com um administrador para resolver o seu caso!");
			}

		}
	}
}
