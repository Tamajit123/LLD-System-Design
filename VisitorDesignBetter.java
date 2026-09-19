interface Patient{
    void accept(Visitor visitor);
}

class ChildPatient implements Patient{
    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
class AdultPatient implements Patient{
    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
class SeniorPatient implements Patient{
    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

interface Visitor{
    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit(SeniorPatient seniorPatient);
}

class DiagnosisVisitor implements Visitor{
    @Override
    public void visit(ChildPatient childPatient){
        System.out.println("ChildPatient Diagnosed");
    }
    @Override
    public void visit(AdultPatient adultPatient){
        System.out.println("AdultPatient Diagnosed");
    }
    @Override
    public void visit(SeniorPatient seniorPatient){
        System.out.println("SeniorPatient Diagnosed");
    }
}

public class VisitorDesignBetter{
    public static void main(String[] args){
        Patient[] patients = {
            new ChildPatient(),
            new AdultPatient(),
            new SeniorPatient()
        };

        Visitor diagnosisVisitor = new DiagnosisVisitor();

        for(Patient patient: patients){
            patient.accept(diagnosisVisitor);
        }
    }
}