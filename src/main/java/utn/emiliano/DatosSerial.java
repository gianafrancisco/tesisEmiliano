package utn.emiliano;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by francisco on 18/02/16.
 */
@Component("datosSerial")
public class DatosSerial implements Consumer<String>, Supplier<StringBuffer> {

    private StringBuffer dato = new StringBuffer();

    private final String test = "Fecha: 17/02/2016 \n" +
            "Hora:  22:15:20 \n" +
            "REMITO:1-12121212121 \n" +
            "TAMBO: 2-12345\n" +
            "SISTERNA: 1 \n" +
            "ANTIBIOTICO: NO \n" +
            "CAUDAL:666 L \n" +
            "TEMPERATURA= 21 \n" +
            "*********************\n" +
            "CHOFER: EMA PRADO\n" +
            "Fecha: 17/02/2016 \n" +
            "Hora:  22:15:20 \n" +
            "REMITO:1-12121212121 \n" +
            "TAMBO: 2-12345\n" +
            "SISTERNA: 1 \n" +
            "ANTIBIOTICO: NO \n" +
            "CAUDAL:666 L \n" +
            "TEMPERATURA= 21 \n" +
            "*********************\n" +
            "CHOFER: EMA PRADO\n" +
            "Fecha: 17/02/2016 \n" +
            "Hora:  22:15:20 \n" +
            "REMITO:1-12121212121 \n" +
            "TAMBO: 2-12345\n" +
            "SISTERNA: 1 \n" +
            "ANTIBIOTICO: NO \n" +
            "CAUDAL:666 L ";



    @Override
    public void accept(String s) {
        dato.append(s);
    }

    @Override
    public StringBuffer get() {
        return dato;
        //return new StringBuffer(test);
    }
}
