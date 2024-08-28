package br.com.kv8service.netpulse.client.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanderlei Cavassin
 */
public class ProcessamentoService {
    private final short DELAY = 0;
    public short PERIOD = 1;
    private ScheduledExecutorService scheduler;
    private ScheduledFuture scheduledFuture;
    private Runnable runnableTask;
    
    
    public void make() {
        runnableTask = () -> {
            try {
                System.out.println("=== INICIADO MONITORAMENTO ===");
                NetPulseService service = new NetPulseService();
                service.processar();
                System.out.println("=== FINALIZADO MONITORAMENTO ===");
            } catch (Exception ex) {
                Logger.getLogger(ProcessamentoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
    
    public void start() {
        stop();

        scheduler = Executors.newScheduledThreadPool(1);
        scheduledFuture = scheduler.scheduleAtFixedRate(runnableTask, DELAY, PERIOD, TimeUnit.SECONDS);
    }

    public void stop() {
        if (isRunning()) {
            scheduledFuture.cancel(true);
            scheduler.shutdown();
        }

    }

    private boolean isRunning() {
        return (scheduledFuture != null) && (scheduledFuture.isDone() == false || scheduledFuture.isCancelled() == false || scheduler.isTerminated() == false);
    }
}
