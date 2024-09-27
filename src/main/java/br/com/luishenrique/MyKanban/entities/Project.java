package br.com.luishenrique.MyKanban.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity(name = "projects")
@SQLDelete(sql = "UPDATE projects SET deleted_at = now() WHERE id = ?")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, unique = true, nullable = false)
  private UUID id;

  @Column
  private String name;

  @Column
  private String description;

  @Column(unique = true)
  private String label;

  @Column
  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "owner_id", nullable = false)
  private User owner;

  @Column
  @ManyToMany(targetEntity = User.class, mappedBy = "projects")
  private List<User> collaborators;

  @Column
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;

}
