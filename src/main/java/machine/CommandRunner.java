package machine;

import java.util.Scanner;

public class CommandRunner {
    public void menu(){
//        Machine db = new Machine();
        Scanner input =  new Scanner(System.in);
        boolean exitNow = true;
        ExtendableVendingMachine db = new ExtendableVendingMachine();

        while(exitNow) {
            System.out.print("Please enter your command:");
            String commandInput = input.nextLine();
            if (commandInput.equals("exit")){
                exitNow = false;
                System.out.println("Goodbye...");
                return;
            }
            System.out.println(new CommandProcessor(db, new CommandExtractor(commandInput)).menu());
        }
    }
}