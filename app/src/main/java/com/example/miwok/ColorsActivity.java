package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager mAudioManager;

    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.
                Log.i("AudioFocus", "Loss_Transient");
                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.

                mediaPlayer.seekTo(0);
                mediaPlayer.pause();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN && mediaPlayer != null) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                Log.i("AudioFocus", "Gain");
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                // mAudioManager.unregisterMediaButtonEventReceiver(RemoteControlRevice);
                Log.i("AudioFocus", "Loss");
                releaseMediaPlayer();
            }
        }
    };
    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<Word> words = new ArrayList<>();


        words.add(new Word("red", "we???e??????i", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "???akaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "???opoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "???opiis??", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustered", "chiwii?????", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        //We can play Audio for total ListView clicked this is another way WE NEED TO MAKE ArrayList as "final"
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Release the media player if it currently exists because we are about to
            // play a different sound file before completion
            releaseMediaPlayer();
            //to get Word object from adapterView and make final ArrayList
            Word word = words.get(position);
            int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                //  mAudioManager.registerMediaButtonEventReceiver(RemoteControlRevice);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMediaResourceId());
                mediaPlayer.start();
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}