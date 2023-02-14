package com.example.core.usecase

import com.example.core.data.NoteRepository
import com.example.core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import javax.inject.Inject

interface DeleteNoteUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<Unit>>

    data class Params(val note: Note)
}

class DeleteNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository,
) : UseCase<DeleteNoteUseCase.Params, Unit>(), DeleteNoteUseCase {

    override suspend fun doWork(params: DeleteNoteUseCase.Params): ResultStatus<Unit> {
        noteRepository.deleteNote(params.note)
        return ResultStatus.Success(Unit)
    }
}