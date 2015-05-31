package com.eventer;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by Admin on 31.5.2015 г..
 */
public class FileSaver {


    public void saveFile(String path, File file){

    }


    private File getOutputMediaFile(int type){

        File mediaStorageDir = getImageDir();

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        File mediaFile;

            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + ".jpg");

        return mediaFile;
    }

    public static File getImageDir(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Eventer");
        return mediaStorageDir;
    }
}
