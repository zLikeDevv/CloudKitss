package alien.gaming.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import alien.gaming.principal.Main;

public class ArraysAPI {

	// Modos\\
	public static ArrayList<Player> habilidade = new ArrayList<>();
	public static ArrayList<Player> modoSpawn = new ArrayList<>();
	public static ArrayList<Player> modoTutorial = new ArrayList<>();

	// Kits\\
	public static ArrayList<Player> pvp = new ArrayList<>();
	public static ArrayList<Player> phantom = new ArrayList<>();
	public static ArrayList<Player> sonic = new ArrayList<>();
	public static ArrayList<Player> kangaroo = new ArrayList<>();
	public static ArrayList<Player> mago = new ArrayList<>();
	public static ArrayList<Player> hulk = new ArrayList<>();
	public static ArrayList<Player> ninja = new ArrayList<>();
	public static ArrayList<Player> thor = new ArrayList<>();

	public static String nomeDoServer = Main.getPlugin().getConfig().getString("server").replace("&", "§");

	// Especiais
	public static ArrayList<String> cooldown = new ArrayList<String>();

	public static void removerKits(Player p) {
		habilidade.remove(p);
		pvp.remove(p);
		phantom.remove(p);
		sonic.remove(p);
		kangaroo.remove(p);
		mago.remove(p);
		thor.remove(p);
		hulk.remove(p);
	}

	public static void removeTudo(Player p) {
		modoSpawn.remove(p);
		modoTutorial.remove(p);
		removerKits(p);
	}

	public static void removeModos(Player p) {
		modoTutorial.remove(p);
		modoSpawn.remove(p);
	}

	public static void adicionaModoSpawn(Player p) {
		modoSpawn.add(p);
	}

	public static void adicionaModoTutorial(Player p) {
		modoTutorial.add(p);
	}

	public static void adicionaCoolDown(Player p) {
		cooldown.add(p.getName());
	}

	public static void removeCoolDown(Player p) {
		cooldown.remove(p.getName());
	}
}
