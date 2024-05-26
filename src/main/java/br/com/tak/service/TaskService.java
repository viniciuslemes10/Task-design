package br.com.tak.service;

import br.com.tak.data.vo.TaskVO;
import br.com.tak.domain.Task;
import br.com.tak.exceptions.ResourceNotFoundException;
import br.com.tak.exceptions.ResourceObjectIsNotNullException;
import br.com.tak.mapper.Mapper;
import br.com.tak.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public TaskVO create(TaskVO taskVO) {
        if(taskVO == null) throw new ResourceObjectIsNotNullException();
        var entity = Mapper.parseObject(taskVO, Task.class);
        var vo = Mapper.parseObject(repository.save(entity), TaskVO.class);
        return vo;
    }

    public TaskVO listTask(Long id) {
        var vo = Mapper.parseObject(repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!")), TaskVO.class);
        return vo;
    }
}
