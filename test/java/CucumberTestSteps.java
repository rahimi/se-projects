import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Cucumber
public class CucumberTestSteps {
    Calculator calc;

    @Given("a calculator")
    public void setup(){
        calc = new Calculator();
    }

    @When("adding the numbers {int} and {int}")
    public void testStep1(int arg1, int arg2){
        calc.add(arg1,arg2);
    }

    @Then("calculator returns a {int}")
    public void thenValidation(int arg){
        assertEquals(arg,calc.result);
    }

    @When("multiplying the numbers {int} and {int}")
    public void multiplyingTheNumbersAnd(int arg0, int arg1) {
        calc.multiply(arg0, arg1);
    }

    class Calculator{
        int result;
        public void add(int val1, int val2){
            result = val1 + val2;
        }
        public void multiply(int val1, int val2) {result = val1*val2;}
    }

}
