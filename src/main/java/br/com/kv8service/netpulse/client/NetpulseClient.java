package br.com.kv8service.netpulse.client;

import br.com.kv8service.netpulse.client.service.ProcessamentoService;

/**
 *
 * @author Vanderlei Cavassin
 */
public class NetpulseClient {

    public static void main(String[] args) {
   
        try {
            ProcessamentoService service = new ProcessamentoService();
            service.PERIOD = 15;
            service.make();
            service.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
