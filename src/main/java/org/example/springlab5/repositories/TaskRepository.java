package org.example.springlab5.repositories;

import org.example.springlab5.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<org.example.springlab5.models.Task, Long> {
}
