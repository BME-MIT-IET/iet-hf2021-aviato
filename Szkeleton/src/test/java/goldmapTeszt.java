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
}
