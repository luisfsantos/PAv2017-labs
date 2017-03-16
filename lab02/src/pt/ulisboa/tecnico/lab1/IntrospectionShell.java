package pt.ulisboa.tecnico.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.Class;

/**
 * Created by lads on 09/03/2017.
 */
public class IntrospectionShell {

    public static void main(String[] args) {
        InputStreamReader rdr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(rdr);
        String line;
        List<String> lineArgs;
        HashMap<String, Class> classes = new HashMap<>();
        Class activeClass;
        try {
            while ((line = br.readLine()) != null || !line.equals("exit")) {
                lineArgs = Arrays.stream(line.split(" ")).collect(Collectors.toList());
                try {
                    activeClass = Class.forName("pt.ulisboa.tecnico.lab1".concat(".").concat(lineArgs.get(0)));
                    if (!activeClass.isAssignableFrom(Command.class)) {
                        Object cmd = activeClass.getDeclaredConstructor(List.class).newInstance(lineArgs.subList(1, lineArgs.size()));
                        ((Command) cmd).execute();
                    } else {
                        System.out.println(true);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            rdr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
