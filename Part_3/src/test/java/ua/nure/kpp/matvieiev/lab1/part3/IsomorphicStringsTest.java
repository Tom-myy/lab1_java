package ua.nure.kpp.matvieiev.lab1.part3;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {

    @Test
    public void tryingToUsePrivateConstructorTest(){
        //todo is it possible to do smth like that?
        //I know exactly this method for this class doesn't have any sense, but is it possible to
        // use reflection with private constructor like here?? coz I've heard about using of
        // reflection for private methods... so it's interesting for me..

        // and also if it's possible to do that is it good practice???

        IsomorphicStrings iso = new IsomorphicStrings();

        try {
            Method method = IsomorphicStrings.class.getDeclaredMethod("IsomorphicStrings",
                    String.class, String.class);

            method.setAccessible(true);

            method.invoke(iso, "paper", "title");

            assertEquals("paper title", iso.getWords());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}