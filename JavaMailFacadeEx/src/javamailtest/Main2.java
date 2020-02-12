package javamailtest;

import static sbcc.Core.*;

import java.io.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class Main2 {
	public static void main(String[] args) throws Exception {

		var mailer = new Mailer("smtp.gmail.com", "cs165sbcc@gmail.com", readFile("pwd"));

		mailer.send("cs123sbcc@gmail.com", "Won't be long", "Looking forward to it.");
	}
}
