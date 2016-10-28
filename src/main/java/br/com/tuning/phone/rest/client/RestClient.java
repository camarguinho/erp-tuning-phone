package br.com.tuning.phone.rest.client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;

public class RestClient extends AbstractVerticle{

	@Override
	public void start(Future<Void> fut){
		HttpClient client = vertx.createHttpClient();

		client.request(HttpMethod.GET, "viacep.com.br", "/ws/01001000/json/", response -> {
			System.out.println("Received response with status code " + response);
			System.out.println("Status message is " + response.statusMessage());
		}).end();

		client.getNow("viacep.com.br", "/ws/01001000/json/", response -> {
			response.handler(buffer -> {
				System.out.println("Received a part of the response body: " + buffer);
			});
		});

	}
}
