package ru.gb.Spring_HW_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Spring_HW_8.model.Note;


@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}