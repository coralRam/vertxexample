package api;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class BookHandler{

    public void getBookByIndex(RoutingContext routingContext) {
        /*routingContext.queryParam()*/
        routingContext.response().write("hello");
        routingContext.response().end();

    }
}
