package com.example.core.usecase

import com.example.core.data.NoteRepository
import com.example.core.model.Note
import com.example.core.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetNotesUseCase {

    suspend operator fun invoke(params: Unit = Unit): Flow<List<Note>>
}

class GetNotesUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : FlowUseCase<Unit, List<Note>>(), GetNotesUseCase {

    override suspend fun createFlowObservable(params: Unit): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}