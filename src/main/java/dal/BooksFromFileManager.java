package dal;

import bl.CacheManager;
import com.google.gson.Gson;
import dal.dao.Book;

import java.util.List;

public class BooksFromFileManager extends BooksDalManager {
    private static final String BOOKS_FILE_PATH = "entities.txt";
    private UtilityFileManager utilityFileManager;

    public BooksFromFileManager() {
        this.gson = new Gson();
        this.utilityFileManager = new UtilityFileManager();
    }

    @Override
    public void loadBooksToCache(){
        List<Book> data = convertFromString( this.utilityFileManager.getDataFromFile(BOOKS_FILE_PATH));
        data.forEach(book -> CacheManager.getInstance().getBookData().put(book.getId(),book));
    }
}
