package br.com.tuning.phone.main;

import io.vertx.core.Vertx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.tuning.phone.configuration.SpringConfiguration;
import br.com.tuning.phone.verticle.AppServerVerticle;
import br.com.tuning.phone.verticle.SpringServerVerticle;

public class AppRunner {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		final Vertx vertx = Vertx.vertx();
		SpringServerVerticle spv = new SpringServerVerticle(applicationContext);
		AppServerVerticle asv = new AppServerVerticle(spv.getProductService());
		vertx.deployVerticle(spv);
		vertx.deployVerticle(asv);
		System.out.println("Deployment done!");
	}
	
}
