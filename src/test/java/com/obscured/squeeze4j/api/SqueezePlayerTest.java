package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.models.Status;
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
    public void getStatus() throws Exception {
		Status status = player.getStatus();

		Assert.assertNotNull("Status is null", status);
        Assert.assertNotNull("Status volume is null", status.getMixerVolume());

//        String json = "{\"player_name\":\"akrmusic\",\"player_connected\":1,\"player_ip\":\"192.168.1.13:37916\",\"power\":1,\"signalstrength\":0,\"mode\":\"stop\",\"mixer volume\":60,\"playlist repeat\":1,\"playlist shuffle\":1,\"playlist mode\":\"off\",\"seq_no\":0,\"playlist_cur_index\":0,\"playlist_timestamp\":1502627314.12569,\"playlist_tracks\":1,\"digital_volume_control\":1,\"playlist_loop\":[{\"playlist index\":0,\"id\":45808,\"title\":\"One\",\"coverid\":\"a31606fb\",\"genre\":\"Rock\",\"artist\":\"Metallica\",\"band\":\"Metallica\",\"composer\":\"Lars Ulrich\",\"album_id\":\"4497\",\"album\":\"...And Justice for All\",\"duration\":\"446.693\",\"tracknum\":\"4\",\"year\":\"0\",\"bitrate\":\"319kbps CBR\",\"artist_ids\":\"4945\",\"band_ids\":\"4945\",\"composer_ids\":\"4350\",\"url\":\"file:///mnt/usb/Metallica/And%20Justice%20for%20All/Metallica%20-%20...And%20Justice%20for%20All%20-%20One.mp3\",\"type\":\"mp3\",\"artwork_track_id\":\"a31606fb\"}]}";

//        final ObjectMapper mapper = new ObjectMapper();
//        Status status = mapper.readValue(json, Status.class);
//        Assert.assertNotNull(status);
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