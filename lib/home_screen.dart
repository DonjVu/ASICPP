import 'package:flutter/material.dart';

import "main.dart";

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreen createState() => _HomeScreen();
}

class _HomeScreen extends State<HomeScreen> {

  //this would hold all the buttons the user can press to get to different subsystems in the app

  _HomeScreen(){
    
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