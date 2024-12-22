package com.yeshuwahane.memberregistrationapp.di

import android.content.Context
import androidx.room.Room
import com.yeshuwahane.memberregistrationapp.data.datasource.MemberDao
import com.yeshuwahane.memberregistrationapp.data.datasource.MemberDatabase
import com.yeshuwahane.memberregistrationapp.data.repositoryimpl.MemberRepositoryImpl
import com.yeshuwahane.memberregistrationapp.domain.repository.MemberRepository
import com.yeshuwahane.memberregistrationapp.domain.usecase.AddMemberUseCase
import com.yeshuwahane.memberregistrationapp.domain.usecase.GetMembersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext app: Context): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MemberDatabase {
        return Room.databaseBuilder(
            context,
            MemberDatabase::class.java,
            "member_database"
        ).build()
    }

    @Provides
    fun provideMemberDao(database: MemberDatabase): MemberDao = database.memberDao()

    @Provides
    fun provideRepository(dao: MemberDao): MemberRepository = MemberRepositoryImpl(dao)

    @Provides
    fun provideGetMembersUseCase(repository: MemberRepository) = GetMembersUseCase(repository)

    @Provides
    fun provideAddMemberUseCase(repository: MemberRepository) = AddMemberUseCase(repository)
}