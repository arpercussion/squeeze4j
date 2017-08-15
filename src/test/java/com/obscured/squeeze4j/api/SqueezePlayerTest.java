package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.enums.PlayerMode;
import com.obscured.squeeze4j.models.SongInfo;
import com.obscured.squeeze4j.models.Status;
import org.junit.*;

@Ignore
public class SqueezePlayerTest {

    private static SqueezePlayer player = null;
    private static String path = "file:///mnt/usb/Robert%20Davies/Afterlight/Robert%20Davies%20-%20Afterlight%20-%2001%20-%20Meadow%20Glimmer.mp3";
    private static Integer playlistId = 48587;

    @BeforeClass
    public static void beforeClass() {
        player = new SqueezePlayer("74:da:38:3b:4f:8c");
    }

    @AfterClass
    public static void afterClass() {
        player = null;
    }

    @Test
    public void getStatus() throws Exception {
        Status status = player.getStatus();

        Assert.assertNotNull("getStatus is null", status);
        Assert.assertNotNull("getStatus volume is null", status.getMixerVolume());
    }

    @Test
    public void seek() throws Exception {
        Double before = player.seek(null);
        player.seek(10.0);
        Double after = player.seek(null);

        Assert.assertTrue("seek not updated", after > (before + 9.0));
    }

    @Test
    public void getPath() throws Exception {
        String path = player.getPath();

        Assert.assertNotNull("getPath is null", path);
    }

    @Test
    public void getSongInfo() throws Exception {
        player.play(path, null, null, null);
        SongInfo songInfo = player.getSongInfo(path);

        Assert.assertNotNull("getSongInfo is null", songInfo);
    }

    @Test
    public void mode() throws Exception {
        player.mode(PlayerMode.MUTE, null);
        Integer volume = player.volume(null);

        Assert.assertTrue("mode not set", volume < 0);
    }

    @Test
    public void pause() throws Exception {
        player.play(path, null, null, null);
        Thread.sleep(1000);
        player.pause(1);
        Thread.sleep(1000);
        Status status = player.getStatus();

        Assert.assertTrue("pause not applied", status.getMode().equalsIgnoreCase("pause"));
    }

    @Test
    public void mute() throws Exception {
        player.mute(1);
        Integer volume = player.volume(null);
        Assert.assertTrue("pause not applied", volume < 0);
    }

    @Test
    public void stop() throws Exception {
        player.stop();
        Thread.sleep(1000);
        Status status = player.getStatus();

        Assert.assertTrue("stop not applied", status.getMode().equalsIgnoreCase("stop"));
    }

    @Test
    public void power() throws Exception {
        Boolean state = player.power(null);
        Assert.assertNotNull("power has value", state);

        player.power(state ? 0 : 1);

        Boolean newState = player.power(null);
        Assert.assertNotEquals("power not set", state, newState);

        player.power(1);
    }

    @Test
    public void previous() throws Exception {
        player.playPlaylist(playlistId.toString());
        Thread.sleep(1000);
        Status status = player.getStatus();
        player.previous();
        Thread.sleep(1000);
        Status newStatus = player.getStatus();
        Assert.assertTrue("previous", newStatus.getPlaylistCurIndex().compareTo(status.getPlaylistCurIndex()) > 0);
    }

    @Test
    public void next() throws Exception {
        player.playPlaylist(playlistId.toString());
        Thread.sleep(1000);
        Status status = player.getStatus();
        player.next();
        Thread.sleep(1000);
        Status newStatus = player.getStatus();
        Assert.assertTrue("next", newStatus.getPlaylistCurIndex().compareTo(status.getPlaylistCurIndex()) > 0);
    }

    @Test
    public void volume() throws Exception {
        Integer i = 42;
        Integer volume = player.volume(null);
        Assert.assertNotNull("volume is null", volume);

        player.volume(i);
        Assert.assertEquals("volume not set", i, volume);
    }

    @Test
    public void getCurrentlyPlaying() throws Exception {
        SongInfo current = player.getCurrentlyPlaying();
        Assert.assertNotNull("getCurrentlyPlaying", current);
    }

    @Test
    public void play() throws Exception {
        player.play(null, null, "Robert Davies", null);
    }

    @Test
    public void playPlaylist() throws Exception {
        player.playPlaylist(playlistId.toString());
        Status status = player.getStatus();
        Assert.assertEquals("playPlaylist not set", status.getPlaylistId(), playlistId);
    }
}