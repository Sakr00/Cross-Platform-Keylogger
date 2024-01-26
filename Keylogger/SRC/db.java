package src;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.nio.file.*;
public class db 
{
    private int dataBaseRecords = 0;
    private boolean isCreated = false;
    public int getDataBaseRecords(){
        return dataBaseRecords;
    }
    String[] arr = new String[4];
    String fileName = "database.txt";
    File dataBase = new File(fileName);
            public void addToDB(target t, device d , file f) {
                if(isCreated == false){
                    createDB();
                    isCreated = true;
                }
                arr[0] = t.getUserName() + "     ";
                arr[1] = d.getDeviceType()+ "     ";
                arr[2] = f.getfileName()+ "     ";
                arr[3] = "\n";
                SaveToDB(arr);
                dataBaseRecords++;
            }
            //Create File of data base file
            public void createDB(){
            try {
                if (dataBase.createNewFile()) {
                    System.out.println("File created: " + dataBase.getName());
                    } 
                else {
                    System.out.println("File already exists.");
                }
                    } 
                catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }
            }
            //Write To DB
            public void SaveToDB(String arr[]){
            try {
                FileWriter file = new FileWriter(fileName,true);
                BufferedWriter Writer = new BufferedWriter(file);
            for(int i = 0 ; i< 4; i++) {
                String data = arr[i];
                Writer.write(data);
                }
            Writer.close();
            file.close();
            System.out.println("Successfully wrote to the file.");
            }
            catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        }
        //Read from DB
        public void readFromDB() {
            try {
                Scanner reader = new Scanner(dataBase);
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
                reader.close();
                } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
}