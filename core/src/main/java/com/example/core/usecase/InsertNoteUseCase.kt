package com.example.core.usecase

import com.example.core.data.NoteRepository
import com.example.core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.core.usecase.base.FlowUseCase
import com.example.core.usecase.base.ResultStatus
import com.example.core.usecase.base.UseCase
import java.util.*
import javax.inject.Inject

interface InsertNoteUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<Unit>>

    data class Params(val note: Note)
}

class InsertNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository,
) : UseCase<InsertNoteUseCase.Params, Unit>(), InsertNoteUseCase {

    override suspend fun doWork(params: InsertNoteUseCase.Params): ResultStatus<Unit> {
        noteRepository.insertNote(params.note)
        return ResultStatus.Success(Unit)
    }
}