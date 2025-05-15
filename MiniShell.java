//لحفظ الكلاس الذي يحتوي على الـ main وينفذ الأوامر.
import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler shellCommandHandler = new ShellCommandHandler();
        String command;

        // حلقة انتظار الأوامر من المستخدم
        while (true) {
            System.out.print(shellCommandHandler.getCurrentDirectory().getAbsolutePath() + "> ");
            command = scanner.nextLine();

            // التعامل مع الأوامر
            if (command.equals("exit")) {
                System.out.println("الخروج من البرنامج...");
                break;
            } else if (command.equals("pwd")) {
                shellCommandHandler.printWorkingDirectory();
            } else if (command.equals("ls")) {
                shellCommandHandler.listDirectory();
            } else if (command.startsWith("cd ")) {
                shellCommandHandler.changeDirectory(command.substring(3));
            } else if (command.startsWith("mkdir ")) {
                shellCommandHandler.makeDirectory(command.substring(6));
            } else if (command.startsWith("create ")) {
                shellCommandHandler.createFile(command.substring(7));
            } else if (command.equals("help")) {
                shellCommandHandler.printHelp();
            } else {
                System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        }

        scanner.close();
    }
}

