package configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class VertxModule extends AbstractModule {

    @Provides
    @Singleton
    Vertx createVertx(){
        return Vertx.factory.vertx();
    }

    @Provides
    @Singleton
    HttpServer createServer(Vertx vertx,Router router){
        HttpServer httpServer =  vertx.createHttpServer();
        httpServer.requestHandler(router);
        return httpServer;
    }
}
