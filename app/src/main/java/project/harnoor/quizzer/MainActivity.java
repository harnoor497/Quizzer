package project.harnoor.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startMyQuiz(View view) {
        Intent categoryIntent =new Intent(MainActivity.this,CategoriesActivity.class);
        startActivity(categoryIntent);
    }

    public void urBookmarks(View view) {
        Intent bookmarksIntent =new Intent(MainActivity.this,BookmarkActivity.class);
        startActivity(bookmarksIntent);
    }
}
