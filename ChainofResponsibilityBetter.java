abstract class Approver{
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover){
        this.nextApprover = nextApprover;
    }

    public abstract void processLeaveRequest(int leaveDays);
}

class SuperVisor extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays){
        if(leaveDays <= 3){
            System.out.println("Sup Approved");
        }
        else if(nextApprover != null){
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}

class Manager extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays){
        if(leaveDays <= 7){
            System.out.println("Manager Approved");
        }
        else if(nextApprover != null){
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}
class Director extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays){
        if(leaveDays <= 14){
            System.out.println("Manager Approved");
        }
        else if(nextApprover != null){
            nextApprover.processLeaveRequest(leaveDays);
        }
        else{
            System.out.println("Denied");
        }
    }
}

public class ChainofResponsibilityBetter{
    public static void main(String[] args){
        Approver SuperVisor = new SuperVisor();
        Approver Manager = new Manager();
        Approver Director = new Director();

        SuperVisor.setNextApprover(Manager);
        Manager.setNextApprover(Director);

        int leaveDays = 10;
        System.out.println("Employees requested:" + " " +leaveDays + "days of leave");
        SuperVisor.processLeaveRequest(leaveDays);
    }
}