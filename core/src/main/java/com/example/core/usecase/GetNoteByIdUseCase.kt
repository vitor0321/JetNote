package com.example.core.usecase

import com.example.core.data.NoteRepository
import com.example.core.model.Note
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

interface GetNoteByIdUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<Note>>

    data class Params(val id: UUID)
}

class GetNotesByIdUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : UseCase<GetNoteByIdUseCase.Params, Note>(), GetNoteByIdUseCase {

    override suspend fun doWork(params: GetNoteByIdUseCase.Params): ResultStatus<Note> {
        val isNote = noteRepository.getNoteById(params.id)
        return ResultStatus.Success(isNote)
    }
}