package dal;

import bl.CacheManager;
import com.google.gson.Gson;
import dal.dao.Book;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

import java.util.List;

/**
 * Created by AmirSR on 11/02/2019.
 */
public class BooksFromServerManager extends BooksDalManager {

    private static final String SERVER_ADDRESS = "https://www.googleapis.com";
    private static final String REQUEST_URI = "//books//v1//volumes";

    public BooksFromServerManager() {
        this.gson = new Gson();
    }

    @Override
    public void loadBooksToCache(){
        this.getData();
    }

    public void getData(){
        WebClient client = WebClient.create(Vertx.vertx());
        client.get(SERVER_ADDRESS,REQUEST_URI).addQueryParam("q","lior").send(ar -> {
            if (ar.succeeded()) {
                HttpResponse<Buffer> response = ar.result();
                List<Book> data = convertFromString(response.bodyAsString());
                data.forEach(book -> CacheManager.getInstance().getBookData().put(book.getId(),book));
                System.out.println("Received response with status code" + response.statusCode());
            } else {
                System.out.println("Something went wrong " + ar.cause().getMessage());
            }
        });
    }
}
