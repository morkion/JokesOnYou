package io.github.morkion;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.plugin.java.JavaPlugin;

public class JokesOnYou extends JavaPlugin {

	@Override
	public void onEnable(){
		saveDefaultConfig();
		Timer timer = new Timer();
		TimerTask sayJoke = new TimerTask() {
			@Override
			public void run() {
				List<String> jokes = getConfig().getStringList("jokes");
				int index = new Random().nextInt(jokes.size());
				getServer().broadcastMessage("\""+jokes.get(index)+"\"");
			}
		};
		timer.schedule(sayJoke, 0l, 1000*getConfig().getInt("timeBetweenJokes"));
	}
}
