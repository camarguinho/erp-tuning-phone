package br.com.tuning.phone.verticle;

import org.springframework.context.ApplicationContext;

import br.com.tuning.phone.service.ProductService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;

public class SpringServerVerticle extends AbstractVerticle{
	
	private final ObjectMapper mapper = Json.mapper;
	private final ProductService productService;
	
	public SpringServerVerticle(final ApplicationContext applicationContext) {
		productService = (ProductService) applicationContext.getBean("productService"); 
	}
	
	private Handler<Message<String>> allProductsHandler(ProductService service) {
	    // It is important to use an executeBlocking construct here
	    // as the service calls are blocking (dealing with a database)
	    return msg -> vertx.<String>executeBlocking(future -> {
	          try {
	            future.complete(mapper.writeValueAsString(service.getAllProducts()));
	          } catch (JsonProcessingException e) {
	            System.out.println("Failed to serialize result");
	            future.fail(e);
	          }
	        },
	        result -> {
	          if (result.succeeded()) {
	            msg.reply(result.result());
	          } else {
	            msg.reply(result.cause().toString());
	          }
	        });
	  }
	
	@Override
	public void start() throws Exception {
		super.start();
		new AppServerVerticle(productService);
		vertx.eventBus().<String>consumer("example.all.products").handler(allProductsHandler(productService));
	}
	
	public ProductService getProductService(){
		return this.productService;
	}
	
}
