import main.MyApplication;
import objects.Palya;
import objects.Szereplo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class goldmapTeszt {

    @Before
    public void init() throws Exception {
        File f = new File("./src/test/palya/Gold.map");
        Palya.JatekotKezd(new FileInputStream(f));
    }

    // Teszt 25
    @Test
    public void igluMegvedTeszt() {
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo5"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo9"));
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo5"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo5"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo5"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo5"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo9"));
        assertEquals("mezo9", Palya.getAktJatekos().getMezo().getId());
    }

    // Teszt11
    @Test
    public void eves() {
        assertEquals(5, Palya.getAktJatekos().getTestho());
        assertEquals(4, Palya.getAktJatekos().getLepesszam());

        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(0), Palya.getAktJatekos().getMezo());

        assertEquals(6, Palya.getAktJatekos().getTestho());
        assertEquals(3, Palya.getAktJatekos().getLepesszam());
    }

    // Teszt12
    @Test
    public void menekites() {
        Palya.getAktJatekos().Takarit();
        Palya.getAktJatekos().Takarit();
        Palya.getAktJatekos().Felvesz();
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo13"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo13"));
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo7"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo7"));
        Palya.getAktJatekos().Vegeztem();

        // medve
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo1"));
        Palya.getAktJatekos().Vegeztem();

        assertEquals(2, Palya.getMezo("mezo7").getSzereplokSzama());
        assertEquals(1, Palya.getMezo("mezo13").getSzereplokSzama());
        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1), Palya.getMezo("mezo7"));
        assertEquals(3, Palya.getMezo("mezo13").getSzereplokSzama());
        assertEquals(0, Palya.getMezo("mezo7").getSzereplokSzama());
    }
}
