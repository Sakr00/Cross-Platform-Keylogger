package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class file {
    private String fileName;
    private String DOF;
    private target target;
    public String getfileName(){
        return fileName;
    }
    public void setfileName(String name){
        this.fileName = name;
    }
    public String getDate(){
        return DOF;
    }
    public file(){}
    
    public file(target target){
        this.target = target;
        ArrayList<device> devices = new ArrayList<device>();
        devices = target.getDevices(target);
        fileName = target.getUserName()+"'s" +" "+ devices.get(0).getDeviceType();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        DOF = formatter.format(date);
    }
    public void localSave(target target, device device ,String data/*, data[] "in window"*/){
        if (device instanceof windows){
        fileName = String.format("%s.txt",fileName);
        try {
            File Obj = new File(fileName);
            if (Obj.createNewFile()) {
                System.out.println("File created: " + Obj.getName());
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
        else if(device instanceof linux){
            fileName = String.format("%s",fileName);
            try {
                File Obj = new File(fileName);
                if (Obj.createNewFile()) {
                    System.out.println("File created: " + Obj.getName());
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
    }
}

    // try {
    // FileWriter Writer = new FileWriter(fileName);
    // Writer.write(data);
    // Writer.close();
    // System.out.println("Successfully wrote to the file.");
    // } 
    // catch (IOException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }