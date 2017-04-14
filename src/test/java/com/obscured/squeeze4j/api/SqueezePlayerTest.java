package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.models.Mode;
import org.junit.*;

@Ignore
public class SqueezePlayerTest {

	private static SqueezePlayer player = null;

	@BeforeClass
	public static void beforeClass() {
		player = new SqueezePlayer("74:da:38:3b:4f:8c");
	}

	@AfterClass
	public static void afterClass() {
		player = null;
	}

	@Test
	public void getMode() throws Exception {
		Mode mode = player.getMode();

		Assert.assertNotNull("Mode is null", mode);
	}

	@Test
	public void getPath() throws Exception {
	}

	@Test
	public void getSongInfo() throws Exception {
	}

	@Test
	public void pause() throws Exception {
	}

	@Test
	public void mute() throws Exception {
	}

	@Test
	public void stop() throws Exception {
	}

	@Test
	public void power() throws Exception {
	}

	@Test
	public void previous() throws Exception {
	}

	@Test
	public void next() throws Exception {
	}

	@Test
	public void volume() throws Exception {
		int volume = player.volume(null);
		Assert.assertNotNull(volume);

		Integer newVolume = player.volume(42);
		Assert.assertNull(newVolume);
	}

	@Test
	public void getCurrentlyPlaying() throws Exception {
	}

	@Test
	public void play() throws Exception {
		String url = null;
		String genre = null;
		String artist = "Robert Davies";
		String album = null;
		player.play(url, genre, artist, album);
	}

	@Test
	public void play1() throws Exception {
	}

	@Test
	public void playPlaylist() throws Exception {
	}

}