package com.example.bricapp

import java.sql.*

object CppAccountDB {

    public fun getTable(): ResultSet?{

        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM cppaccount;")

        return res
    }

    public fun getStudentIDFromName(username: String): Int{
        val accounts: ResultSet? = getTable()
        var id: Int=-1

        // look through table
        while(accounts!!.next()) {
            //check username column and find name
            if(accounts.getString("userName") == username) {
                //retrieve studentID
                id = accounts.getInt("studentID")
            }
        }

        return id
    }

    public fun getStudentIDExists(studentID: Int): Boolean {
        val events: ResultSet? = getTable()
        var exists: Boolean = false

        while(events!!.next()){
            if(events.getInt("studentID") == studentID){
                exists = true
            }
        }

        return exists
    }

    public fun isSignInValid(username: String, password: String): Boolean{
        val accounts: ResultSet? = getTable()

        var userValid: Boolean = false
        var passValid: Boolean = false

        while(accounts!!.next()) {
            //check username column and find name
            if(accounts.getString("userName") == username) {
                userValid = true
            }
            //check password column and find password
            if(accounts.getString("password") == password){
                passValid = true
            }
        }

        return  (userValid && passValid)
    }

    public fun isNewAccountValid(studentID: Int, username: String): Boolean{
        val accounts: ResultSet? = getTable()

        var userValid: Boolean = false
        var idValid: Boolean = false

        while(accounts!!.next()) {
            //check if username already exists
            if(accounts.getString("userName") != username) {
                userValid = true
            }
            //check if the student id already exists
            if(accounts.getInt("studentID") != studentID) {
                idValid = true
            }
        }

        //false if duplicate info was found
        return (userValid&&idValid)
    }

    public fun addAccount(studentID: Int, username: String, password: String, name: String, age: Int): Boolean{
        //check if new account is valid
        val valid: Boolean = isNewAccountValid(studentID, username)

        if(valid){
            //create query
            val q = "INSERT INTO cppaccount (studentID, userName, password, name, age)\n" +
                    "VALUES (" + studentID + ", '" + username + "', '" + password + "', '" + name + "'," + age + ");"

            //add new account to DB
            DBAccess.runQuery(q)
        }
        else{
            println("New account not valid")
        }

        return valid
    }

    public fun updateAccount(studentID: Int, column: String, value: String): Boolean{
        var valid: Boolean = true

        //make sure that update doesnt create duplicates
        if(column == "studentID" || column == "userName"){
            val accounts: ResultSet? = getTable()
            while(accounts!!.next()){
                if(accounts.getString(column) == value){
                    valid = false
                    break
                }
            }
        }

        if(valid) {
            val q = "UPDATE cppaccount SET $column='$value' WHERE studentID='$studentID'"
            DBAccess.runQuery(q)
        }
        else{
            println("update cannot be performed")
        }

        return valid
    }

    public fun removeAccount(studentID: Int){
        val q = "DELETE FROM cppaccount WHERE studentID = '$studentID'"
        DBAccess.runQuery(q)
    }
}
