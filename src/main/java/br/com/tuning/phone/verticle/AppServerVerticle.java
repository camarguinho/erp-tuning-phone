package br.com.tuning.phone.verticle;

import br.com.tuning.phone.entity.Product;
import br.com.tuning.phone.service.ClientService;
import br.com.tuning.phone.service.ProductService;
import br.com.tuning.phone.service.SaleService;
import br.com.tuning.phone.service.SupplierService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class AppServerVerticle extends AbstractVerticle{

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
	}	
	
	private void setRoutingContext(Router router) {
		router.route("/api/products*").handler(BodyHandler.create());
		router.get("/api/products").handler(this::getAllProducts);
		router.post("/api/products").handler(this::addProduct);
		
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
		.end(Json.encodePrettily(productService.getAllProducts()));
	}
	
	private void getAllClients(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(clientService.getAllClients()));
	}
	
	private void getAllSuppliers(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(supplierService.getAllSuppliers()));
	}
	
	private void getAllSales(RoutingContext routingContext) {
		routingContext.response()
		.putHeader("content-type", "application/json; charset=utf-8")
		.end(Json.encodePrettily(saleService.getAllSales()));
	}
	
	private void addProduct(RoutingContext routingContext) {
		final Product product = Json.decodeValue(routingContext.getBodyAsString(),
				Product.class);
		productService.saveProduct(product);
		routingContext.response()
			.setStatusCode(201)
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(product));
	}


}
