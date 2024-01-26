package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;
public class program {
    public static void main(String[] args) throws Exception {
        target sakr = new target("sakr");
        device d1 = new device(sakr);
        sakr.addDevice(sakr, d1);
        file f1 = new file(sakr);
        target reem = new target("reem");
        device d2 = new device(reem);
        reem.addDevice(reem, d1);
        file f2 = new file(reem);
        target medhat = new target("medhat");
        device d3 = new device(medhat);
        medhat.addDevice(medhat, d1);
        file f3 = new file(medhat);
        db db = new db();
        db.addToDB(sakr, d1, f1);
        db.addToDB(reem, d2, f2);
        db.addToDB(medhat, d3, f3);
        db.readFromDB();
        // try {
        //     String command = "py D:\\AAST_Courses\\semester_6\\OOP_java\\Keylogger_project\\new.py";
        //     ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            
        //     processBuilder.environment().put("targetFile", "");
            
        //     Process process = processBuilder.start();
            
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }
        //     int exitCode = process.waitFor();
            
        //     System.out.println("Python script executed with exit code: " + exitCode);
        // } 
        // catch (IOException | InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}
// test device class & interfaces 
// device n = new device();
// device n2 = new device();
// ArrayList<device> arr = new ArrayList<device>();
// boolean b = n.isaComputer(); 
// System.out.println("device 1 =" + b);

// target t1 = new target("new", n);
// System.out.println("device 1 type ="+ n.getDeviceType());
// t1.addDevice(t1, n2);
// arr = t1.getDevices(t1);
// System.out.println("....................................");
// for (int i = 0; i< arr.size() ;i++) {
//     System.out.println(arr.get(i).getDeviceType());
// }
// file f = new file();
// System.out.println(f.getDate());
// PythonInterpreter pythonInterpreter = new PythonInterpreter();
// pythonInterpreter.exec("print('Hello Java')");
// pythonInterpreter.execfile("keylogger.py");
// pythonInterpreter.close();