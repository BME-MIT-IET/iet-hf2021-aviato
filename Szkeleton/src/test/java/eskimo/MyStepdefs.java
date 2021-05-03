package eskimo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.*;
import org.junit.Assert;
import view.GrafNezet;

public class MyStepdefs {
    Eszkimo e;
    Mezo m;
    Targy aso = null;
    @Given("A fresh Eskimo")
    public void aFreshEskimo() {
        e = new Eszkimo("1");
    }

    @Given("A fresh Field")
    public void aFreshField() {
        m = new Jegtabla("1", aso) {
            @Override
            public boolean Befogad(Szereplo belepo, Mezo regi) {
                return true;
            }

            @Override
            public void setEpulet(Epulet e) {

            }

            @Override
            public void Hatas(Szereplo sz) {

            }

            @Override
            public String getTeherBiras() {
                return null;
            }

            @Override
            public String Name() {
                return null;
            }

            @Override
            public void FrissitNezet(GrafNezet n) {

            }
        };
    }

    @When("Eskimo steps {int}")
    public void eskimoSteps(int arg0) {
        e.setMezo(m);
        for(int i = 0; i < arg0; i++)
            e.Atlep(m);
    }

    @Then("Eskimo movement should be {int}")
    public void eskimoMovementShouldBe(int arg0) {
        Assert.assertEquals(e.getLepesszam(), arg0);
    }

    @Given("A fresh Item")
    public void aFreshItem() {
        aso = new Aso();
    }

    @When("Eskimo picks up item")
    public void eskimoPicksUpItem() {
        e.setMezo(m);
        e.Felvesz();
    }

    @Then("Eskimo has {int} item")
    public void eskimoHasItem(int arg0) {
        Assert.assertEquals(arg0, e.getTargyak().size() - 1);
    }

    @When("Eskimo eats food")
    public void eskimoEatsFood() {
        e.Hasznal(e.getTargy(0), m);
    }

    @Then("Eskimo health should be {int}")
    public void eskimoHealthShouldBe(int arg0) {
        Assert.assertEquals(arg0, e.getTestho());
    }

    @When("Eskimo health drops {int}")
    public void eskimoHealthDrops(int arg0) {
        e.TesthoHozzaad(-arg0);
    }
}
