package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ArrayList<Word> words = new ArrayList<>();

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
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

//         WordAdapter itemsAdapter = new WordAdapter(this,R.layout.list_item, words);
        // Here we are not passing LayoutId because we are passing it or inflating it in getView()
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}