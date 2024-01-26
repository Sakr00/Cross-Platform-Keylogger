package src;

public class detect implements is_computer, is_mobile {
    private String osName = System.getProperty("os.name").toLowerCase(); //Get the osName fullname (Windows 10)
    private String osVersion = System.getProperty("java.runtime.version" ); //Get the osName version
    public String getOSName(){
        return osName;
    }
    public String getOSVersion(){
        return osVersion;
    }
    public boolean isaComputer(){
        if(osName.indexOf("win") >= 0 || osName.indexOf("mac") >= 0 || osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0 ||  osName.indexOf("sunosName") >= 0)
            return true;
        else 
            return false;
    }
    public boolean isaMobile(){
        if(isaComputer() == true)
            return false;
        else 
            return true;
    }
    public boolean IS_WINDOWS = (osName.indexOf("win") >= 0);
    public boolean IS_MAC = (osName.indexOf("mac") >= 0);
    public boolean IS_UNIX = (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0);
    public boolean IS_SOLARIS = (osName.indexOf("sunosName") >= 0);

    public detect(){}
    public void Detect(device device){

    }
    public void detector(){
        
    }
    public String detectDesktop(){
        if(IS_WINDOWS == true)
        return "Windows";
        else if (IS_UNIX == true)
        return "Linux";
        else return "Mac";
    }
}

// public void Detect(device device){
//     if(isaComputer() == false)
//         device = new moblie();
//     else{
//         if(IS_WINDOWS == true)
//             device = new windows();
//         else if (IS_UNIX == true)
//             device = new linux();
//         else device = new mac();
//     }