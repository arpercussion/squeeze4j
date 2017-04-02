package com.obscured.squeeze4j;

import com.obscured.squeeze4j.api.SqueezePlayer;
import com.obscured.squeeze4j.api.SqueezeServer;
import com.obscured.squeeze4j.models.Genres;
import com.obscured.squeeze4j.models.SongInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {

		logger.trace("Entering application.");

		try {
			// server
			SqueezeServer server = new SqueezeServer();
			Genres genres = server.getGenres(null, null, null);
			System.out.println(genres.getCount());

			// player
			SqueezePlayer player = new SqueezePlayer("74:da:38:3b:4f:8c");
			SongInfo songInfo = player.getSongInfo("file:///mnt/usb/Between%20Interval/Autumn%20Continent/Between%20Interval%20-%20Autumn%20Continent%20-%2002%20-%20Submerged.mp3");
			System.out.println(songInfo.getId());

		} catch (Exception e) {
			logger.error(e);
		} finally {
			logger.trace("Exiting application.");
		}
	}
}
