package com.example.bricapp

import java.sql.*
import java.util.Properties

object DBAccess {
    private var conn: Connection?=null
    private var username = "root"
    private var password = "3721Robotics!" //database password

    private fun getConnection(u: String, p: String): Connection?{
        var c: Connection?=null
        val connectionProps = Properties()
        connectionProps.put("user", u)
        connectionProps.put("password", p)

        try {

            //connect to asibric database
            c = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "10.0.2.2" + ":" + "3306" + "/" + "asibricdb", connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }

        println("connection worked :D")

        return c
    }

    public fun runGetQuery(SQLQuery: String): ResultSet?{
        conn = getConnection(username, password)

        var stmt: Statement?=null
        var resSet: ResultSet?=null

        try {
            stmt= conn!!.createStatement()                  //!! -> check if not null
            resSet = stmt!!.executeQuery(SQLQuery)

            if(stmt.execute(SQLQuery)){                     //move all data to resSet
                resSet = stmt.resultSet
            }

        }catch (ex: SQLException){
            //handle when sql errors occur
            ex.printStackTrace()

        }

        return resSet
    }

    public fun runQuery(SQLQuery: String){
        conn = getConnection(username, password)

        var stmt: Statement?=null

        try {
            stmt= conn!!.createStatement()                  //!! -> check if not null

            stmt.execute(SQLQuery)

        }catch (ex: SQLException){
            //handle when sql errors occur
            ex.printStackTrace()

        }
    }
}