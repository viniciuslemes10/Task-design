package br.com.tak.mapper;

import br.com.tak.data.vo.TaskVO;
import br.com.tak.domain.Task;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                TaskVO.class,
                Task.class
        ).addMapping(TaskVO::getKey, Task::setId);
        mapper.createTypeMap(
                Task.class,
                TaskVO.class
        ).addMapping(Task::getId, TaskVO::setKey);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();

        for(O o: origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
