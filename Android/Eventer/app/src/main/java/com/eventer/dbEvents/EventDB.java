package com.eventer.dbEvents;

import android.os.AsyncTask;

import com.eventer.objects.Event;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Created by simeon on 5/30/15.
 */
public class EventDB{

    private static Logger log = Logger.getLogger(EventDB.class.toString());



    public void getEventsFromDBAsync(){
        LongOperation longOP = new LongOperation();
        longOP.execute();
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            getEventsFromDB();
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {


        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}

        public void getEventsFromDB(){

            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://dev1.strappable.com/?json=get_posts&post_type=event");

                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();

                String result = sb.toString();
                log.info(result);
            }catch(Exception e){
                log.info("Error converting result " + e.toString());
            }
        }
    }
}
