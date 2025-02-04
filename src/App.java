import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> Valid_Metrics = Set.of("kg","lb","gram","ounces","km","miles","mm","inch");     
        Set<String> Valid_Distance_Metrics = Set.of("km","miles","mm","inch");
        Set<String> Valid_Weight_Metrics = Set.of("kg","lb","gram","ounces");

        Scanner scanner = new Scanner(System.in);

        String Metric_Type = null;
        String Converting_From = null;
        double units = 0;
        String Converting_to = null;
        double result = 0;
        String Exit_Answer = null;

        System.out.println("Welcome to metric converter!");
        System.out.println("I will ask you 3 questions before returning your converted metric");
        System.out.println("First I will ask the starting metric");
        System.out.println("Then I will ask the units of the starting metric");
        System.out.println("Finally I will ask the metric you are converting to");
        System.out.println();

        while (true) {
            Metric_Type = null;
            result = 0;
            System.out.println("you may enter \"exit\" at any time to exit the program");
            System.out.println();
            while (true) {
                System.out.println("What unit are you converting from?");
                System.out.println("Your possible options are \"kg\" \"lb\" \"gram\" \"ounces\" \"km\" \"miles\" \"mm\" \"inch\"");
                Converting_From = scanner.nextLine();

                if (Converting_From.equals("exit")) {
                    scanner.close();
                    System.exit(0);
                }

                if (Valid_Metrics.contains(Converting_From)) {
                    if(Valid_Distance_Metrics.contains(Converting_From)){
                        Metric_Type = "distance";
                        break;
                    }else{
                        Metric_Type = "Weight";
                        break;
                    }

                } else {
                    System.out.println("Please enter a valid metric");
                    continue;
                }
            }

            
            while (true) {
                System.out.println("How many units are you converting from?");
                String Q2_Input = scanner.nextLine();
                if (Q2_Input.equals("exit")) {
                    scanner.close();
                    System.exit(0);
                }

                try{
                    units = Double.parseDouble(Q2_Input);
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("ERROR: Please input a number");
                    continue;
                } 
            }

            while (true) {
                System.out.println("What unit are you converting to?");
                if (Metric_Type.equals("distance")){
                    while(true){
                        System.out.println("Your possible options are " + String.join(" ", Valid_Distance_Metrics));
                        Converting_to = scanner.nextLine();
                        if (Converting_to.equals("exit")) {
                            scanner.close();
                            System.exit(0);
                        }
                        if (Valid_Distance_Metrics.contains(Converting_to)) {
                            break;
                        } else {
                            System.out.println("Please enter a valid distance metric");
                            continue;
                        }
                    }
                } else{
                    while (true){
                        System.out.println("Your possible options are " + String.join(" ", Valid_Weight_Metrics));
                        Converting_to = scanner.nextLine();
                        if (Converting_to.equals("exit")) {
                            scanner.close();
                            System.exit(0);
                        }
                        if (Valid_Weight_Metrics.contains(Converting_to)) {
                            break;
                        } else {
                            System.out.println("Please enter a valid weight metric");
                            continue;
                        }

                    }

                     
                }
                break;
            }


            switch (Converting_From){
                //Weight conversions
                case "kg":
                    result = switch (Converting_to){
                        case "lb" -> units * 2.20462;
                        case "gram" -> units * 1000;
                        case "ounces" -> units * 2.20462;
                        default -> units;
                    };
                    break;
                case "lb":
                    result = switch (Converting_to){
                        case "kg" -> units * 0.453592;
                        case "gram" -> units * 453.592;
                        case "ounces" -> units * 16;
                        default -> units;
                    };
                    break;
                case "gram":
                    result = switch (Converting_to){
                        case "kg" -> units * 0.001;
                        case "lb" -> units * 0.00220462;
                        case "ounces" -> units * 0.03527396;
                        default -> units;
                    };
                    break;
                case "ounces":
                    result = switch (Converting_to){
                        case "kg" -> units * 0.0283495;
                        case "lb" -> units * 0.0625;
                        case "gram" -> units * 28.3495;
                        default -> units;
                    };
                    break;

                // Distance conversions
                case "km":
                    result = switch (Converting_to){
                        case "miles" -> units * 0.621371;
                        case "mm" -> units * 1_000_000;
                        case "inch" -> units * 39_370.1;
                        default -> units;
                    };
                    break;
                case "miles":
                    result = switch (Converting_to){
                        case "km" -> units * 1.60934;
                        case "mm" -> units * 1_609_340;
                        case "inch" -> units * 63_360;
                        default -> units;
                    };
                    break;
                case "mm":
                    result = switch (Converting_to){
                        case "km" -> units * 1e-6;
                        case "miles" -> units * 6.2137e-7;
                        case "inch" -> units * 0.0393701;
                        default -> units;
                    };
                    break;
                case "inch":
                    result = switch (Converting_to){
                        case "km" -> units * 0.0000254;
                        case "mm" -> units * 25.4;
                        case "miles" -> units * 0.0000157828;
                        default -> units;
                    };
                    break;
            }
            
            System.out.println("The conversion of " + Converting_From + " to " + Converting_to + " is " + result);
            while(true){
                System.out.println("Enter \"exit\" to close the product, or \"continue\" to restart the program");
                Exit_Answer = scanner.nextLine();
                switch (Exit_Answer){
                    case "exit":
                        scanner.close();
                        System.exit(0);
                    case "continue":
                        break;
                    default:
                        System.out.println("Invalid input. Please enter \"exit\" or \"continue\".");
                        continue;
                }
                break;
            }
        }

    }
}
