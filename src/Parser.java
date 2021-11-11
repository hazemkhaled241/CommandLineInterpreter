import java.util.Arrays;
import java.util.List;

public class Parser {
    String argument1 = "";
    String argument2 = "";
    String[] args = new String[]{"echo", "pwd", "cd", "ls", "ls -r", "mkdir", "rmdir", "touch", "cp", "cp -r", "rm", "cat", ">", ">>"};
    List<String> list;//list of commandNames
    String commandName;
    String path;
    String s;       //m3rfsh by3mel eh

    public Parser() {
        this.list = Arrays.asList(this.args);
        this.commandName = "";
        this.path = "";
        this.s = "";
    }

    public void append(String path) {
        this.argument1 = "";
        this.argument2 = "";
        boolean flag = false;

        if (this.commandName.compareTo("mkdir") != 0 && this.commandName.compareTo("rm") != 0 &&
                this.commandName.compareTo("rmdir") != 0 && this.commandName.compareTo("cat") != 0 &&
                this.commandName.compareTo("echo") != 0 && this.commandName.compareTo("cd") != 0
                && this.commandName.compareTo("touch") != 0) {//check if the command don't take one arguments

            if (this.commandName.compareTo("cp -r") == 0 || this.commandName.compareTo("cp") == 0) {//check if the command dose not take two arguments
                for (int i = 0; i < path.length(); ++i) {//for loop for get arguments from the path
                    String var10001;
                    if (path.charAt(i) != ' ' && !flag) {//condition to get the first argument
                        var10001 = this.argument1;
                        this.argument1 = var10001 + path.charAt(i);
                    } else {//to get the second arguments if it exist
                        flag = true;
                        var10001 = this.argument2;
                        this.argument2 = var10001 + path.charAt(i);
                    }
                }
            }
        } else {//if this command take one parameter put all path into the first argument
            this.argument1 = path;
        }

    }

    public boolean parse(String cmd) {
        this.argument1 = "";
        this.argument2 = "";
        boolean flag = false;
        this.commandName = "";
        this.path = "";
        int k = 0;

        int counter;
        for (counter = 0; counter < cmd.length(); counter++) {
            if (cmd.charAt(counter) == ' ') {
                flag = true;
                break;
            }

            String var10001 = this.commandName;
            this.commandName = var10001 + cmd.charAt(counter);
            k = counter + 1;
        }  //for loop for get command name in string

        if (!this.list.contains(this.commandName)) {
            System.out.println("Invalid Command Name!!");
            return false;
        } //check if the command name is valid
        else {
            if (flag) {
                this.path = cmd.substring(k + 1);
            }//set the path in string variable "path"

            counter = 0;

            for (int i = 0; i < this.path.length(); i++) {
                if (this.path.charAt(i) == ' ') {
                    counter++;
                }
            }//get number of spaces in our path to define the number of arguments

            if (this.commandName.compareTo("cp -r") != 0 && this.commandName.compareTo("cp") != 0) {//check if the command dose not take two arguments

                if (this.commandName.compareTo("mkdir") != 0 && this.commandName.compareTo("rm") != 0 &&
                        this.commandName.compareTo("rmdir") != 0 && this.commandName.compareTo("cat") != 0 &&
                        this.commandName.compareTo("echo") != 0 && this.commandName.compareTo("cd") != 0
                        && this.commandName.compareTo("touch") != 0) {
                    //check if the command don't take one arguments

                    if(!this.path.isEmpty()) { //check if there is an argument for this command
                        System.out.println("this commandName doesn't take any arg");
                        return false;
                                              }

                                                                                                          }
                else if (this.path.isEmpty() || counter > 0) {//check if this command takes one parameter but user enter more than
                    System.out.println("invalid arg , it takes one parameter ");
                    return false;
                }

            } else if (counter != 1) {//check if this command takes two parameters but user enter more than
                System.out.println("invalid arg , it takes two parameters ");
                return false;
            }

            this.append(this.path);//pass our path to this method to divide it into separated arguments
            return true;
        }
    }

    public String getCommandName() {
        return this.commandName;
    }

    public String[] getArgs() {
        return this.args;
    }
}
