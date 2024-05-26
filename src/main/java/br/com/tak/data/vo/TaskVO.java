package br.com.tak.data.vo;

import br.com.tak.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class TaskVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;
    private String title;
    private String description;
    private Status status;

    public TaskVO() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskVO taskVO)) return false;
        return Objects.equals(key, taskVO.key) && Objects.equals(title, taskVO.title) && Objects.equals(description, taskVO.description) && status == taskVO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, title, description, status);
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
