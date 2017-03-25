package com.obscured.squeeze4j.api;

import com.obscured.squeeze4j.models.PlayerWrapper;
import org.junit.Assert;
import org.junit.BeforeClass;


public class SqueezeServerTest {

	static SqueezeServer server;

	@BeforeClass
	public static void beforeClass() {
		server = new SqueezeServer();
	}

	//@Test
	public void getPlayers() throws Exception {
		PlayerWrapper playerWrapper = server.getPlayers();

		Assert.assertNotNull("player wrapper is null", playerWrapper);
		Assert.assertNotNull("player wrapper count is null", playerWrapper.getCount());
	}

}