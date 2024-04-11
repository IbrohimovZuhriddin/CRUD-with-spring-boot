package zuhriddinscode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zuhriddinscode.dto.IconDTO;
import java.util.List;

public interface ToDoService {

    String addText(IconDTO iconDTO);
    List<IconDTO> findAll();
    List<IconDTO> findBYIsDoneAll(boolean isActive);

//    Long  deleteById (Long iconId);
    void deleteById(Long id);  // gpt

//    String update (int id,IconDTO iconDTO );
    void update(Long id, IconDTO updatedToDo);
    Page<IconDTO> getAllToDos(Pageable pageable);

    //    String NewUpdate( id , iconDTO);

//    List <IconDTO>  update(Long id , IconDTO iconDTO );

}