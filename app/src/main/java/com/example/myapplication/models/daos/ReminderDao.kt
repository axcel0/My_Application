package com.example.myapplication.models.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.models.entities.ReminderEntity
import java.time.LocalDateTime
import java.util.Date

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders")
    fun getReminders(): List<ReminderEntity>

    @Query("SELECT * FROM reminders WHERE id = :id")
    fun getReminder(id: Int): ReminderEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertReminder(reminder: ReminderEntity): Long

    @Delete
    fun deleteReminder(reminder: ReminderEntity)

    //delete all items in the table
    @Query("DELETE FROM reminders")
    fun deleteAllReminders()

    //update reminder by id
    @Update
    fun updateReminder(reminder: ReminderEntity)

    //search reminder by title
    @Query("SELECT * FROM reminders WHERE reminderName LIKE '%' || :reminderName || '%' ")
    fun searchReminder(reminderName: String): List<ReminderEntity>
}
