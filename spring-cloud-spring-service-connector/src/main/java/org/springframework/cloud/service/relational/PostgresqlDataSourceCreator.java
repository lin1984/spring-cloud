package org.springframework.cloud.service.relational;

import org.springframework.cloud.service.common.PostgresqlServiceInfo;


/**
 * 
 * @author Ramnivas Laddad
 *
 */
public class PostgresqlDataSourceCreator extends DataSourceCreator<PostgresqlServiceInfo> {
	
	public static final String[] DRIVERS = new String[]{"org.postgresql.Driver"};
	public static final String VALIDATION_QUERY = "SELECT 1";
	
	public PostgresqlDataSourceCreator() {
	    super("spring-cloud.postgresql.driver", DRIVERS, VALIDATION_QUERY);    
	}
}
