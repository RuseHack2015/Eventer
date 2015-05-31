package com.eventer.dbEvents;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class EventAsyncTask extends AsyncTask<Void, Void, Void> {

    private static Log Log;
    private Activity originActivity;
    private ProgressDialog pDialog;

    public EventAsyncTask (Activity originActivity){
        this.originActivity = originActivity;
    }

@Override
protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        pDialog = new ProgressDialog(originActivity);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        }

@Override
protected Void doInBackground(Void... arg0) {
        // Creating service handler class instance
        EventDB sh = new EventDB();

        // Making a request to url and getting response
        String jsonStr = sh.postData();

        JSONArray contacts;
        Log.d("Response: ", "> " + jsonStr);

        if (jsonStr != null) {
        try {
        JSONObject jsonObj = new JSONObject(jsonStr);

        // Getting JSON Array node
         contacts = jsonObj.getJSONArray("events");

        // looping through All Contacts
        for (int i = 0; i < contacts.length(); i++) {
        JSONObject c = contacts.getJSONObject(i);
                Log.i("TAG",c.toString());
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        } else {
        Log.e("ServiceHandler", "Couldn't get any data from the url");
        }

        return null;
        }

@Override
protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        if (pDialog.isShowing())
        pDialog.dismiss();
           }

        }
