package eskimo;

import cucumber.api.java.an.E;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.mk_latn.No;
import main.MyApplication;
import objects.*;
import org.junit.Assert;
import view.GrafNezet;

import java.util.ArrayList;

public class MyStepdefs {
    Eszkimo e;
    Medve medve;
    ArrayList<Szereplo> szereplok;

    Mezo m;
    InstabilJegtabla ijt;
    ArrayList<Mezo> mezok = new ArrayList<>();

    Targy aso = null;

    @Given("A fresh game")
    public void resetGame() {
        e = null;
        medve = null;
        m = null;
        ijt = null;
        aso = null;
        mezok = new ArrayList<>();
        szereplok = new ArrayList<>();
        Palya.setGameOver(false);
    }

    @Given("A fresh Eskimo")
    public void aFreshEskimo() {
        e = new Eszkimo("1");
        Mezo eskimoStarter = new StabilJegtabla("eskimoStarterField", null);
        eskimoStarter.setEpulet(new Noglu() {
            @Override
            public void Tamadas() {
                Palya.setGameOver(true);
            }
        });
        eskimoStarter.Befogad(e, null);
        e.setMezo(eskimoStarter);
        mezok.add(eskimoStarter);
    }

    @Given("A fresh stable Field")
    public void aFreshStableField() {
        m = new StabilJegtabla("stable nosnow field " + mezok.size(), aso);
        m.setfelderitett(true);
        m.setEpulet(new Noglu() {
            @Override
            public void Tamadas() {
                Palya.setGameOver(true);
            }
        });
        mezok.add(m);
    }

    @Given("A fresh stable field with snow of {int}")
    public void aFreshStableFieldWithSnowOf(int snow) {
        m = new StabilJegtabla("stable snowy field " + mezok.size(), aso);
        m.setfelderitett(true);
        m.setHovastagsag(snow);
        mezok.add(m);
    }

    @Given("A fresh unstable field with stability of {int}")
    public void aFreshUnstableField(int stability) {
        ijt = new InstabilJegtabla("unstable nosnow field " + mezok.size(), aso, stability);
        ijt.setfelderitett(true);
        mezok.add(ijt);
    }

    @Given("A fresh Item")
    public void aFreshItem() {
        aso = new Aso();
    }

    @Given("A fresh group of {int} eskimos")
    public void multiplePlayers(int number) {
        szereplok = new ArrayList<>();
        for (Integer i = 0; i < number; i++) {
            Eszkimo newEszkimo = new Eszkimo(i.toString());
            Mezo eskimoStarter = new StabilJegtabla("eskimoStarterField" + i, null);
            newEszkimo.setMezo(eskimoStarter);
            szereplok.add(newEszkimo);
            mezok.add(eskimoStarter);
        }
    }

    @Given("A fresh bear")
    public void aFreshBear() {
        medve = new Medve(false, "medve");
        Mezo medveStarter = new StabilJegtabla("medveStarter", null);
        medve.setMezo(medveStarter);
        mezok.add(medveStarter);
    }

    @When("The fields are connected")
    public void connectFields() {
        for (Mezo m : mezok) {
            for (Mezo szomszed : mezok) {
                if (m != szomszed)
                    m.setSzomszed(szomszed);
            }
        }
    }

    @When("Eskimo steps {int}")
    public void eskimoSteps(int arg0) {
        Mezo starterMezo = e.getMezo();
        int mezoIndex =  mezok.indexOf(starterMezo) + 1 < mezok.size() ?
                mezok.indexOf(starterMezo) + 1
                : 0;

        for (int i = 0; i < arg0; i++) {

            e.Atlep(mezok.get(mezoIndex));

            if (mezoIndex + 1 < mezok.size())
                mezoIndex++;
            else
                mezoIndex = 0;
        }
    }

    @When("Eskimo picks up item")
    public void eskimoPicksUpItem() {
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
        e.Atlep(ijt);
    }

    @When("Group of eskimos step onto unstable field")
    public void allEskimosStepOntoUnstableField() {
        for (Szereplo s : szereplok) {
            s.Atlep(ijt);
        }
    }

    @When("Eskimo cleans field")
    public void eskimoCleansField() {
        e.setMezo(m);
        e.Takarit();
    }

    @When("Bear moves to field")
    public void bearMovesToField() {
        medve.Atlep(m);
    }

    @When("Eskimo builds igloo on their field")
    public void buildIgloo() {
        e.SpecKepesseg(e.getMezo());
    }

    @When("^We give the eskimo (.*?)$")
    public void giveItemToEskimo(String item) {
        Targy targy;
        switch (item) {
            case "Tent":
                targy = new Sator(){
                    @Override
                    public void Tamadas() {
                        Palya.setGameOver(true);
                    }
                };
                break;
            case "Diving Suit":
                targy = new Buvarruha();
                break;
            default:
                targy = new Elelem();
                break;
        }
        Mezo starterMezo = e.getMezo();
        Mezo itemMezo = new StabilJegtabla("temporary", targy);
        e.setMezo(itemMezo);
        e.Felvesz();
        e.setMezo(starterMezo);

    }

    @When("Eskimo uses its item")
    public void useItem(){
        if(e.getTargyak().size() > 1) {
            e.Hasznal(e.getTargy(1), e.getMezo());
        }
    }

    //e.GetTargyak().size() - 1, because Eszkimo gets instantiated with 1 Elelem
    @Then("Eskimo should have {int} item")
    public void eskimoShouldHaveItem(int arg0) {
        Assert.assertEquals(arg0, e.getTargyak().size() - 1);
    }

    @Then("Eskimo movement should be {int}")
    public void eskimoMovementShouldBe(int arg0) {
        Assert.assertEquals(arg0, e.getLepesszam());
    }

    @Then("Eskimo health should be {int}")
    public void eskimoHealthShouldBe(int arg0) {
        Assert.assertEquals(arg0, e.getTestho());
    }

    @Then("Number of people under field should be {int}")
    public void assertPeopleNumberUnderField(int arg0) {
        Assert.assertEquals(arg0, ijt.getAlatta().size());
    }

    @Then("Snow on the last field should be {int}")
    public void assertSnowOnField(int arg0) {
        Assert.assertEquals(arg0, m.gethoVastagsag());
    }

    //field meaning the last added stable field
    @Then("^Entity on the last field should be (.*?)$")
    public void assertEntityOnField(String entity) {
        switch (entity) {
            case "Eskimo":
                Assert.assertEquals(e.getId(), m.getSzereplok().get(0).getId());
                break;
            case "Bear":
                Assert.assertEquals(medve.getId(), m.getSzereplok().get(0).getId());
                break;
            case "Nothing":
                Assert.assertEquals(0, m.getSzereplok().size());
                break;
        }
    }

    @Then("^Building on the last field should be (.*?)$")
    public void assertBuildingOnField(String entity) {
        switch (entity) {
            case "Igloo":
                Assert.assertEquals("Iglu", m.getEpulet().Name());
                break;
            case "Tent":
                Assert.assertEquals("Sator", m.getEpulet().Name());
                break;
            default:
                Assert.assertEquals("Noglu", m.getEpulet().Name());
                break;
        }
    }

    @Then("Players should lose")
    public void assertLose() {
        Assert.assertTrue(Palya.isGameOver());
        Assert.assertFalse(Palya.getNyertek());
    }

    @Then("Players should not lose")
    public void assertNotLose() {
        Assert.assertFalse(Palya.isGameOver());
    }
    
    @When("Snowstorm comes")
    public void snowstormComes() {
        mezok.forEach(Mezo::Hoeses);
    }


    @Then("The amount of snow should be {int}")
    public void theAmountOfSnowShouldBe(int arg0) {
        Assert.assertEquals(m.gethoVastagsag(), arg0);
    }
}
