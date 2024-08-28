package br.com.kv8service.netpulse.client.service;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

/**
 *
 * @author Vanderlei Cavassin
 */
public class NetPulseService {

    public void processar() {
        System.out.println("Vande");
        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();
        GlobalMemory memory = si.getHardware().getMemory();

        System.out.println("Nome do sistema operacional: " + si.getOperatingSystem().getFamily());
        System.out.println("Número de núcleos da CPU: " + cpu.getLogicalProcessorCount());
        System.out.println("Memória total instalada: " + memory.getTotal() / (1024 * 1024) + " MB");
        System.out.println("Memória total Avaliable: " + memory.getAvailable() / (1024 * 1024) + " MB");
        System.out.println("Memória total Page Size: " + memory.getPageSize() / (1024 * 1024) + " MB");
        System.out.println("Frequencia processador: " + si.getHardware().getProcessor().getMaxFreq());
        System.out.println("CPU Load: " + cpu.getSystemCpuLoad(0));
//     
    }

}
