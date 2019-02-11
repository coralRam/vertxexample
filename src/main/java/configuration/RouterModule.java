package configuration;

import api.BookHandler;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class RouterModule extends AbstractModule {

    @Provides
    @Singleton
    Router createRouter(Vertx vertx, BookHandler bookHandler){
        Router router =  Router.router(vertx);
        router.get("/getBooksByIndex").handler(bookHandler::getBookByIndex);
        return router;
    }
}
