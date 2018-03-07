package models;

import abstracts.MVC.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MooseRunner extends Model implements Runnable{

    String[] commands;

    public MooseRunner (String mooseExecPath, String mooseImagePath){
        commands = new String[]{mooseExecPath, mooseImagePath};
    }

    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        Process proc;
        try {
            proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                setChanged();
                notifyObservers(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                setChanged();
                notifyObservers(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
