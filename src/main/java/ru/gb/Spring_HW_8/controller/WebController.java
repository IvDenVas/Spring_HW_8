package ru.gb.Spring_HW_8.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.Spring_HW_8.model.Note;
import ru.gb.Spring_HW_8.service.NoteServiceImplements;
import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private final NoteServiceImplements noteService;

    @GetMapping("/main")
    public String getAllNotes(Model model) {
        List<Note> noteList = noteService.getAllNotes();
        model.addAttribute("notes", noteList);
        return "show";
    }

    @PostMapping("/main")
    public String addNote(Note note, Model model) {
        noteService.newNote(note);
        return "redirect:/main";
    }

    @GetMapping("/update/{id}")
    public String updateNoteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "update";
    }

    @PutMapping("/update")
    public String updateNote(@PathVariable("id") Long id, @ModelAttribute ("note") Note note) {
        noteService.updateNote(id, note);
        return "redirect:/main";
    }
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/main";
    }
}