import 'package:flutter/material.dart';
import 'dart:io';
import 'package:flutter/services.dart';
import 'package:advanced_search/advanced_search.dart';
import 'package:process_run/shell.dart';

void main() {
  var filePath = 'C:\\Users\\Reem\\Desktop\\app\\Keylogger\\SRC\\Python\\Keylogs21.txt';
  File file = File(filePath);
  var fileContent = file.readAsStringSync();

  var filePath1 = 'C:\\Users\\Reem\\Desktop\\app\\trial.txt'; // Replace with the actual file path
  File file1 = File(filePath1);

  Future<List<String>> readFileLines() async {
    try {
      var fileContent1 = await file.readAsString();
      return fileContent1.split('\n');
    } catch (e) {
      print('Failed to read file: $e');
      return [];
    }
  }

  readFileLines().then((lines) {
    runApp(MyApp(fileContent: fileContent, searchableList: lines));
  });
}

class MyApp extends StatelessWidget {
  final String fileContent;
  final List<String> searchableList;

  const MyApp({Key? key, required this.fileContent, required this.searchableList}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Keylogger',
      theme: ThemeData(
        primarySwatch: Colors.indigo,
      ),
      home: Homepage(
  fileContent: fileContent,
  searchableList: searchableList,
),

    );
  }
}


// Rest of the code remains the same...

class Homepage extends StatefulWidget {
  final String fileContent;
  final List<String> searchableList;
  
  Homepage({Key? key, required this.fileContent, required this.searchableList})
      : super(key: key);


  @override
  _HomepageState createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {

  
  String cardContent = '';

  @override
  void initState() {
    super.initState();
    cardContent = widget.fileContent;
  }

  void clearCardContent() {
    setState(() {
      cardContent = 'empty :)';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Keylogger'),
        actions: [
          IconButton(
  onPressed: () => Navigator.of(context).push(MaterialPageRoute(builder: (_) => SearchPage(searchableList: widget.searchableList))),
  icon: const Icon(Icons.search),
),
        ],
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            const SizedBox(height: 20),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 20),
              child: Align(
                alignment: Alignment.centerLeft,
                child: Text(
                  'State the action of the device u chose',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
            const SizedBox(height: 20),
            Wrap(
              spacing: 20,
              runSpacing: 20,
              alignment: WrapAlignment.center,
              children: <Widget>[
                ElevatedButton(
                  onPressed: () async {
                    print('Start button pressed! ');
                    Process.run('python', ['C:\\Users\\Reem\\Desktop\\app\\Keylogger\\SRC\\Python\\keylogger.py']);
                    print("beb");
                  },
                  child: const Text('Start'),
                  style: ElevatedButton.styleFrom(
                    minimumSize: const Size(120, 60),
                    primary: Colors.green,
                    textStyle: const TextStyle(fontSize: 18),
                  ),
                ),
                ElevatedButton(
                  onPressed: () {
                    // Add your onPressed logic here
                  },
                  child: const Text('Save'),
                  style: ElevatedButton.styleFrom(
                    minimumSize: const Size(120, 60),
                    primary: Colors.blue,
                    textStyle: const TextStyle(fontSize: 18),
                  ),
                ),
                ElevatedButton(
                  onPressed: () {
                    // Add your onPressed logic here
                  },
                  child: const Text('Terminate'),
                  style: ElevatedButton.styleFrom(
                    minimumSize: const Size(120, 60),
                    primary: Colors.red,
                    textStyle: const TextStyle(fontSize: 18),
                  ),
                ),
                ElevatedButton(
                  onPressed: clearCardContent,
                  child: const Text('Clear'),
                  style: ElevatedButton.styleFrom(
                    minimumSize: const Size(120, 60),
                    primary: Colors.yellow,
                    textStyle: const TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            Container(
              width: double.infinity, // Expand the container width
              child: Expanded(
                child: Card(
                  shape: RoundedRectangleBorder(
                    side: BorderSide(
                      color: const Color.fromARGB(255, 0, 0, 0),
                    ),
                    borderRadius: BorderRadius.circular(20.0),
                  ),
                  child: Container(
                    padding: EdgeInsets.all(16),
                    child: Text(
                      cardContent,
                      style: TextStyle(fontSize: 16),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

// Search Page
class SearchPage extends StatelessWidget {
  final List<String> searchableList;

  SearchPage({required this.searchableList});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      // The search area here
      body: Container(
        margin: const EdgeInsets.only(top: 30.0, left: 30, right: 30),
        child: AdvancedSearch(
          searchItems: searchableList,
          maxElementsToDisplay: 10,
          singleItemHeight: 50,
          borderColor: Colors.grey,
          minLettersForSearch: 0,
          selectedTextColor: Color(0xFF3363D9),
          fontSize: 14,
          borderRadius: 12.0,
          hintText: 'Search Me',
          cursorColor: Colors.blueGrey,
          autoCorrect: false,
          focusedBorderColor: Colors.blue,
          searchResultsBgColor: Color(0xFAFAFA),
          disabledBorderColor: Colors.cyan,
          enabledBorderColor: Colors.black,
          enabled: true,
          caseSensitive: false,
          inputTextFieldBgColor: Colors.white10,
          clearSearchEnabled: true,
          itemsShownAtStart: 10,
          searchMode: SearchMode.CONTAINS,
          showListOfResults: true,
          unSelectedTextColor: Colors.black54,
          verticalPadding: 10,
          horizontalPadding: 10,
          hideHintOnTextInputFocus: true,
          hintTextColor: Colors.grey,
          searchItemsWidget: searchWidget,
          onItemTap: (index, value) {
            print("selected item Index is $index");
          },
          onSearchClear: () {
            print("Cleared Search");
          },
          onSubmitted: (value, value2) {
            print("Submitted: " + value);
          },
          onEditingProgress: (value, value2) {
            print("TextEdited: " + value);
            print("LENGTH: " + value2.length.toString());
          },
        ),
      ),
    );
  }

  Widget searchWidget(String text) {
    return ListTile(
      title: Text(
        text.length > 3 ? text.substring(0, 3) : text,
        style: TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 16,
          color: Colors.indigoAccent,
        ),
      ),
      subtitle: Text(
        text,
        maxLines: 1,
        overflow: TextOverflow.ellipsis,
        style: TextStyle(
          fontWeight: FontWeight.normal,
          fontSize: 12,
          color: Colors.black26,
        ),
      ),
    );
  }
}