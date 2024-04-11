package zuhriddinscode.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import zuhriddinscode.entity.ToDoEntity;

import java.util.List;

public interface IconRepository extends JpaRepository<ToDoEntity,Long > {
    List<ToDoEntity> findByDone(boolean isActive);  // listni entity qaytaradi
    Page<ToDoEntity> findAll(Pageable pageable);
}