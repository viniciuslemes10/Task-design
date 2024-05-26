package br.com.tak.controller;

import br.com.tak.data.vo.TaskVO;
import br.com.tak.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task/v1")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskVO> create(@RequestBody TaskVO taskVO) {
        TaskVO vo = service.create(taskVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vo);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskVO listTask(@PathVariable Long id) {
        return service.listTask(id);
    }
}
