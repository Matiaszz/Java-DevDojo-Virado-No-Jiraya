package matias.dev.devdojo.introdution;

public class Lesson26SwitchExercise {
    public static void main(String[] args) {
        int day = 7;

        if(day >= 1 && day <= 7){
            switch (day){
                case 1:
                    System.out.println("its sunday");
                    break;

                case 7:
                    System.out.println("Its saturday");
                    break;

                default:
                    System.out.println("Its work day");
                    break;
            }
        }else{
            System.out.println("Invalid");
        }



    }
}
