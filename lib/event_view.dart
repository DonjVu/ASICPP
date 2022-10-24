import 'package:flutter/material.dart';

import "main.dart";

//this is for looking at a general list of events
class EventView extends StatefulWidget {
  const EventView({Key? key}) : super(key: key);

  @override
  _EventView createState() => _EventView();
}

class _EventView extends State<EventView> {

  /* CLASS VARIABLES

  holds the event that this screen is viewing
  Event selectedEvent;


  */

  _EventView(){

  }


  void GetEventDetails(){//get all information for one specific event

  }

  void FillInfo(){//fill the event info into the screen

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