import objects.InstabilJegtabla;
import objects.Mezo;
import objects.Noglu;
import objects.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class buildmapTeszt {
    @Before
    public void init() throws Exception {
        File f = new File("./src/test/palya/Gold.map");
        Palya.JatekotKezd(new FileInputStream(f));
    }

    @Test
    public void szomszedTeszt() {

        List<Mezo> szomszed = new ArrayList<Mezo>();
        szomszed.add(Palya.getMezo("mezo2"));
        szomszed.add(Palya.getMezo("mezo4"));
        szomszed.add(Palya.getMezo("mezo8"));

        assertEquals(szomszed,Palya.getMezo("mezo1").getSzomszed());


    }

    @Test
    public void mezoTeszt(){
        Mezo mezo = Palya.getMezo("mezo6");
        assertEquals(InstabilJegtabla.class,mezo.getClass());
        assertEquals(2,Integer.parseInt(mezo.getTeherBiras()));
        assertEquals(2,mezo.gethoVastagsag());
        assertEquals(Palya.getSzereplo("szereplo1"),mezo.getSzereplok().get(0));
        assertEquals(Noglu.class,mezo.getEpulet().getClass());
    }

    @Test
    public void mennyisegTeszt(){
        assertEquals(3,Palya.getSzereplokSzama());
        assertEquals(13,Palya.getMezok().size());
    }
}
