package br.com.tak.controller;

import br.com.tak.data.vo.TaskVO;
import br.com.tak.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task/v1")
public class TaskController {
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskVO> create(@RequestBody TaskVO taskVO) {
        var vo = service.create(taskVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vo);
    }
}
