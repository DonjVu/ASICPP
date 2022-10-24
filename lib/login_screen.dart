import 'package:flutter/material.dart';

import "main.dart";

//this is for looking at a general list of events
class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  _LoginScreen createState() => _LoginScreen();
}

class _LoginScreen extends State<LoginScreen> {


  _LoginScreen(){

  }


  void NewAccount(/*account information*/){//attempt to create a new account with the given information, returns boolean for success or failure

  }

  void Login(/*username and password*/){//attempt to login with the given username and password, returns login token

  }

  void SaveLogin(){//save login information if the "remember me" box is checked

  }

  void GetLoginInfo(){//get saved login information if the "remember me" box was checked on a previous login, return login info

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