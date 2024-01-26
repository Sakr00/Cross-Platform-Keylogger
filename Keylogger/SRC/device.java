package src;
public class device {
    protected target target;
    protected String deviceType;

    public String getDeviceType(){
        return deviceType;
    }
    public device(){}
    public device(target target){
        detect d = new detect();
        deviceType = d.detectDesktop();
    }
}
