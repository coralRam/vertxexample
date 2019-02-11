package api;

import bl.BookLogic;
import io.vertx.ext.web.RoutingContext;

public class BookHandler{
    private BookLogic bookLogic;

    public BookHandler() {
        this.bookLogic = BookLogic.getInstance();
    }

    public void getBookByIndex(RoutingContext routingContext) {
        /*routingContext.queryParam()*/
        routingContext.response().write("hello");
        routingContext.response().end();

    }
}
