package com.yeshuwahane.memberregistrationapp.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yeshuwahane.memberregistrationapp.data.model.MemberEntity


@Database(entities = [MemberEntity::class], version = 1, exportSchema = false)
abstract class MemberDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao
}