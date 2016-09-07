package br.com.tuning.phone;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.ArrayList;
import java.util.List;

public class AppServerVerticle extends AbstractVerticle{

	private List<Product> products = new ArrayList<Product>();
	
	private ProductService productService;
	
	public AppServerVerticle(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void start(Future<Void> fut) throws Exception {
		super.start();
		Router router = Router.router(vertx);
		setRoutingContext(router);
		createServer(fut, router);
		products = productService.getAllProducts();
	}	
	
	private void setRoutingContext(Router router) {
		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response
			.putHeader("content-type", "text/html")
			.end("<h1>Bora de Rest!</h1>");
		});
		
		router.route("/assets/*").handler(StaticHandler.create("assets"));
		router.get("/api/products").handler(this::getAll);
		router.route("/api/products*").handler(BodyHandler.create());
		router.post("/api/products").handler(this::addOne);
		router.get("/api/products/:id").handler(this::getOne);
		router.put("/api/products/:id").handler(this::updateOne);
		router.delete("/api/products/:id").handler(this::deleteOne);
	}

	private void createServer(Future<Void> fut, Router router) {
		vertx
		.createHttpServer()
		.requestHandler(router::accept)
		.listen(
				config().getInteger("http.port", 8080),
				result -> {
					if(result.succeeded()){
						fut.complete();
					} else {
						fut.fail(result.cause());
					}
				}
		);
	}

	private void getAll(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(products));
	}

	private void addOne(RoutingContext routingContext) {
		JsonObject json = routingContext.getBodyAsJson();
		
		final Product product = new Product(json.getString("name").toUpperCase(), 
				new Double(json.getString("value")));
		productService.saveProduct(product);
		routingContext.response()
		.setStatusCode(201)
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(product));
	}

	private void deleteOne(RoutingContext routingContext) {
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			products.remove(idAsInteger);
		}
		routingContext.response().setStatusCode(204).end();
	}

	private void updateOne(RoutingContext routingContext) {
		final String id = routingContext.request().getParam("id");
		JsonObject json = routingContext.getBodyAsJson();
		if (id == null || json == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			final Integer idAsInteger = Integer.valueOf(id);
			Product product = products.get(idAsInteger);
			if (product == null) {
				routingContext.response().setStatusCode(404).end();
			} else {
				product.setName(json.getString("name").toUpperCase());
				product.setValue(new Double(json.getString("value")));
				routingContext.response()
				.putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(product));
			}
		}
	}

	private void getOne(RoutingContext routingContext) {
		final String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			final Integer idAsInteger = Integer.valueOf(id);
			Product product = products.get(idAsInteger);
			if (product == null) {
				routingContext.response().setStatusCode(404).end();
			} else {
				routingContext.response()
				.putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(product));
			}
		}
	}

}
