package ru.timurrin.crestwave.task.process;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.timurrin.crestwave.task.config.Config;
import ru.timurrin.crestwave.task.form.FormDto;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

@Component
public class Process {
    private final Config config;

    @Autowired
    Process(Config config) {
        this.config = config;
    }

    public String run(FormDto formDto) {
        Gson gson = new Gson();

        ProcessDto processDto = new ProcessDto();
        processDto.setName(formDto.getName());
        processDto.setDescription(formDto.getDescr());
        processDto.setData(new ArrayList<>());
        int limit = formDto.getStart() + formDto.getCount();
        for (int i = formDto.getStart(); i < limit; i++) {
            ProcessValueDto processValueDto = new ProcessValueDto();
            processValueDto.setValue(i);
            processDto.getData().add(processValueDto);
        }

        String json = gson.toJson(processDto);

        try (Socket socket = new Socket(config.getTcpServerAddress(), config.getTcpServerPort())) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(json);
            return null;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
