package com.example.alex.colorrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private SeekBar bar_red;
    private SeekBar bar_green;
    private SeekBar bar_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_view();
        change();
    }

    private void change() {
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
        bar_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        bar_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

    private void add_view() {
        image = (TextView) findViewById(R.id.imageView);
        textView_red = (TextView) findViewById(R.id.textView_red);
        textView_green = (TextView) findViewById(R.id.textView_green);
        textView_blue = (TextView) findViewById(R.id.textView_blue);
        textView_red_dec = (TextView) findViewById(R.id.textView_red_dec);
        textView_green_dec = (TextView) findViewById(R.id.textView_green_dec);
        textView_blue_dec = (TextView) findViewById(R.id.textView_blue_dec);
        bar_red = (SeekBar) findViewById(R.id.seekBar_red);
        bar_green = (SeekBar) findViewById(R.id.seekBar_green);
        bar_blue = (SeekBar) findViewById(R.id.seekBar_blue);
    }

    private String mix(String color_red, String color_green, String color_blue) {
        String mix = "#" + color_red + color_green + color_blue;
        return mix;
    }
}
