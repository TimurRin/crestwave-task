package ru.timurrin.crestwave.task.process;

import java.util.List;

public class ProcessDto {
    private String name;
    private String description;
    private List<ProcessValueDto> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProcessValueDto> getData() {
        return data;
    }

    public void setData(List<ProcessValueDto> data) {
        this.data = data;
    }
}
