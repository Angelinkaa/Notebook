package ru.gb.mynotebook.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.mynotebook.R;
import ru.gb.mynotebook.domain.NoteEntity;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView titleTextView = itemView.findViewById(R.id.title_text_view);
    private final TextView noteTextView = itemView.findViewById(R.id.note_text_view);
    private NoteEntity noteEntity = null;

    public NoteViewHolder(@NonNull ViewGroup parent, OnItemClickListener clickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_activity, parent, false));
        itemView.setOnClickListener(view -> clickListener.onItemClick(noteEntity));
    }

    public void bind(NoteEntity noteEntity) {
        this.noteEntity = noteEntity;
        titleTextView.setText(noteEntity.getTitle());
        noteTextView.setText(noteEntity.getNoteText());
    }
}
