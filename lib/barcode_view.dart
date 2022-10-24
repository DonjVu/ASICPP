import 'package:flutter/material.dart';

import "main.dart";

//this is for looking at a general list of events
class BarcodeView extends StatefulWidget {
  const BarcodeView({Key? key}) : super(key: key);

  @override
  _BarcodeView createState() => _BarcodeView();
}

class _BarcodeView extends State<BarcodeView> {

  /* CLASS VARIABLES

  holds raw barcode information
  barcode currentBarcode;

  holds the barcode image
  img barcodeImg;

  holds the user's login token, this would be passed in from a previous screen
  string loginToken;

  */

  _BarcodeView(){

  }

  void GetUserId(/*login token*/){//returns the current user's id

  }

  void GetBarcode(/*user id*/){//ask database for a new barcode, return barcode information

  }

  void GenerateBarcode(/*barcode info*/){//use a library to generate a barcode image, return image

  }

  void UpdateBarcodeDisplay(){//once a barcode has been successfully generated, place it onto the screen or give an error prompt if it didn't work

  }



  @override
  Widget build(BuildContext context) {
    return Scaffold(

      body: Container(
          decoration: const BoxDecoration(
              gradient: LinearGradient(
                  begin: Alignment.topCenter,
                  end: Alignment.bottomCenter,
                  colors: [
                    Color(0x6361FF00),
                    Color(0x9961FF00)
                  ]
              )
          ),

          child: Column(
              children: <Widget>[

                Container( // BACK BUTTON
                    margin: const EdgeInsets.only(left: 20, top: 20),
                    width: 80,
                    height: 50,
                    decoration: const BoxDecoration(
                        borderRadius: BorderRadius.all(Radius.circular(10)),
                        color: Colors.white
                    ),
                    child: TextButton(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(builder: (context) => const MyHomePage()),
                          );
                        },
                        child: const Text(
                          "< Back",
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.black,
                          ),
                        )
                    )
                ),

              ]
          )

      ),



    );
  }
}