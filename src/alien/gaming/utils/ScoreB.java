package alien.gaming.utils;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import alien.gaming.principal.Main;

public class ScoreB implements Listener {
	public static int getPing(Player p) {
		return ((CraftPlayer) p).getHandle().ping;
	}

	public static void setScoreBoard(Player p, String Kit) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = score.registerNewObjective("Score", "KitPvP");
		o.setDisplayName("§f" + Main.getPlugin().getConfig().getString("server").replace("&", "§"));
		Main.getPlugin().saveConfig();
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score score0 = o.getScore(Bukkit.getOfflinePlayer("§2"));
		Score score1 = o.getScore(Bukkit.getOfflinePlayer("§fMatou:§a " + Main.getPlugin().getConfig()
				.getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString())));
		Score score5 = o.getScore(Bukkit.getOfflinePlayer("§5"));
		Score score2 = o.getScore(Bukkit.getOfflinePlayer("§fMorreu:§a " + Main.getPlugin().getConfig()
				.getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString())));
		Score score4 = o.getScore(Bukkit.getOfflinePlayer("§3"));
		Score score3 = o.getScore(Bukkit.getOfflinePlayer("§fXp:§a " + Main.econ.getBalance(p)));
		Score score6 = o.getScore(Bukkit.getOfflinePlayer("§fPing: §a" + getPing(p)));
		Score score7 = o.getScore(Bukkit.getOfflinePlayer("§3"));
		Score score8 = o.getScore(Bukkit.getOfflinePlayer("§fKit: "));
		Score score9 = o.getScore(Bukkit.getOfflinePlayer("§a" + Kit));

		score0.setScore(14);
		score1.setScore(13);
		score5.setScore(12);
		score2.setScore(11);
		score4.setScore(10);
		score3.setScore(9);
		score6.setScore(8);
		score7.setScore(7);
		score8.setScore(6);
		score9.setScore(5);
	
		p.setScoreboard(score);
	}
}