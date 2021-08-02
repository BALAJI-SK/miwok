package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter  extends ArrayAdapter<Word> {
//    public WordAdapter(@NonNull Context context, int resource, ArrayList<Word> textViewResourceId) {
//        super(context, 0, textViewResourceId);
//    }
WordAdapter(Context context ,ArrayList<Word> textViewResourceId){
    super(context, 0, textViewResourceId);
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
      // this we use to change
        if(listview == null) {
            listview= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Here we get class object location in the list
        Word pos = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwok = listview.findViewById(R.id.miwok_textView);
        TextView Defalut = listview.findViewById(R.id.default_textView);
        //set that String to the list
        miwok.setText(pos.getMiwokTranslation());
        Defalut.setText(pos.getDefaultTranslation());


        return  listview;

    }
}
