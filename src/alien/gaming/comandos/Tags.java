package alien.gaming.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;

public class Tags implements CommandExecutor {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		if (Label.equalsIgnoreCase("Tag")) {
			Player p = (Player) Sender;

			if (Args.length == 0) {
				Sender.sendMessage("Erro de digito, tente /tag ( tags )");
				return true;
			}

			if (Args[0].equalsIgnoreCase("DONO")) {
				if (!p.hasPermission("tag.dono")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: §4§o§lDONO");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName("§4§o§lDONO§4§l§o " + p.getName() + ChatColor.RESET);
				String Dono = ChatColor.DARK_RED + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§4§l§oDONO ");
				if (Dono.length() == 17) {
					Dono = Dono.substring(0, 17);
				}

				p.setPlayerListName(Dono);
			}

			if (Args[0].equalsIgnoreCase("ADMIN")) {
				if (!p.hasPermission("tag.admin")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: §c§o§lADMIN");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName(ChatColor.RED + "§c§l§oADMIN " + p.getName() + ChatColor.RESET);
				String Admin = ChatColor.RED + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§c§l§oADMIN ");
				if (Admin.length() == 17) {
					Admin = Admin.substring(0, 17);
				}
				p.setPlayerListName(Admin);
			}

			if (Args[0].equalsIgnoreCase("MOD")) {
				if (!p.hasPermission("tag.mod")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: §5§o§lMOD");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName("§5§oMOD§5§o " + p.getName() + ChatColor.RESET);
				String Mod = ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§5§l§oMOD ");
				if (Mod.length() == 17) {
					Mod = Mod.substring(0, 17);
				}
				p.setPlayerListName(Mod);
			}

			if (Args[0].equalsIgnoreCase("TRIAL")) {
				if (!p.hasPermission("tag.trial")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: " + ChatColor.LIGHT_PURPLE + "§o§lTRIAL");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName(ChatColor.LIGHT_PURPLE + "§oTRIAL§5§o " + p.getName() + ChatColor.RESET);
				String trial = ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), ChatColor.LIGHT_PURPLE + "§l§oTRIAL ");
				if (trial.length() == 17) {
					trial = trial.substring(0, 17);
				}
				p.setPlayerListName(trial);
			}

			if (Args[0].equalsIgnoreCase("Youtuber")) {
				if (!p.hasPermission("tag.youtuber")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}

				p.sendMessage("§a§l >> Tag alterada para: " + "§b§o§lYoutuber ");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName("§b§o§lYT§b§o " + p.getName() + ChatColor.RESET);
				String Youtuber = ChatColor.AQUA + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§b§l§oYT ");

				if (Youtuber.length() == 17) {
					Youtuber = Youtuber.substring(0, 17);
				}
				p.setPlayerListName(Youtuber);
			}

			if (Args[0].equalsIgnoreCase("Vip")) {
				if (!p.hasPermission("tag.vip")) {

					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}

				p.sendMessage("§a§l >> Tag alterada para: " + "§a§o§lVIP");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName("§a§o§lVIP§a§o " + p.getName() + ChatColor.RESET);
				String Pro = ChatColor.GREEN + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§a§l§oVIP ");

				if (Pro.length() == 17) {
					Pro = Pro.substring(0, 17);
				}
				p.setPlayerListName(Pro);
			}
			if (Args[0].equalsIgnoreCase("VIP+")) {
				if (!p.hasPermission("tag.vip+")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}

				p.sendMessage("§a§l >> Tag alterada para: " + "§a§o§lVIP++");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName("§a§o§lVIP+§a§o " + p.getName() + ChatColor.RESET);
				String ProEterno = ChatColor.GREEN + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§a§l§oVIP+ ");

				if (ProEterno.length() == 17) {
					ProEterno = ProEterno.substring(0, 17);
				}
				p.setPlayerListName(ProEterno);
			}

			if (Args[0].equalsIgnoreCase("Normal")) {
				if (!p.hasPermission("tag.normal+")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}

				p.setDisplayName(" §7" + p.getName() + ChatColor.RESET);
				NametagAPI.resetNametag(p.getName());
				String Normal = ChatColor.WHITE + p.getName() + ChatColor.RESET;
				if (Normal.length() == 17) {
					Normal = Normal.substring(0, 17);
				}
				p.setPlayerListName(Normal);
			}
			if (Args[0].equalsIgnoreCase("CODER")) {
				if (!p.hasPermission("tag.CODER")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: " + "§b§o§lCODER");
				p.setDisplayName("§b§l§oCODER §b" + p.getName() + ChatColor.RESET);
				String Coder = ChatColor.AQUA + p.getName() + ChatColor.RESET;
				NametagAPI.resetNametag(p.getName());
				NametagAPI.setPrefix(p.getName(), "§b§l§oCODER ");
				if (Coder.length() == 17) {
					Coder = Coder.substring(0, 17);
				}
				p.setPlayerListName(Coder);
			}
			if (Args[0].equalsIgnoreCase("MVP")) {
				if (!p.hasPermission("Tag.MVP")) {
					p.sendMessage("§a§l >> Tu nao tens permissao!");
					return true;
				}
				p.sendMessage("§a§l >> Tag alterada para: " + "§6§o§lMVP");
				NametagAPI.resetNametag(p.getName());
				p.setDisplayName(" §6 §oMVP§6 " + p.getName() + ChatColor.RESET);
				String MVP = ChatColor.DARK_GREEN + p.getName() + ChatColor.RESET;
				NametagAPI.setPrefix(p.getName(), "§6§l§oMVP");
				if (MVP.length() == 17) {
					MVP = MVP.substring(0, 17);
				}
				p.setPlayerListName(MVP);
			}

		}

		return false;
	}

}