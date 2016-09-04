package br.com.tuning.phone;

import io.vertx.core.Vertx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		final Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new SpringServerVerticle(applicationContext));
		vertx.deployVerticle(new AppServerVerticle());
		System.out.println("Deployment done!");
	}
	
}
