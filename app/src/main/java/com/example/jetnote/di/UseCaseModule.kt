package com.example.jetnote.di

import com.example.core.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindDeleteAllNoteUseCaseUseCase(useCase: DeleteAllNoteUseCaseImpl): DeleteAllNoteUseCase

    @Binds
    fun bindDeleteNoteUseCaseUseCase(useCase: DeleteNoteUseCaseImpl): DeleteNoteUseCase

    @Binds
    fun bindGetNoteByIdUseCaseUseCase(useCase: GetNotesByIdUseCaseImpl): GetNoteByIdUseCase

    @Binds
    fun bindGetNotesUseCaseUseCase(useCase: GetNotesUseCaseImpl): GetNotesUseCase

    @Binds
    fun bindInsertNoteUseCaseUseCase(useCase: InsertNoteUseCaseImpl): InsertNoteUseCase

    @Binds
    fun bindUpdateNoteUseCaseUseCase(useCase: UpdateNoteUseCaseImpl): UpdateNoteUseCase
}