package com.example.alex.colorrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_red;
    private TextView tv_green;
    private TextView tv_blue;
    private TextView image;
    private TextView tv_redDec;
    private TextView tv_greenDec;
    private TextView tv_blueDec;
    private String color_red = "00";
    private String color_green = "00";
    private String color_blue = "00";
    private SeekBar sb_red;
    private SeekBar sb_green;
    private SeekBar sb_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_view();
        change();
    }

    private void change() {
        sb_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                tv_red.setText(hex);
                tv_redDec.setText(String.valueOf(progress));
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
        sb_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                tv_green.setText(hex);
                tv_greenDec.setText(String.valueOf(progress));
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
        sb_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String hex = String.valueOf(Integer.toString(progress, 16));
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                tv_blue.setText(hex);
                tv_blueDec.setText(String.valueOf(progress));
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
        image = (TextView) findViewById(R.id.image);
        tv_red = (TextView) findViewById(R.id.textView_red);
        tv_green = (TextView) findViewById(R.id.textView_green);
        tv_blue = (TextView) findViewById(R.id.textView_blue);
        tv_redDec = (TextView) findViewById(R.id.tv_redDec);
        tv_greenDec = (TextView) findViewById(R.id.tv_greenDec);
        tv_blueDec = (TextView) findViewById(R.id.textView_blue_dec);
        sb_red = (SeekBar) findViewById(R.id.seekBar_red);
        sb_green = (SeekBar) findViewById(R.id.seekBar_green);
        sb_blue = (SeekBar) findViewById(R.id.seekBar_blue);
    }

    private String mix(String color_red, String color_green, String color_blue) {
        return "#" + color_red + color_green + color_blue;
    }
}
