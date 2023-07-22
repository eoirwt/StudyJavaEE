import org.junit.Test;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @ClassName: PatternSyntaxExceptionTest
 * @Package: PACKAGE_NAME
 * @Description: PatternSyntaxException 异常的测试
 */
public class PatternSyntaxExceptionTest {
    @Test
    public void test(){
        String regex = "a*[b";
        try {
            Pattern pattern = Pattern.compile(regex);
        }catch (PatternSyntaxException e){
            System.out.println("e.getDescription() = " + e.getDescription());
            System.out.println("e.getIndex() = " + e.getIndex());
            System.out.println("e.getPattern() = " + e.getPattern());
            System.out.println("e.getMessage() = " + e.getMessage());
            /*
            e.getDescription() = Unclosed character class
            e.getIndex() = 3
            e.getPattern() = a*[b
            e.getMessage() = Unclosed character class near index 3
            a*[b
               ^
             */
        }
    }
}
