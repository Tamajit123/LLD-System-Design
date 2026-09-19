class ChildPatient{
    public void diagonis(){
        System.out.println("Child diagnosis");
    }
    public void billing(){
        System.out.println("Child billing");
    }
}
class AdultPatient{
    public void diagonis(){
        System.out.println("adult diagnosis");
    }
    public void billing(){
        System.out.println("adult billing");
    }
}
class SeniorPatient{
    public void diagonis(){
        System.out.println("Senior diagnosis");
    }
    public void billing(){
        System.out.println("Senior billing");
    }
}

public class VisitorDesignTrad{
    public static void main(String[] args){
        Object patient = new AdultPatient();

        if(patient instanceof ChildPatient){
            ((ChildPatient) patient).diagonis();
            ((ChildPatient) patient).billing();
        }
        else if(patient instanceof AdultPatient){
            ((AdultPatient) patient).diagonis();
            ((AdultPatient) patient).billing();
        }
        else if(patient instanceof SeniorPatient){
            ((SeniorPatient) patient).diagonis();
            ((SeniorPatient) patient).billing();
        }
    }
}