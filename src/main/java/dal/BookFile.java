package dal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dal.dao.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class BookFile {

    public void readFile(){
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("entities.txt").getFile());

            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type REVIEW_TYPE = new TypeToken<List<Book>>() {}.getType();
        List<Book> data = gson.fromJson(reader, REVIEW_TYPE);
    }
}
