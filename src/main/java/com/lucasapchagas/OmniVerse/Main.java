package com.lucasapchagas.OmniVerse;

import com.lucasapchagas.OmniVerse.common.Constant;
import com.lucasapchagas.OmniVerse.extern.api.ApiService;
import com.lucasapchagas.OmniVerse.extern.cep.CEPService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    public static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Must provide base url to OmniVerse API.");
            running = false;
        } else {
            System.out.println("Provided base url to OmniVerse API: " + args[Constant.Args.FIRST]);
            try {
                ApiService.initialize(args[Constant.Args.FIRST]);
            } catch (Exception e) {
                e.printStackTrace();
                running = false;
            }
        }

        while (running) {
            String userInput = scanner.nextLine().trim();
            List<String> inputs = getArgsList(userInput);

            if (inputs.size() > 0)
                switch (inputs.get(Constant.Args.FIRST).toLowerCase()) {
                    case (Constant.Args.CEP):
                        if (inputs.size() > 1)
                            CEPService.findAddressByCEP(inputs.get(Constant.Args.SECOND).toLowerCase());
                        else
                            System.out.println("Correct usage: cep <digits>");
                        break;
                    case (Constant.Args.USER):
                        if (inputs.size() > 1)
                            switch (inputs.get(Constant.Args.SECOND).toLowerCase()) {
                                case (Constant.Args.USER_INFO):
                                    if (inputs.size() > 2)
                                        ApiService.getUserById(inputs.get(Constant.Args.THIRD));
                                    else
                                        System.out.println("Correct usage: user info <id>");
                                    break;
                                case (Constant.Args.USER_LIST):
                                    ApiService.getUserList();
                                    break;
                                case (Constant.Args.USER_DELETE):
                                    if (inputs.size() > 2)
                                        ApiService.deleteUserById(inputs.get(Constant.Args.THIRD));
                                    else
                                        System.out.println("Correct usage: user delete <id>");
                                    break;
                                case (Constant.Args.USER_CREATE):
                                    ApiService.registerUser();
                                    break;
                                case (Constant.Args.USER_UPDATE):
                                    if (inputs.size() > 2)
                                        ApiService.updateUserById(inputs.get(Constant.Args.THIRD));
                                    else
                                        System.out.println("Correct usage: user update <id>");
                                    break;
                                default:
                                    break;
                            }
                        break;
                    case (Constant.Args.HELP):
                        System.out.println(
                                "USER COMMANDS:\n" +
                                "user create\n" +
                                "user list\n" +
                                "user info <id>\n" +
                                "user delete <id>\n" +
                                "user update <id>\n\n" +
                                "PROGRAM COMMANDS:\n" +
                                "cep <digits>\n" +
                                "help\n"+
                                "exit"
                        );
                        break;
                    case (Constant.Args.EXIT):
                        System.out.println("Exiting the program.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Argument.");
                }
        }

    }

    private static List<String> getArgsList(String input) {
        List<String> argsList = new ArrayList<>();
        String[] args = input.split("\\s+");

        for (String arg : args) {
            if (!arg.isEmpty()) {
                argsList.add(arg);
            }
        }

        return argsList;
    }
}