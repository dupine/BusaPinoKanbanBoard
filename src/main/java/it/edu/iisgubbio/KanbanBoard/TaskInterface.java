package it.edu.iisgubbio.KanbanBoard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskInterface extends JpaRepository<Task, Integer>{
}