package org.springframework.cloud.config.java;

import org.springframework.cloud.service.common.PostgresqlServiceInfo;
import org.springframework.cloud.service.relational.PostgresqlDataSourceCreator;

/**
 * 
 * @author Ramnivas Laddad
 *
 */
public class DataSourceJavaConfigPostgesqlTest extends DataSourceJavaConfigTest {
	@Override
	public PostgresqlServiceInfo createService(String id) {
		return createPostgresqlService(id);
	}

	@Override
	protected String getDriverClassName() {
		return PostgresqlDataSourceCreator.DRIVERS[0];
	}

	@Override
	protected String getValidationQuery() {
		return PostgresqlDataSourceCreator.VALIDATION_QUERY;
	}
}


