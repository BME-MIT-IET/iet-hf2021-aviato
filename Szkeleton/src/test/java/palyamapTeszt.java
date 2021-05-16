import main.MyApplication;
import objects.Mezo;
import objects.Noglu;
import objects.Szereplo;
import org.junit.Before;
import org.junit.Test;
import objects.Palya;

import java.io.*;

import static org.junit.Assert.*;

public class palyamapTeszt {

    @Before
    public void init() throws Exception {
        File f = new File("./src/test/palya/palyamap.map");
        Palya.JatekotKezd(new FileInputStream(f));
    }

    // Teszt 1
    @Test
    public void lepesTeszt() {
        Szereplo aktSzereplo = Palya.getAktJatekos();
        assertEquals(4, aktSzereplo.getLepesszam());
        Mezo mezo2 = Palya.getMezo("mezo2");
        aktSzereplo.Atlep(mezo2);
        assertEquals(mezo2, aktSzereplo.getMezo());
        assertEquals(3, aktSzereplo.getLepesszam());
    }

    // Teszt 10
    @Test
    public void asasLapattalTeszt() {
        // Szereplo1
        Szereplo aktSzereplo = Palya.getAktJatekos();
        aktSzereplo.Takarit();
        aktSzereplo.Takarit();
        aktSzereplo.Felvesz();
        aktSzereplo.Atlep(Palya.getMezo("mezo6"));
        aktSzereplo.Vegeztem();
        // Szereplo2
        assertFalse(aktSzereplo == Palya.getAktJatekos());
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo6"));
        Palya.getAktJatekos().Vegeztem();
        // Szereplo3
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo6"));
        Palya.getAktJatekos().Vegeztem();
        // Szereplo1
        assertEquals(2, Palya.getMezo("mezo6").gethoVastagsag());
        aktSzereplo.Hasznal(aktSzereplo.getTargy(1), aktSzereplo.getMezo());
        assertEquals(0, Palya.getMezo("mezo6").gethoVastagsag());
    }

    // Teszt 26
    @Test
    public void kutatoSikeresFelderitesTeszt() {
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo3"));
        assertTrue(Palya.getMezo("mezo3").getfelderitett());
    }

    // Teszt 28
    @Test
    public void kutatoSikertelenFelderitesTeszt() {
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo13"));
        assertFalse(Palya.getMezo("mezo13").getfelderitett());
    }

    // Teszt 30
    @Test
    public void eszkimoSikertelenEpites(){
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().SpecKepesseg(Palya.getMezo("mezo2"));
        assertEquals(Noglu.class,Palya.getMezo("mezo2").getEpulet().getClass());
    }

    // Teszt 33
    @Test
    public void lukbaEses(){
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        assertFalse(Palya.getMezo("mezo4").getfelderitett());
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo4"));
        assertTrue(Palya.getMezo("mezo4").getfelderitett());
    }

    // Teszt4
    @Test
    public void lukraLepBuvarruhaval() throws IOException {
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Felvesz();
        Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(1), Palya.getAktJatekos().getMezo());
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Vegeztem();

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Vegeztem();

        assertEquals(5, Palya.getAktJatekos().getTestho());
        assertEquals(4, Palya.getAktJatekos().getLepesszam());

        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo4"));

        assertEquals(5, Palya.getAktJatekos().getTestho());
        assertEquals(3, Palya.getAktJatekos().getLepesszam());
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);
        StringBuffer sb = new StringBuffer();
        Palya.getMezo("mezo4").MezoInfo(bw);
        bw.flush();
        sb = sw.getBuffer();
        assertEquals("mezo4 Luk 0 Noglu szereplo1\r\n", sb.toString());
    }

    // Teszt 5
    @Test
    public void instabilFelborul() {
        // szereplo1
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        // szereplo2
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        Palya.getAktJatekos().Vegeztem();

        // szereplo3
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo2"));
        Palya.getAktJatekos().Atlep(Palya.getMezo("mezo3"));
        assertTrue(Palya.getMezo("mezo3").getfelderitett());
    }
}
