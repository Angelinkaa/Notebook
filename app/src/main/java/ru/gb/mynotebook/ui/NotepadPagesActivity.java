package ru.gb.mynotebook.ui;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import ru.gb.mynotebook.R;
import ru.gb.mynotebook.databinding.NotepadListActivityBinding;
import ru.gb.mynotebook.domain.NoteEntity;
import ru.gb.mynotebook.ui.aboutApplicationFragment.AboutApplicationFragment;
import ru.gb.mynotebook.ui.notePageFragment.NotePageFragment;
import ru.gb.mynotebook.ui.notepadPagesFragment.NotepadPagesFragment;
import ru.gb.mynotebook.ui.settingFragment.SettingsFragment;

public class NotepadPagesActivity extends AppCompatActivity implements NotepadPagesFragment.Contract {
    private NotepadListActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NotepadListActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initNotepadListFragment();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initNotepadListFragmentLand();
        }
    }

    protected void initNotepadListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainer.getId(), new NotepadPagesFragment())
                .commit();
    }

    @Override
    public void openNewNote(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainer.getId(), NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void openNewNoteLand(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainerTwo.getId(), NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    protected void initNotepadListFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainer.getId(), new NotepadPagesFragment())
                .replace(binding.fragmentNotepadListContainerTwo.getId(), new NotePageFragment())
                .commit();
    }

    public void openSettingsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainer.getId(), new SettingsFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openSettingsFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainerTwo.getId(), new SettingsFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openAboutApplicationFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainer.getId(), new AboutApplicationFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openAboutApplicationFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.fragmentNotepadListContainerTwo.getId(), new AboutApplicationFragment())
                .addToBackStack(null)
                .commit();
    }

    public void closeApp() {
        new AlertDialog.Builder(this).setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setTitle(R.string.exit)
                .setMessage(R.string.are_you_sure)
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> finishAndRemoveTask()).setNegativeButton(R.string.no, null).show();
    }

    @Override
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        } else {
            closeApp();
        }
    }
}