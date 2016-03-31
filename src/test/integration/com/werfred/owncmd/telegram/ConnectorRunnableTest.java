package com.werfred.owncmd.telegram;

import org.junit.Assert;

import org.junit.Test;

public class ConnectorRunnableTest {

	@Test
	public void testGetUpdates() throws Exception {
		ConnectorRunnable connector = new ConnectorRunnable();
		String response = connector.getUpdates();
		
		Assert.assertNotNull(response);
	}

}
