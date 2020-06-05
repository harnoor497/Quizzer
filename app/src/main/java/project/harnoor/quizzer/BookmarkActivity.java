package project.harnoor.quizzer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static project.harnoor.quizzer.QuestionsActivity.FILE_NAME;
import static project.harnoor.quizzer.QuestionsActivity.KEY_NAME;

public class BookmarkActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;
    private List<QuestionModel> bookmarksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        Toolbar toobar =findViewById(R.id.toolbar);

        setSupportActionBar(toobar);
        getSupportActionBar().setTitle("Bookmarks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.rv_bookmarks);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        preferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor=preferences.edit();
        gson=new Gson();

        getBookmarks();


        List<QuestionModel> list=new ArrayList<>();

        BookmarkAdapter adapter =new BookmarkAdapter(bookmarksList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        storeBookmarks();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void  getBookmarks(){
        String json =preferences.getString(KEY_NAME,"");
        Type type =new TypeToken<List<QuestionModel>>(){}.getType();
        bookmarksList =gson.fromJson(json,type);
        if(bookmarksList==null){
            bookmarksList = new ArrayList<>();
        }
    }

    private void storeBookmarks(){
        String json =gson.toJson(bookmarksList);
        editor.putString(KEY_NAME,json);
        editor.commit();
    }

}