package org.springframework.cloud.service.rabbit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.cloud.service.common.AmqpServiceInfo;

/**
 * 
 * @author Ramnivas Laddad
 *
 */
public class RabbitServiceInfoTest {
	@Test
	public void uriBasedParsing() {
		AmqpServiceInfo serviceInfo = new AmqpServiceInfo("id", "amqp://myuser:mypass@myhost:12345/myvhost");
		
		assertEquals("myhost", serviceInfo.getHost());
		assertEquals(12345, serviceInfo.getPort());
		assertEquals("myuser", serviceInfo.getUserName());
		assertEquals("mypass", serviceInfo.getPassword());
		assertEquals("myvhost", serviceInfo.getVirtualHost());
	}

	@Test
	public void uriBasedParsingDefaultVhost() {
		AmqpServiceInfo serviceInfo = new AmqpServiceInfo("id", "amqp://myuser:mypass@myhost:12345/");

		assertEquals("myhost", serviceInfo.getHost());
		assertEquals(12345, serviceInfo.getPort());
		assertEquals("myuser", serviceInfo.getUserName());
		assertEquals("mypass", serviceInfo.getPassword());
		assertNull(serviceInfo.getVirtualHost());
	}

	@Test(expected=IllegalArgumentException.class)
	public void missingScheme() {
		new AmqpServiceInfo("id",  "://myuser:mypass@:12345/myvhost");
	}

	@Test
	public void amqpsSchemeAccepted() {
		AmqpServiceInfo serviceInfo = new AmqpServiceInfo("id",  "amqps://myuser:mypass@myhost:12345/myvhost");
		assertEquals("amqps", serviceInfo.getScheme());
	}

	@Test(expected=IllegalArgumentException.class)
	public void missingHost() {
		new AmqpServiceInfo("id",  "amqp://myuser:mypass@:12345/myvhost");
	}

	@Test(expected=IllegalArgumentException.class)
	public void badUserInfo() {
		new AmqpServiceInfo("id",  "amqp://myuser@myhost/myvhost");
	}

	@Test(expected=IllegalArgumentException.class)
	public void missingUserInfo() {
		new AmqpServiceInfo("id",  "amqp://myhost:12345/myvhost");
	}

	@Test(expected=IllegalArgumentException.class)
	public void badVirtualHost() {
		new AmqpServiceInfo("id",  "amqp://myuser:mypass@myhost:12345/a/b");
	}
}
