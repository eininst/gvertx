package conf;

import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;
import util.Runner;

/**
 * Created by wangziqing on 17/1/22.
 */
public class Verticle extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(Verticle.class);
    }

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();
        server.requestStream().toObservable().subscribe(req -> {
            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        });
        server.listen(8080);
    }
}
