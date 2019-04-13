package ua.benjamin;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startAction() {
        Scanner scanner = new Scanner(System.in);

        model.setHello(inputMessage(scanner, View.HELLO));
        model.setWorld(inputMessage(scanner, View.WORLD));

        view.printMessage(model.getPhrase());
    }

    public String inputMessage(Scanner scanner, String compareTo) {
        view.printMessage(View.ASK_INPUT + compareTo);
        String message = scanner.next();
        while (!message.equals(compareTo)) {
            view.printMessage(View.ERROR_MESSAGE);
            message = scanner.next();
        }
        return message;
    }

}
