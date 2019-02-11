package bl;

import dal.dao.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmirSR on 11/02/2019.
 */
public class CacheManager {
    private Map<String,Book> bookData;
    private static CacheManager instance = null;

    private CacheManager() {
        this.bookData = new HashMap<>();
    }

    public static CacheManager getInstance(){
        if(instance == null){
            instance = new CacheManager();
        }
        return instance;
    }

    public Map<String, Book> getBookData() {
        return bookData;
    }
}
