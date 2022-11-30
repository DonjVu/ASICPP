package com.example.bricapp

import java.sql.*

object BarcodeDB {

    public fun getTable(): ResultSet?{
        var res: ResultSet?=null

        res = DBAccess.runGetQuery("SELECT * FROM barcode;")

        return res
    }

    public fun addBarcode(barcodeID: Int, studentID: Int, expirationTime: Int){
        var valid: Boolean = true
        val barcodes: ResultSet? = getTable()

        while(barcodes!!.next()){
            if(barcodes.getInt("barcodeID") == barcodeID){
                valid = false
            }
        }

        if(valid){
            val q: String = "INSERT INTO barcode (barcodeID, studentID, expirationTime) VALUES ($barcodeID, $studentID, $expirationTime)"
            DBAccess.runQuery(q)
        }
        else{
            println("Invalid barcode ID (duplicates found)")
        }
    }

    public fun removeBarcode(barcodeID: Int){
        val q: String = "DELETE FROM barcode WHERE barcodeID = '$barcodeID'"
        DBAccess.runQuery(q)
    }

}