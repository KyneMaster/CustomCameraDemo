package com.anche.kyne.customcamerademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResultActivity extends AppCompatActivity {

    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        pic = (ImageView) findViewById(R.id.pic);
        String path = getIntent().getStringExtra("path");
        try {
            FileInputStream fis = new FileInputStream(path);
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            Matrix matrix = new Matrix();
            matrix.setRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0,
                    bitmap.getWidth(), bitmap.getHeight(),
                    matrix, true);
            pic.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //        Bitmap bitmap = BitmapFactory.decodeFile(path);
        //        pic.setImageBitmap(bitmap);
    }
}
