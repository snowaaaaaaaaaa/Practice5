import com.mycompany.ex02.ConsoleCommand;
import java.util.ArrayList;
import java.util.Stack;

public class Menu {
    private final ArrayList<ConsoleCommand> commands;
    private final Stack<ConsoleCommand> commandHistory;

    private static Menu instance;

    private Menu() {
        commands = new ArrayList<>();
        commandHistory = new Stack<>();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void addCommand(ConsoleCommand command) {
        commands.add(command);
    }

    public void executeCommand(int choice) {
        boolean commandFound = false;
        for (ConsoleCommand command : commands) {
            if (command.getKey() == choice) {
                command.execute();
                commandHistory.push(command); 
                commandFound = true;
                break;
            }
        }
        if (!commandFound) {
            System.out.println("Invalid command.");
        }
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            ConsoleCommand lastCommand = commandHistory.pop(); 
            lastCommand.undo(); 
        } else {
            System.out.println("No commands to undo.");
        }
    }

    public void displayMenu() {
        System.out.println("Choose an action:");
        System.out.println(" 'v'iew, 'g'enerate, 's'ave, 'r'estore, 'c'hange, 'u'ndo, 'q'uit");
    }
}
