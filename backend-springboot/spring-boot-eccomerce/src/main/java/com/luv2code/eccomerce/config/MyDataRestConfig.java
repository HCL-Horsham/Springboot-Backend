package com.luv2code.eccomerce.config;

import java.util.ArrayList;


import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.eccomerce.entity.Country;
import com.luv2code.eccomerce.entity.Order;
import com.luv2code.eccomerce.entity.Product;
import com.luv2code.eccomerce.entity.ProductCategory;
import com.luv2code.eccomerce.entity.State;



@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;
	
	private EntityManager entityManager;

	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub

		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, 
											HttpMethod.DELETE, HttpMethod.PATCH};

		// disable Http Methods for Product & Product Category: PUT, POST, DELETE
		disableHttpMethods(Product.class, config, theUnsupportedActions);
		disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
		disableHttpMethods(Country.class, config, theUnsupportedActions);
		disableHttpMethods(State.class, config, theUnsupportedActions);
		disableHttpMethods(Order.class, config, theUnsupportedActions);

		exposeIds(config);
		
		//configure cors mapping
		
		cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);
	}

	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration().forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		List<Class> entityClasses = new ArrayList<>();

		for (EntityType tempEntityType: entities) {
			entityClasses.add(tempEntityType.getJavaType());

		}
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}

}