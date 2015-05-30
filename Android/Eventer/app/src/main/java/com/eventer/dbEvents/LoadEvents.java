package com.eventer.dbEvents;

import com.eventer.connection.DBconnenter;
import com.eventer.objects.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simeon on 5/30/15.
 */
public class LoadEvents {

    private DBconnenter dBconnenter;
    private List<Event> events;
    private Connection connection;

    private String getAllEvents = "select * from table events ";
    public LoadEvents(){
        dBconnenter = new DBconnenter();
        events = new ArrayList<Event>();
    }

    public void getSelectedEvent(){
        try {
            connection = dBconnenter.connnect();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(getAllEvents);
            readEvent(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void readEvent(ResultSet resultSet) throws  SQLException{
        Event e = new Event();
        while(resultSet.next()) {
            int id  = resultSet.getInt("id");
            e.setId(id);
            String name = resultSet.getString("event_name");
            events.add(e);
        }

    }

}
