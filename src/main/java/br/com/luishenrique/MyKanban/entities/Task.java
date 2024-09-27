package br.com.luishenrique.MyKanban.entities;


import br.com.luishenrique.MyKanban.Utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tasks")
@Data
@AllArgsConstructor
@SQLDelete(sql = "UPDATE tasks SET deleted_at = now() WHERE id = ?")
public class Task {

  @Column(name = "id", updatable = false, unique = true, nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  private String title;

  @Column
  private String description;

  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne(targetEntity = TasksColumns.class)
  @JoinColumn(name = "columns_id", nullable = false)
  private TasksColumns columns;

  @Column
  private LocalDateTime dueDate;

  @Column
  private LocalDateTime endDate;

  @Column
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
