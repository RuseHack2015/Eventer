package com.eventer.connection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;


public class ImageDownloader {


    public void downloadImage(){
        InputStream is = null;
        Bitmap bitmap = BitmapFactory.decodeStream(is);
    }
}
