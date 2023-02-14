package com.example.core.usecase

import com.example.core.data.NoteRepository
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface DeleteAllNoteUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<Unit>>

    data class Params(val note: Unit)
}

class DeleteAllNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : UseCase<DeleteAllNoteUseCase.Params, Unit>(), DeleteAllNoteUseCase {

    override suspend fun doWork(params: DeleteAllNoteUseCase.Params): ResultStatus<Unit> {
        noteRepository.deleteAll()
        return ResultStatus.Success(Unit)
    }
}