package br.com.tuning.phone.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.tuning.phone.configuration.SpringConfiguration;
import br.com.tuning.phone.verticle.AppServerVerticle;
import br.com.tuning.phone.verticle.ServerVerticle;
import io.vertx.core.Vertx;

public class AppRunner {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		final Vertx vertx = Vertx.vertx();
		
		ServerVerticle productVerticle = new ServerVerticle(applicationContext);
		ServerVerticle clientVerticle = new ServerVerticle(applicationContext);
		ServerVerticle supplierVerticle = new ServerVerticle(applicationContext);
		ServerVerticle saleVerticle = new ServerVerticle(applicationContext);
		
		AppServerVerticle asv = new AppServerVerticle(
				productVerticle.getProductService(), 
				clientVerticle.getClientService(),
				supplierVerticle.getSupplierService(),
				saleVerticle.getSaleService());
		
		vertx.deployVerticle(asv);
		
		System.out.println("Deployment done!");
	}
	
}
