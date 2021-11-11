//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import java.io.IOException;
import java.util.Scanner;

class CLI {
    CLI() {
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Parser par = new Parser();
        Terminal terminal = new Terminal();

        while(true) {
            String s = scan.nextLine();

            try {
                if (par.parse(s)) {
                    if (par.commandName.compareTo("cd") == 0) {
                        //terminal.cd(par.arg1);
                    } else if (par.commandName.compareTo("cp -r") == 0) {
                        //terminal.cp_r(par.arg1, par.arg2);
                    } else if (par.commandName.compareTo("mkdir") == 0) {
                       // terminal.mkdir(par.arg1);
                    } else if (par.commandName.compareTo("rmdir") == 0) {
                        //terminal.rmdir(par.arg1);
                    } else if (par.commandName.compareTo("rm") == 0) {
                       // terminal.rm(par.arg1);
                    } else if (par.commandName.compareTo("ls") == 0) {
                        //terminal.ls();
                    } else if (par.commandName.compareTo("cat") == 0) {
                       // terminal.cat(par.arg1);
                    } else if (par.commandName.compareTo("cp") == 0) {
                       // terminal.cp(par.arg1, par.arg2);
                    } else if (par.commandName.compareTo("echo") == 0) {
                       // terminal.echo(par.arg1);
                    } else if (par.commandName.compareTo("touch") == 0) {
                        //terminal.touch();
                    } else if (par.commandName.compareTo("ls -r") == 0) {
                        //terminal.ls_r();
                    } else {
                   //     terminal.pwd();
                    }
                }
            } catch (Exception var6) {
                System.out.println(var6.getMessage());
            }
        }
    }
}
