import api.BookHandler;
import bl.BookLogic;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class Driver {
    public static void main(String[] args) {
        initializeBL();
        HttpServer httpServer = configureServer();
        httpServer.listen(8080);
    }

    private static void initializeBL() {
        BookLogic.getInstance().initializeBooksCache();
    }

    private static HttpServer configureServer() {
        Vertx vertx = Vertx.factory.vertx();
        HttpServer httpServer =  vertx.createHttpServer();
        Router router = createRoutes(vertx);
        httpServer.requestHandler(router);
        return httpServer;
    }

    private static Router createRoutes(Vertx vertx) {
        Router router =  Router.router(vertx);
        BookHandler bookHandler = new BookHandler();
        router.get("/getBooksByIndex").handler(bookHandler::getBookByIndex);
        return router;
    }
}
