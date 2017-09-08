package com.example.alex.colorrgb;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_red;
    private TextView textView_green;
    private TextView textView_blue;
    private TextView image;
    private TextView textView_red_dec;
    private TextView textView_green_dec;
    private TextView textView_blue_dec;
    private String color_red = "00";
    private String color_green = "00";
    private String color_blue = "00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (TextView) findViewById(R.id.imageView);
        textView_red = (TextView) findViewById(R.id.textView_red);
        textView_green = (TextView) findViewById(R.id.textView_green);
        textView_blue = (TextView) findViewById(R.id.textView_blue);
        textView_red_dec = (TextView) findViewById(R.id.textView_red_dec);
        textView_green_dec = (TextView) findViewById(R.id.textView_green_dec);
        textView_blue_dec = (TextView) findViewById(R.id.textView_blue_dec);
        SeekBar bar_red = (SeekBar) findViewById(R.id.seekBar_red);
        SeekBar bar2 = (SeekBar) findViewById(R.id.seekBar_green);
        SeekBar bar3 = (SeekBar) findViewById(R.id.seekBar_blue);
        bar_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                textView_red.setText(hex);
                textView_red_dec.setText(String.valueOf(progress));
                color_red = hex;
                image.setBackgroundColor(Color.parseColor(mix(hex, color_green, color_blue)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                textView_green.setText(hex);
                textView_green_dec.setText(String.valueOf(progress));
                color_green = hex;
                image.setBackgroundColor(Color.parseColor(mix(color_red, hex, color_blue)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                textView_blue.setText(hex);
                textView_blue_dec.setText(String.valueOf(progress));
                color_blue = hex;
                image.setBackgroundColor(Color.parseColor(mix(color_red, color_green, hex)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String mix(String color_red, String color_green, String color_blue) {
        String mix = "#" + color_red + color_green + color_blue;
        return mix;
    }
}
