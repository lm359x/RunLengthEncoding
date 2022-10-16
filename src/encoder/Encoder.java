package encoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoder {

    public String Encode(String input){
        if(!checkString(input))
            throw new RuntimeException("Wrong input");
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        char lastSymbol = input.charAt(0);

        for(int i = 1; i<input.length();i++){
            char currentSymbol = input.charAt(i);
            if (lastSymbol!=currentSymbol){
                if(counter>1)
                    builder.append(counter);
                builder.append(lastSymbol);
                lastSymbol = currentSymbol;
                counter = 1;
            }else{
                counter++;
            }
        }
        if(counter>1)
            builder.append(counter);
        builder.append(lastSymbol);
        return builder.toString();
    }

    public boolean checkString(String input){
        Pattern pattern = Pattern.compile("[A-Z]+");
        return pattern.matcher(input).matches();
    }
}
