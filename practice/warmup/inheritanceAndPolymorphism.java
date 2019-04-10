// Inheretance and polymorphism practice
class Bank{ //parent class
    float interest; //attribute

    Bank(){
        interest = 10;
    }

    Bank(float input){ //overload compile time polymorphism
        interest = input;
    }

    float getRateOfInterest(){ //behavior
        return interest;
    }
    void getRateOfInterest(float input){ //overload compile time polymorphism
        interest = input;
    }
    void print(){
        System.out.println(getRateOfInterest());
    }
}

class SBI extends Bank{  //inheritance child class/ subclass/ derived class
    SBI(){super(8);} //polymorphism constructor overload
    void print(){ //override runtime polymorphism
        System.out.println("SBI "+getRateOfInterest()); //this gets added by compiler
    }
}

class ICICI extends Bank{
    ICICI(){ //constructor
        super();
        this.interest = 7;
    }
}

class AXIS extends Bank{
    float getRateOfInterest(){ //override
        getRateOfInterest(9); //implied this and overload
        return interest; //implied this
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Bank sbi = new SBI();
        Bank icici = new ICICI();
        Bank axis = new AXIS();
        Bank bank = new Bank();
        sbi.print();
        icici.print();
        axis.print();
        bank.print();
        sbi.getRateOfInterest(20);
        sbi.print();
    }
}
