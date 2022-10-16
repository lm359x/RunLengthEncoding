package decoder;

import java.util.regex.Pattern;

public class Decoder {

    public String decode(String input){
        if(!checkInput(input))
            throw new RuntimeException("Wrong input");
        StringBuilder builder = new StringBuilder();
        char lastSymbol = input.charAt(0);
        for(int i = 1;i<input.length();i++){
            char currentSymbol = input.charAt(i);
            if(Character.isDigit(lastSymbol)){
                builder.append(String.valueOf(currentSymbol).repeat(Character.getNumericValue(lastSymbol)));
            }else{
                if(!Character.isDigit(currentSymbol))
                    builder.append(currentSymbol);
            }
            lastSymbol=currentSymbol;
        }
        return builder.toString();
    }


    public boolean checkInput(String input){
        Pattern pattern = Pattern.compile("([2-9]?[A-Z])+");
        return pattern.matcher(input).matches();
    }
}
