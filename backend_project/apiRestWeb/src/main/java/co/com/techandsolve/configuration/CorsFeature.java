package co.com.techandsolve.configuration;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

/**
 * 
 * @author Ruben Dario Betancur Rairan <rbetancur@heinsohn.com.co>
 *
 */
@Provider
public class CorsFeature implements Feature {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.core.Feature#configure(javax.ws.rs.core.FeatureContext)
	 */
	@Override
	public boolean configure(FeatureContext context) {
		CorsFilter corsFilter = new CorsFilter();
		corsFilter.getAllowedOrigins().add("*");
		context.register(corsFilter);
		return true;
	}

}