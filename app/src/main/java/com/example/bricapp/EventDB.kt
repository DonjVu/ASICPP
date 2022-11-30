package com.example.bricapp

import java.sql.*

object EventDB {

    public fun getTable(): ResultSet?{

        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM event;")

        return res
    }

    public fun getEventIDFromName(eventName: String): Int{
        val events: ResultSet? = getTable()
        var id: Int = 0

        while(events!!.next()){
            if(events.getString("eventName") == eventName){
                id = events.getInt("eventID")
            }
        }

        return id
    }

    public fun getIDExists(eventID: Int): Boolean{
        val events: ResultSet? = getTable()
        var exists: Boolean = false

        while(events!!.next()){
            if(events.getInt("eventID") == eventID){
                exists = true
            }
        }

        return exists
    }

    public fun addEvent(eventId: Int, eventName: String, date: String, time: String, description: String, capacity: Int, registrationTime: String, cost: Double): Boolean{

        var valid: Boolean = true

        if(date.length > 10 && time.length > 5 && registrationTime.length > 5){
            valid = false
        }

        if(valid){
            //create query
            val q = "INSERT INTO event (eventID, eventName, date, time, description, capacity, registrationTime, cost)\n" +
                    "VALUES ($eventId, '$eventName', '$date', '$time', '$description', $capacity, '$registrationTime', '$cost');"
            //add new account to DB
            DBAccess.runQuery(q)
        }
        else{
            println("New event not valid")
        }

        return valid
    }

    public fun updateEvent(eventID: Int, column: String, value: String){

        //set up update query
        val q = "UPDATE cppaccount SET $column='$value' WHERE studentID='$eventID'"
        DBAccess.runQuery(q)
    }

    public fun removeEvent(eventID: Int){
        val q = "DELETE FROM event WHERE eventID = '$eventID'"
        DBAccess.runQuery(q)
    }

    public fun getEventsForDate(date: String): ResultSet?{
        val q = "SELECT * FROM event WHERE date = '$date'"
        val res: ResultSet? = DBAccess.runGetQuery(q)

        return res
    }
}