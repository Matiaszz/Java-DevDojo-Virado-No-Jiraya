package matias.dev.devdojo.introdution;

public class Lesson22TernaryOperators {
    public static void main(String[] args){
        double salary = 50;
        String donate = "I'll donate to DevDojo";
        String poor = "I will not donate to DevDojo";
        String result = salary >= 500 ? donate : poor;
        System.out.println(result);

        // Exercise: given some salary, how much value I have to pay?
        double annualSalary = 70000;
        double tax;

        if (annualSalary >= 68.508){
            tax = annualSalary * 0.4950;
            System.out.printf("Your salary is higher than €68.508, your tax is: %.2f", tax);

        } else if(annualSalary >= 34.713 && annualSalary <= 68.507){
            tax = annualSalary * 0.3735;
            System.out.printf("Your salary is higher than €34.713 and is minor than €68.507, your tax is: %.2f", tax);

        } else{
            tax = annualSalary * 0.970;
            System.out.printf("Your salary is minor than 34.713, your tax is: %.2f", tax);
        }
    }
}
