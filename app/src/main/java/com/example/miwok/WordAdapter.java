package com.example.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    //    public WordAdapter(@NonNull Context context, int resource, ArrayList<Word> textViewResourceId) {
//        super(context, 0, textViewResourceId);
//    }
    private final int categorycolor;

    WordAdapter(Context context, ArrayList<Word> textViewResourceId, int category_color) {

        super(context, 0, textViewResourceId);
        this.categorycolor = category_color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        // this we use to change or inflate so it looks like a reusing ListView
        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Here we get class object location in the list
        Word pos = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwok = listview.findViewById(R.id.miwok_textView);
        TextView Defalut = listview.findViewById(R.id.default_textView);
        ImageView exampleImage = listview.findViewById(R.id.exampleImage);
        LinearLayout linearLayout = listview.findViewById(R.id.linearTextLayouts);
        //set that String to the list
        miwok.setText(pos.getMiwokTranslation());
        Defalut.setText(pos.getDefaultTranslation());

        // It sets the background
        int color = ContextCompat.getColor(getContext(), categorycolor);
        linearLayout.setBackgroundColor(color);

        if (pos.hasImageResourceId()) {
            exampleImage.setImageResource(pos.getImageResourceId());
            // This line because we are reusing the View so we need to set Visible so it won't create problem
            exampleImage.setVisibility(View.VISIBLE);
        } else {
            exampleImage.setVisibility(View.GONE);
        }
        //Media Player creating
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), pos.getMediaResourceId());
        //Add View.OnClickListener but changed to Lambda function
        linearLayout.setOnClickListener(v -> mediaPlayer.start());
        return listview;

    }
}
