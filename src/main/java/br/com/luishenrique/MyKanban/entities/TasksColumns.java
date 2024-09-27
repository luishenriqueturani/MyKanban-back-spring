package br.com.luishenrique.MyKanban.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tasks_columns")
@Data
@AllArgsConstructor
@SQLDelete(sql = "UPDATE tasks_columns SET deleted_at = now() WHERE id = ?")
public class TasksColumns {

  private long id;
  private String title;

  private TasksColumns prev;
  private TasksColumns next;

  private List<Task> tasks;

  @Column
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
