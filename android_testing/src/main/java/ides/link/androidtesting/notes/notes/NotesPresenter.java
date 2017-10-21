/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ides.link.androidtesting.notes.notes;

import ides.link.androidtesting.notes.data.Note;
import ides.link.androidtesting.notes.data.NotesRepository;
import ides.link.androidtesting.notes.util.EspressoIdlingResource;

import android.support.annotation.NonNull;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Listens to user actions from the UI ({@link NotesFragment}), retrieves the data and updates the
 * UI as required.
 */
public class NotesPresenter implements NotesContract.UserActionsListener {

    private final NotesRepository mNotesRepository;
    private final NotesContract.View mNotesView;

    public NotesPresenter(
            @NonNull NotesRepository notesRepository, @NonNull NotesContract.View notesView) {
        mNotesRepository = checkNotNull(notesRepository, "notesRepository cannot be null");
        mNotesView = checkNotNull(notesView, "notesView cannot be null!");
    }

    @Override
    public void loadNotes(boolean forceUpdate) {
        mNotesView.setProgressIndicator(true);
        if (forceUpdate) {
            mNotesRepository.refreshData();
        }
        //Espresso has ability to synchronize all test actions. Espresso waits until the UI is idle
        // before it moves to the next operation.

        // However, sometimes it is not possible to rely on automatic synchronisation,
        // for instance when your app does background operations via non-standard means

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        EspressoIdlingResource.increment(); // App is busy until further notice

        mNotesRepository.getNotes(new NotesRepository.LoadNotesCallback() {
            @Override
            public void onNotesLoaded(List<Note> notes) {
                EspressoIdlingResource.decrement(); // Set app as idle.
                mNotesView.setProgressIndicator(false);
                mNotesView.showNotes(notes);
            }
        });
    }

    @Override
    public void addNewNote() {

        mNotesView.showAddNote();
    }

    @Override
    public void openNoteDetails(@NonNull Note requestedNote) {
        checkNotNull(requestedNote, "requestedNote cannot be null!");
        mNotesView.showNoteDetailUi(requestedNote.getId());
    }

}
