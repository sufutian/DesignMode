package sdk.login.tvos.com.sufutian;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by sufutian on 2016/11/9/15:13.
 */

public class DiskCache implements IImageCache {



    static String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+"001sufutian";
    @Override
    public void putBitmap(String urlkey, Bitmap bitmap) {
        String replace = urlkey.replace("/", "");

        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(path+replace);
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Bitmap getBitmap(String urlKey) {
        String replace = urlKey.replace("/", "");
        Log.i("getBitmap", "disk: ");
        return BitmapFactory.decodeFile(path+replace);
    }
}
