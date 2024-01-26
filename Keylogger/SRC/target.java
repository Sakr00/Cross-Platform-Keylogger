package src;
import java.util.ArrayList;

public class target {
    private String userName;
    private ArrayList<device> devices = new ArrayList<device>();
    private ArrayList<file> files = new ArrayList<file>();
    public target(String userName){
        this.userName = userName;
    }
    public target(String userName , device device){
        this.userName = userName;
        devices.add(device);
    }
    public void addDevice(target target , device device){
        target.devices.add(device);
    }
    public void addFile(target target , file file){
        target.files.add(file);
    }
    public String getUserName(){
        return userName;
    }
    public ArrayList<device> getDevices(target target){
        return target.devices;
    }
    public ArrayList<file> getFiles(target target){
        return target.files;
    }
}
