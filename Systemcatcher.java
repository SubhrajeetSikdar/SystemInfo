import java.net.InetAddress;
import java.net.UnknownHostException;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarLoader;
import org.hyperic.sigar.Uptime;
import org.hyperic.sigar.Who;

public class Systemcatcher {
    public static void main(String[] args) {
        // Fetch IP Address
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Fetch basic system information
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));
        System.out.println("User: " + System.getProperty("user.name"));

        // Fetch detailed system information using Sigar
        Sigar sigar = new Sigar();
        try {
            // CPU Information
            CpuInfo[] cpuInfoList = sigar.getCpuInfoList();
            Cpu cpu = sigar.getCpu();
            System.out.println("CPU Info:");
            for (CpuInfo info : cpuInfoList) {
                System.out.println("Vendor: " + info.getVendor());
                System.out.println("Model: " + info.getModel());
                System.out.println("Mhz: " + info.getMhz());
            }

            // Memory Information
            Mem mem = sigar.getMem();
            System.out.println("Memory Info:");
            System.out.println("Total: " + mem.getTotal() / 1024 / 1024 + " MB");
            System.out.println("Used: " + mem.getUsed() / 1024 / 1024 + " MB");
            System.out.println("Free: " + mem.getFree() / 1024 / 1024 + " MB");

            // File System Information
            FileSystem[] fileSystemList = sigar.getFileSystemList();
            for (FileSystem fs : fileSystemList) {
                System.out.println("File System: " + fs.getDevName());
                FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
                System.out.println("Total: " + usage.getTotal() + " KB");
                System.out.println("Used: " + usage.getUsed() + " KB");
                System.out.println("Free: " + usage.getFree() + " KB");
            }

            // Network Information
            String[] netInterfaceList = sigar.getNetInterfaceList();
            for (String name : netInterfaceList) {
                NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
                NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
                System.out.println("Network Interface: " + name);
                System.out.println("Address: " + ifconfig.getAddress());
                System.out.println("MAC Address: " + ifconfig.getHwaddr());
                System.out.println("RX Packets: " + ifstat.getRxPackets());
                System.out.println("TX Packets: " + ifstat.getTxPackets());
            }

            // Uptime Information
            Uptime uptime = sigar.getUptime();
            System.out.println("Uptime: " + uptime.getUptime() + " seconds");

        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
}
