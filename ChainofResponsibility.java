public class ChainofResponsibility{
    public static void main(String[] args){
        int leaveDays = 10;
        if(leaveDays <= 4){
            System.out.println("Approved");
        }
        else if(leaveDays <= 7){
            System.out.println("Manager Approval needed");
        }
        else{
            System.out.println("Denied");
        }
    }
}