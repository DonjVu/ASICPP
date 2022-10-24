import 'package:flutter/material.dart';

import "main.dart";

//this is for looking at a general list of events
class EventList extends StatefulWidget {
  const EventList({Key? key}) : super(key: key);

  @override
  _EventList createState() => _EventList();
}

class _EventList extends State<EventList> {

  /* CLASS VARIABLES

  holds information about each event. only title and time is necessary until the screen goes to EventView
  list<Event> eventList;

  */

  _EventList(){

  }


  void GetEvents(){//get all current events from the database, return some list of objects containing event info

  }

  void FillViewer(){//fill the events into a list view

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