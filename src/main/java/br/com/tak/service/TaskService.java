package br.com.tak.service;

import br.com.tak.data.vo.TaskVO;
import br.com.tak.domain.Task;
import br.com.tak.mapper.Mapper;
import br.com.tak.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository repository;

    public TaskVO create(TaskVO taskVO) {
        var entity = Mapper.parseObject(taskVO, Task.class);
        var vo = Mapper.parseObject(repository.save(entity), TaskVO.class);
        return vo;
    }
}
