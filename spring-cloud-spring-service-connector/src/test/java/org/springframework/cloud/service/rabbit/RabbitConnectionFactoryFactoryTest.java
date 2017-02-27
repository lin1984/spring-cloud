package org.springframework.cloud.service.rabbit;

import org.mockito.Mock;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.cloud.service.AbstractCloudServiceConnectorFactoryTest;
import org.springframework.cloud.service.ServiceConnectorConfig;
import org.springframework.cloud.service.common.AmqpServiceInfo;
import org.springframework.cloud.service.messaging.RabbitConnectionFactoryFactory;

/**
 * 
 * @author Ramnivas Laddad
 *
 */
public class RabbitConnectionFactoryFactoryTest extends AbstractCloudServiceConnectorFactoryTest<RabbitConnectionFactoryFactory, ConnectionFactory, AmqpServiceInfo> {
	@Mock ConnectionFactory mockConnector;
	
	public RabbitConnectionFactoryFactory createTestCloudServiceConnectorFactory(String id, ServiceConnectorConfig config) {
		return new RabbitConnectionFactoryFactory(id, config);
	}
	
	public Class<ConnectionFactory> getConnectorType() {
		return ConnectionFactory.class;
	}
	
	public ConnectionFactory getMockConnector() {
		return mockConnector;
	}
	
	public AmqpServiceInfo getTestServiceInfo(String id) {
		return new AmqpServiceInfo(id, "host", 0, "username", "password", "vh");
	}
}
