package com.example.bricapp

import java.sql.*

object CustomerDB {
    public fun getTable(): ResultSet? {
        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM customer;")

        return res
    }
    public fun getCustomerView(): ResultSet?{
        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM customerData;")

        return res
    }

    public fun addCustomer(studentId: RowId){
        //val q = ""
        //DBAccess.runGetQuery()
    }
}