package dal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dal.dao.Book;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by AmirSR on 11/02/2019.
 */
public abstract class BooksDalManager {
    Gson gson;

    public abstract void loadBooksToCache();

    List<Book> convertFromString(String fileData){
        Type OBJECT_TYPE = new TypeToken<List<Book>>() {}.getType();
        List<Book> data = gson.fromJson(fileData, OBJECT_TYPE);
        return data;
    }
}
