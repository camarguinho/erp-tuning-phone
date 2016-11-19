package br.com.tuning.phone.verticle;

import org.springframework.context.ApplicationContext;

import br.com.tuning.phone.service.ClientService;
import br.com.tuning.phone.service.ProductService;
import br.com.tuning.phone.service.SaleService;
import br.com.tuning.phone.service.SupplierService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;

public class ServerVerticle extends AbstractVerticle{
	
	private final ObjectMapper mapper = Json.mapper;
	
	private final ProductService productService;
	private final ClientService clientService;
	private final SupplierService supplierService;
	private final SaleService saleService;
	
	public ServerVerticle(final ApplicationContext applicationContext) {
		productService = (ProductService) applicationContext.getBean("productService"); 
		clientService = (ClientService) applicationContext.getBean("clientService");
		supplierService = (SupplierService) applicationContext.getBean("supplierService");
		saleService = (SaleService) applicationContext.getBean("saleService");
	}
	
	private Handler<Message<String>> productsHandler(ProductService service) {
	    // It is important to use an executeBlocking construct here
	    // as the service calls are blocking (dealing with a database)
	    return msg -> vertx.<String>executeBlocking(future -> {
	          try {
	            future.complete(mapper.writeValueAsString(service));
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
	
	private Handler<Message<String>> clientsHandler(ClientService service) {
	    // It is important to use an executeBlocking construct here
	    // as the service calls are blocking (dealing with a database)
	    return msg -> vertx.<String>executeBlocking(future -> {
	          try {
	            future.complete(mapper.writeValueAsString(service));
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
	
	private Handler<Message<String>> suppliersHandler(SupplierService service) {
	    // It is important to use an executeBlocking construct here
	    // as the service calls are blocking (dealing with a database)
	    return msg -> vertx.<String>executeBlocking(future -> {
	          try {
	            future.complete(mapper.writeValueAsString(service));
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
	
	private Handler<Message<String>> salesHandler(SaleService service) {
	    // It is important to use an executeBlocking construct here
	    // as the service calls are blocking (dealing with a database)
	    return msg -> vertx.<String>executeBlocking(future -> {
	          try {
	            future.complete(mapper.writeValueAsString(service));
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
		new AppServerVerticle(productService, clientService, supplierService, saleService);
		vertx.eventBus().<String>consumer("allServices")
		.handler(productsHandler(productService))
		.handler(clientsHandler(clientService))
		.handler(suppliersHandler(supplierService))
		.handler(salesHandler(saleService));
	}
	
	public ProductService getProductService(){
		return this.productService;
	}
	
	public ClientService getClientService(){
		return this.clientService;
	}
	
	public SupplierService getSupplierService(){
		return this.supplierService;
	}
	
	public SaleService getSaleService(){
		return this.saleService;
	}
	
}
