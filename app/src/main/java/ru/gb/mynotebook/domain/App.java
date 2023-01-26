package ru.gb.mynotebook.domain;

import android.app.Application;

import ru.gb.mynotebook.data.NotesRepoImpl;

public class App extends Application {
    private final NotesRepo repo = new NotesRepoImpl();

    public NotesRepo getRepo() {
        return repo;
    }
}
