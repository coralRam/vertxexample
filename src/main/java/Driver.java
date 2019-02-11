import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.RouterModule;
import configuration.VertxModule;
import dal.BookFile;
import io.vertx.core.http.HttpServer;

public class Driver {
    public static void main(String[] args) {
//        Injector injector = Guice.createInjector(new RouterModule(),new VertxModule());
//        HttpServer httpServer = injector.getInstance(HttpServer.class);
//        httpServer.listen(8000);
        BookFile book = new BookFile();
        book.readFile();
        System.out.print("cdscds");
    }
}
