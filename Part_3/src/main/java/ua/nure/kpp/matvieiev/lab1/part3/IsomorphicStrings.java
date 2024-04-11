package ua.nure.kpp.matvieiev.lab1.part3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings {

    Scanner sc = new Scanner(System.in);

    private String firstWord;
    private String secondWord;

    public void setWords() {
        System.out.print("Enter first word: ");
        firstWord = sc.next();

        System.out.print("Enter second word: ");
        secondWord = sc.next();
    }
    public boolean isIsomorphic() {
        if (firstWord.length() != secondWord.length())
            return false;

        Map<Character, Character> one_key_dict = new HashMap<>();
        Map<Character, Character> two_key_dict = new HashMap<>();

        for (int i = 0; i < firstWord.length(); ++i) {
            char oneTmp = firstWord.charAt(i);
            char twoTmp = secondWord.charAt(i);

            if (!one_key_dict.containsKey(oneTmp))
                one_key_dict.put(oneTmp, twoTmp);
            else {
                char valueByKey_1 = one_key_dict.get(oneTmp);
                if (valueByKey_1 != twoTmp)
                    return false;
            }

            if (!two_key_dict.containsKey(twoTmp))
                two_key_dict.put(twoTmp, oneTmp);
            else {
                char valueByKey_2 = two_key_dict.get(twoTmp);
                if (valueByKey_2 != oneTmp)
                    return false;
            }
        }
        return true;
    }

    public void Isomorphic() {
        System.out.print("These two words: \"" + firstWord + "\" and \"" + secondWord + "\" - ");
        if(isIsomorphic())
            System.out.print("isomorphic!");
        else
            System.out.print("NOT isomorphic!");
    }
}
