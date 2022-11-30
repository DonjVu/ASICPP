package com.example.bricapp

import java.sql.*

object EventAttendanceDB {

    public fun getTable(): ResultSet?{
        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM eventAttendance;")

        return res
    }

    public fun getAttendanceView(): ResultSet?{
        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM eventAttendanceData;")

        return res
    }

    public fun getTotalAttendance(eventID: Int): Int {
        var a: Int = 0
        val attendance: ResultSet? = getAttendanceView()

        while(attendance!!.next()){
            if(attendance.getInt("eventID") == eventID){
                a = attendance.getInt("totalRegistered")
            }
        }

        return a
    }

    public fun addStudentEventAttendance(studentID: Int, eventID: Int): Boolean{

        val valid: Boolean = (EventDB.getIDExists(eventID) && CppAccountDB.getStudentIDExists(studentID))
        var valid2: Boolean = true

        val attendance: ResultSet? = getTable()

        //make sure student is not signed up for the same event
        while(attendance!!.next()){
            if(attendance.getInt("studentID") == studentID){
                valid2 = false
            }
        }

        if(valid && valid2){
            val q: String = "INSERT INTO eventAttendance (studentID, eventID)\n" +
                    "VALUES ($studentID, $eventID);"

            DBAccess.runQuery(q)
        }
        else{
            //send correct error message based on error
            if(!valid)
                println("invalid student or event ID")
            if(!valid2)
                println("Student is already signed up for this event")
        }

        return valid
    }

    public fun removeStudentFromAttendance(studentID: Int, eventID: Int){
        val q: String = "DELETE FROM eventAttendance WHERE eventID = '$eventID' AND studentID = '$studentID'"
    }

    @JvmStatic public fun main (args: Array<String>){


    }

}