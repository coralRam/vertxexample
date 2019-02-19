package bl;

import dal.BooksDalManager;
import dal.BooksFromFileManager;
import dal.dao.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by AmirSR on 11/02/2019.
 */
public class BookLogic {
    private BooksDalManager booksDalManager;

    private static BookLogic instance = null;

    public static BookLogic getInstance(){
        if(instance == null){
            instance = new BookLogic();
        }
        return instance;
    }

    private BookLogic() {
        this.booksDalManager = new BooksFromFileManager(); // = new SeverManager
    }

    public void initializeBooksCache(){
       this.booksDalManager.loadBooksToCache();
    }

    public Set<Book> getBookbyId(List<String> ids){
        return null;
    };

    public Set<Book> getAll(){
        return null;
    };

}
