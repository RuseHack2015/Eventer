package com.eventer.dbEvents;

import android.app.DownloadManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by simeon on 5/30/15.
 */
public class EventDB implements  Runnable{

    private static Logger log = Logger.getLogger(EventDB.class.toString());



    public void getEventsFromDBAsync(){
        new Thread(this).start();

    }

    public String postData() {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httppost = new HttpGet("http://dev1.strappable.com/?json=get_posts&post_type=event&order=desc&orderby=end_date");
        HttpEntity entity;
        String result = "";
        try {
            // Add your data
            //  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            //  nameValuePairs.add(new BasicNameValuePair("id", "12345"));
            //  nameValuePairs.add(new BasicNameValuePair("stringdata", "Hi"));
            //    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            log.info(response.toString());
            entity = response.getEntity();
            result = EntityUtils.toString(entity);
            log.info("Result is " + result);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return  result;
    }

    public void run(){
        postData();
    }
}
