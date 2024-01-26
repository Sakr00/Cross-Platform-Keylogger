import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter to Java',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int count = 0;

  Future<void> sendStringToJava(String message) async {
    const platform = MethodChannel('com.example.mychannel');
    try {
      await platform.invokeMethod('sendStringToJava', {'message': message});
    } catch (e) {
      print('Error: $e');
    }
  }

  void incrementCounter() {
    setState(() {
      count++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter Tutorial - googleflutter.com'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            incrementCounter();
            sendStringToJava('Button Clicks - $count');
          },
          child: Text('Button Clicks - $count'),
        ),
      ),
    );
  }
}
