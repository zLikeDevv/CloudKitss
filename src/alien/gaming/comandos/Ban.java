package alien.gaming.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		if ((cmd.equalsIgnoreCase("banir")) && (p.hasPermission("alien.banir"))) {
			if (args.length >= 2) {
				Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					if (!target.isOp()) {
						target.setBanned(true);
						target.kickPlayer("§a§l Voce foi banido por " + args[1] + ", vez q quebrou a regra " + args[2]);
						
					} else {
						p.sendMessage("§c§l >> Esse jogador nao pode ser banido.");
					}
				} else {
					p.sendMessage("§c§l >> Jogador inexistente.");
				}
			} else {
				p.sendMessage("§c§l >> Erro de digito, tente /ban (player) (porque) (vez q usou)");
			}
		}
		return false;
	}
}