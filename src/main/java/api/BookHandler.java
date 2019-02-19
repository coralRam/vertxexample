package api;

import bl.BookLogic;
import com.google.gson.Gson;
import dal.dao.Book;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import java.util.List;
import java.util.Set;

import static io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON;
import static io.vertx.core.http.HttpHeaders.CONTENT_TYPE;

public class BookHandler{
    private BookLogic bookLogic;
    Gson gson;

    public BookHandler() {
        this.bookLogic = BookLogic.getInstance();
    }

    public void getBookByIndex(RoutingContext routingContext) {
        /*routingContext.queryParam()*/
        routingContext.response().write("hello");
        routingContext.response().end();

    }

    public void getBookById(RoutingContext routingContext){
        final HttpServerResponse response = routingContext.response();
        final HttpServerRequest request = routingContext.request();
        final MultiMap params = request.params();
        Set<Book> books;
        List<String> ids = params.getAll("bookId");
        books = bookLogic.getBookbyId(ids);
        String json = gson.toJson(books);
        response.putHeader(CONTENT_TYPE, APPLICATION_JSON).end(json);
        response.close();
    }
    public void getAll(RoutingContext routingContext){
        final HttpServerResponse response = routingContext.response();
        Set<Book> books;
        books = bookLogic.getAll();
        response.putHeader(CONTENT_TYPE, APPLICATION_JSON).end(gson.toJson(books));
        response.close();;
    }
}
