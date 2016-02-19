package utn.emiliano.port;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import utn.emiliano.DatosSerial;

/**
 * Created by francisco on 15/06/15.
 */
@Component("serialPort")
public class Serial implements Runnable, SerialPortEventListener {

    public static final int SLEEP_TIME = 60000;
    private jssc.SerialPort port;

    @Autowired
    private DatosSerial datosSerial;

    @Value("${puerto.nombre}")
    private String puertoName;
    @Value("${puerto.baudRate}")
    private int baudRate;
    @Value("${puerto.dataBits}")
    private int dataBits;
    @Value("${puerto.stopBits}")
    private int stopBits;
    @Value("${puerto.parity}")
    private int parity;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_TIME);
                initPort();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (SerialPortException e) {
                port = null;
            }
        }
    }

    private void initPort() throws SerialPortException {
        if(port == null) {
            port = new jssc.SerialPort(puertoName);
            port.openPort();//Open port
            port.setParams(baudRate, dataBits, stopBits, parity);//Set params
            int mask = jssc.SerialPort.MASK_RXCHAR + jssc.SerialPort.MASK_CTS + jssc.SerialPort.MASK_DSR;//Prepare mask
            port.setEventsMask(mask);//Set mask
            port.addEventListener(this);//Add SerialPortEventListener
        }
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        //if (serialPortEvent.isRXCHAR()) {//If data is available
            try {
                String key = port.readString();
                System.out.print(key);
                datosSerial.accept(key);
            } catch (SerialPortException ex) {
                throw new RuntimeException(ex);
            }
        //}
    }
}
