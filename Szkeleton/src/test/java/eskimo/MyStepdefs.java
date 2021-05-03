package eskimo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.*;
import org.junit.Assert;
import view.GrafNezet;

import java.util.ArrayList;

public class MyStepdefs {
    Eszkimo e;
    ArrayList<Szereplo> szereplok;

    Mezo m;
    InstabilJegtabla ijt;
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

    @Given("A stable field with snow of {int}")
    public void aFreshStableFieldWithSnowOf(int snow){
        m = new StabilJegtabla("1", aso);
        m.setHovastagsag(snow);
    }

    @Given("A fresh unstable field with stability of {int}")
    public void aFreshUnstableField(int stability) {
        ijt = new InstabilJegtabla("1", aso, stability){
            int teherbiras = stability;

            @Override
            public boolean Befogad(Szereplo belepo, Mezo regi) {
                this.szereplok.add(belepo);
                if(teherbiras < szereplok.size()) {
                    Felfordul();
                }
                Hatas(belepo);
                return true;
            }
        };
    }

    @Given("A fresh Item")
    public void aFreshItem() {
        aso = new Aso();
    }

    @Given("A group of {int} eskimos")
    public void multiplePlayers(int number) {
        szereplok = new ArrayList<>();
        for (Integer i = 0; i < number; i++)
            szereplok.add(new Eszkimo(i.toString()));
    }

    @When("Eskimo steps {int}")
    public void eskimoSteps(int arg0) {
        e.setMezo(m);
        for (int i = 0; i < arg0; i++)
            e.Atlep(m);
    }

    @When("Eskimo picks up item")
    public void eskimoPicksUpItem() {
        e.setMezo(m);
        e.Felvesz();
    }

    @When("Eskimo eats food")
    public void eskimoEatsFood() {
        e.Hasznal(e.getTargy(0), m);
    }

    @When("Eskimo health drops {int}")
    public void eskimoHealthDrops(int arg0) {
        e.TesthoHozzaad(-arg0);
    }

    @When("Eskimo steps onto unstable field")
    public void eskimoStepsOntoUnstableField() {
        e.setMezo(ijt);
        ijt.Befogad(e, null);
    }

    @When("Group of eskimos step onto unstable field")
    public void allEskimosStepOntoUnstableField() {
        for (Szereplo s: szereplok) {
            s.setMezo(ijt);
            ijt.Befogad(s, null);
        }
    }

    @When("Eskimo cleans field")
    public void eskimoCleansField(){
        e.setMezo(m);
        e.Takarit();
    }

    @Then("Eskimo should have {int} item")
    public void eskimoShouldHaveItem(int arg0) {
        Assert.assertEquals(arg0, e.getTargyak().size() - 1);
    }

    @Then("Eskimo movement should be {int}")
    public void eskimoMovementShouldBe(int arg0) {
        Assert.assertEquals(e.getLepesszam(), arg0);
    }

    @Then("Eskimo health should be {int}")
    public void eskimoHealthShouldBe(int arg0) {
        Assert.assertEquals(arg0, e.getTestho());
    }

    @Then("Number of people under field should be {int}")
    public void assertPeopleNumberUnderField(int arg0) {
        Assert.assertEquals(arg0, ijt.getAlatta().size());
    }

    @Then("Snow on field should be {int}")
    public void assertSnowOnField(int arg0){
        Assert.assertEquals(arg0, m.gethoVastagsag());
    }
}
