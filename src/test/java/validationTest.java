import Previous_Peojects.validation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validationTest {

    private validation object = new validation();

    @Test
    public void validate_add(){
        int original_value = object.add(2,4);
        int expected_value = 6;

        Assert.assertEquals(original_value,expected_value);
    }

}