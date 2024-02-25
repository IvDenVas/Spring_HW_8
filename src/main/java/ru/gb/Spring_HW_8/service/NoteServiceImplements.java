package ru.gb.Spring_HW_8.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Spring_HW_8.aspects.TrackUserAction;
import ru.gb.Spring_HW_8.model.Note;
import ru.gb.Spring_HW_8.repository.NoteRepo;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImplements implements NoteService{

    private NoteRepo noteRepo;
    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).get();
    }
    @TrackUserAction
    @Override
    public Note updateNote(Long id, Note note) {
        Note updateNote = noteRepo.findById(id).get();
        updateNote.setTitle(note.getTitle());
        updateNote.setDescription(note.getDescription());
        updateNote.setDateTime(note.getDateTime());
        return noteRepo.save(updateNote);
    }
    @TrackUserAction
    @Override
    public Note newNote(Note note) {
        return noteRepo.save(note);
    }
    @TrackUserAction
    @Override
    public void deleteNoteById(Long id) {
        Note note = getNoteById(id);
        noteRepo.delete(note);
    }
}