package me.yamakaja.runtimetransformer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.attach.VirtualMachine;
import io.github.nbcss.xengine.XEngine;
import me.yamakaja.runtimetransformer.agent.Agent;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static void attach(XEngine plugin){
        try{
            attachAgent(saveAgentJar(plugin), transformers.toArray(new Class<?>[0]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void attachAgent(File agentFile, Class<?>[] transformers) {
        try {
            String pid = String.valueOf(ProcessHandle.current().pid());
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(agentFile.getAbsolutePath());
            vm.detach();
            final Map<String, XMessageProcessor> handlers = Maps.newHashMap();
            for (XMessageProcessor processor : RuntimeTransformer.processors) {
                handlers.put(processor.getChannel(), processor);
            }
            Agent.getInstance().process(message -> {
                XMessageProcessor processor = handlers.get(message.getChannel());
                if(processor != null)
                    processor.handle(new XMessage(message));
            }, transformers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File saveAgentJar(XEngine plugin) {
        try (InputStream in = RuntimeTransformer.class.getResourceAsStream("/BaseAgent-1.0-SNAPSHOT.jar")) {
            assert in != null;
            File agentFile = new File(plugin.getDataFolder(), "agent-temp.jar");
            agentFile.mkdirs();
            //File.createTempFile("agent-temp", ".jar");
            agentFile.deleteOnExit();
            Files.copy(in, agentFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return agentFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
