import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class validationTest {

    private validation object = new validation();

    @Test
    public void validate_add(){
        int original_value = object.add(2,4);
        int expected_value = 6;

        Assert.assertEquals(original_value,expected_value);
    }

}