package br.com.tuning.phone.verticle;

import java.util.ArrayList;
import java.util.List;

import br.com.tuning.phone.entity.Client;
import br.com.tuning.phone.entity.Product;
import br.com.tuning.phone.entity.Sale;
import br.com.tuning.phone.entity.Supplier;
import br.com.tuning.phone.service.ClientService;
import br.com.tuning.phone.service.ProductService;
import br.com.tuning.phone.service.SaleService;
import br.com.tuning.phone.service.SupplierService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

public class AppServerVerticle extends AbstractVerticle{

	private List<Product> products = new ArrayList<Product>();
	private List<Client> clients = new ArrayList<Client>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	private List<Sale> sales = new ArrayList<Sale>();
	
	private ProductService productService;
	private ClientService clientService;
	private SupplierService supplierService;
	private SaleService saleService;
	
	public AppServerVerticle(ProductService productService, ClientService clientService, SupplierService supplierService, SaleService saleService) {
		this.productService = productService;
		this.clientService = clientService;
		this.supplierService = supplierService;
		this.saleService = saleService;
	}

	@Override
	public void start(Future<Void> fut) throws Exception {
		super.start();
		Router router = Router.router(vertx);
		setRoutingContext(router);
		createServer(fut, router);
		
		products = productService.getAllProducts();
		clients = clientService.getAllClients();
		suppliers = supplierService.getAllSuppliers();
		sales = saleService.getAllSales();
	}	
	
	private void setRoutingContext(Router router) {
		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response
			.putHeader("content-type", "text/html")
			.end("<h1>Bora de Rest!</h1>");
		});
		
		router.route("/assets/*").handler(StaticHandler.create("assets"));
		router.get("/api/products").handler(this::getAllProducts);
		router.get("/api/clients").handler(this::getAllClients);
		router.get("/api/suppliers").handler(this::getAllSuppliers);
		router.get("/api/sales").handler(this::getAllSales);
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

	private void getAllProducts(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(products));
	}
	
	private void getAllClients(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(clients));
	}
	
	private void getAllSuppliers(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(suppliers));
	}
	
	private void getAllSales(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(sales));
	}
	
//	private void addOne(RoutingContext routingContext) {
//		JsonObject json = routingContext.getBodyAsJson();
//		
//		final Product product = new Product(json.getString("name").toUpperCase(), 
//				new Double(json.getString("value")));
//		productService.saveProduct(product);
//		routingContext.response()
//		.setStatusCode(201)
//		.putHeader("content-type", "application/json; charset=utf-8")
//		.end(Json.encodePrettily(product));
//	}

//	private void deleteOne(RoutingContext routingContext) {
//		String id = routingContext.request().getParam("id");
//		if (id == null) {
//			routingContext.response().setStatusCode(400).end();
//		} else {
//			Integer idAsInteger = Integer.valueOf(id);
//			products.remove(idAsInteger);
//		}
//		routingContext.response().setStatusCode(204).end();
//	}

//	private void updateOne(RoutingContext routingContext) {
//		final String id = routingContext.request().getParam("id");
//		JsonObject json = routingContext.getBodyAsJson();
//		if (id == null || json == null) {
//			routingContext.response().setStatusCode(400).end();
//		} else {
//			final Integer idAsInteger = Integer.valueOf(id);
//			Product product = products.get(idAsInteger);
//			if (product == null) {
//				routingContext.response().setStatusCode(404).end();
//			} else {
//				product.setName(json.getString("name").toUpperCase());
//				product.setValue(new Double(json.getString("value")));
//				routingContext.response()
//				.putHeader("content-type", "application/json; charset=utf-8")
//				.end(Json.encodePrettily(product));
//			}
//		}
//	}

//	private void getOne(RoutingContext routingContext) {
//		final String id = routingContext.request().getParam("id");
//		if (id == null) {
//			routingContext.response().setStatusCode(400).end();
//		} else {
//			final Integer idAsInteger = Integer.valueOf(id);
//			Product product = products.get(idAsInteger);
//			if (product == null) {
//				routingContext.response().setStatusCode(404).end();
//			} else {
//				routingContext.response()
//				.putHeader("content-type", "application/json; charset=utf-8")
//				.end(Json.encodePrettily(product));
//			}
//		}
//	}

}
