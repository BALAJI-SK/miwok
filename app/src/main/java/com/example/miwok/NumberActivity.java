package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ArrayList<Word> words = new ArrayList<Word>();

//        words.add( "one");
//        words.add( "two");
//        words.add( "three");
//        words.add( "four");
//        words.add( "five");
//        words.add( "six");
//        words.add( "seven");
//        words.add( "eight");
//        words.add( "nine");
//        words.add( "ten");
       // LinearLayout root = findViewById(R.id.rootView);
//        ArrayList<TextView> t = new ArrayList<>();

//for (int i=0;i<words.size();i++){
//    TextView t =new TextView(this); //creating View
//    t.setText(words.get(i)); // setting text
//    root.addView(t); //Adding TextView to the LinearLayout
//
//}
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));
//         WordAdapter itemsAdapter = new WordAdapter(this,R.layout.list_item, words);
        // Here we are not passing LayoutId because we are passing it or inflating it in getView()
        WordAdapter itemsAdapter = new WordAdapter(this, words);
       ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}