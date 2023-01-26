package ru.gb.mynotebook.domain;

import javax.annotation.Nullable;

public class NoteEntity {

    @Nullable
    private Integer id;
    private final String title;
    private final String noteText;

    public NoteEntity(@Nullable Integer id, String title, String noteText) {
        this.id = id;
        this.title = title;
        this.noteText = noteText;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getNoteText() {
        return noteText;
    }

}
