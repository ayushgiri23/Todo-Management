package com.ayush.TodoManagement;

import javax.ws.rs.ApplicationPath;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

@ApplicationPath("todos")
public class TodoManagementApplication extends Application<TodoManagementConfiguration> {

	public static void main(final String[] args) throws Exception {
		new TodoManagementApplication().run(args);
	}

	@Override
	public String getName() {
		return "TodoManagement";
	}

	/*
	 * private final HibernateBundle<TodoManagementConfiguration> hibernate1 = new
	 * HibernateBundle<TodoManagementConfiguration>( Task.class) {
	 * 
	 * @Override public DataSourceFactory
	 * getDataSourceFactory(TodoManagementConfiguration configuration) { return
	 * configuration.getDataSourceFactory(); } };
	 * 
	 * private final HibernateBundle<TodoManagementConfiguration> hibernate2 = new
	 * HibernateBundle<TodoManagementConfiguration>( Tag.class) {
	 * 
	 * @Override public DataSourceFactory
	 * getDataSourceFactory(TodoManagementConfiguration configuration) { return
	 * configuration.getDataSourceFactory(); } };
	 */

	@Override
	public void initialize(final Bootstrap<TodoManagementConfiguration> bootstrap) {
		/*
		 * bootstrap.addBundle(hibernate1); bootstrap.addBundle(hibernate2);
		 */
	}

	@Override
	public void run(final TodoManagementConfiguration configuration, final Environment environment) {
		// TODO: implement application
	}

}
