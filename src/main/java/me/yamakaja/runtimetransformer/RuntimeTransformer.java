package me.yamakaja.runtimetransformer;

import com.google.common.collect.Lists;
import com.sun.tools.attach.VirtualMachine;
import io.github.nbcss.xengine.XEngine;
import io.github.nbcss.xengine.utils.Reflection;
import me.yamakaja.runtimetransformer.service.AgentPack;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yamakaja on 19.05.17.
 */
public class RuntimeTransformer {
    private static final List<XMessageProcessor> processors = Lists.newArrayList();
    private static final List<Class<?>> transformers = Lists.newArrayList();
    private RuntimeTransformer() {}

    public static void addProcessors(XMessageProcessor... processors){
        RuntimeTransformer.processors.addAll(Arrays.asList(processors));
    }

    public static void addTransformers(Class<?>... transformers){
        RuntimeTransformer.transformers.addAll(Arrays.asList(transformers));
    }

    public static void attach(XEngine plugin, boolean temp){
        try{
            attachAgent(saveAgentJar(plugin, temp), transformers.toArray(new Class<?>[0]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void attachAgent(File agentFile, Class<?>[] transformers) {
        try {
            String key = "Minecraft:XEngine=Transformer";
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName(key);
            AgentPack pack = new AgentPack(processors, transformers);
            server.registerMBean(pack, name);

            String pid = String.valueOf(ProcessHandle.current().pid());
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(agentFile.getAbsolutePath(), key + " " + Reflection.bukkitVersion());
            vm.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static File saveAgentJar(XEngine plugin, boolean temp) {
        try (InputStream in = RuntimeTransformer.class.getResourceAsStream("/BaseAgent-1.0-SNAPSHOT.jar")) {
            assert in != null;
            File agentFile;
            if(temp){
                agentFile = File.createTempFile("agent", ".jar");
            }else{
                agentFile = new File(plugin.getDataFolder(), "agent-temp.jar");
                agentFile.mkdirs();
            }
            //File.createTempFile("agent-temp", ".jar");
            agentFile.deleteOnExit();
            Files.copy(in, agentFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return agentFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
