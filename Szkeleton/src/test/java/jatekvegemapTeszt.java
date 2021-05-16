import objects.Aso;
import objects.Noglu;
import objects.Palya;
import objects.Sator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;

public class jatekvegemapTeszt {
    @Before
    public void init() throws Exception {
        File f = new File("./src/test/palya/jatekvege.map");
        Palya.JatekotKezd(new FileInputStream(f));
    }

    // Teszt19
    @Test
    public void satorEltunik(){
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo9"));
        Palya.getAktJatekos().Felvesz();
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo9"));
        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1),Palya.getMezo("mezo9"));
        assertEquals(Sator.class,Palya.getMezo("mezo9").getEpulet().getClass());
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        assertEquals(Noglu.class,Palya.getMezo("mezo9").getEpulet().getClass());
    }

    // Teszt18
    @Test
    public void hoesesVanEpulet(){
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo6"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo1"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo1"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo1"));

        int testho = Palya.getAktJatekos().getTestho();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Vegeztem();

        assertEquals(testho,Palya.getAktJatekos().getTestho());


    }

    // Teszt20
    @Test
    public void sikertelenTargyfelvetel(){
        Palya.getAktJatekos().Vegeztem();

        assertEquals(1,Palya.getAktJatekos().getTargyak().size());
        Palya.getAktJatekos().Felvesz();
        assertEquals(1,Palya.getAktJatekos().getTargyak().size());
    }

    // Teszt14
    @Test
    public void asasAsoval() {
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo6"));
        Palya.getAktJatekos().Felvesz();
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo1"));
        Palya.getAktJatekos().Vegeztem();

        assertEquals(2, Palya.getAktJatekos().getTargyak().size());
        assertEquals(Aso.class, Palya.getAktJatekos().getTargy(1).getClass());
        assertEquals(6, Palya.getMezo("mezo3").gethoVastagsag());

        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1), Palya.getAktJatekos().getMezo());
        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1), Palya.getAktJatekos().getMezo());
        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1), Palya.getAktJatekos().getMezo());

        assertEquals(1, Palya.getAktJatekos().getTargyak().size());
        assertEquals(0, Palya.getMezo("mezo3").gethoVastagsag());
    }
}
