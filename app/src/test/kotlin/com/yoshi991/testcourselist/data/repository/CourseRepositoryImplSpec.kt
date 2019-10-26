import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.yoshi991.testcourselist.data.entity.Bookmark
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.storage.database.Database
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class CourseRepositoryImplSpec {

    lateinit var database: Database

    @Before
    fun openDatabase() {
        database =
            Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().targetContext,
                Database::class.java
            ).allowMainThreadQueries()
                .build()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertCourse() = runBlocking {
        assertEquals(database.courseDao().count(), 0)

        database.courseDao().upsert(
            Course(
                id = "ID",
                name = "Name",
                teacherName = "Teacher Name",
                numberOfTopics = 1,
                iconUrl = "url"
            )
        )

        assertEquals(database.courseDao().count(), 1)
    }

    @Test
    fun getCourse() = runBlocking {
        val course = Course(
            id = "ID",
            name = "Name",
            teacherName = "Teacher Name",
            numberOfTopics = 1,
            iconUrl = "url"
        )
        database.courseDao().upsert(course)
        val result = database.courseDao().getAll().first()

        assertEquals(course, result)
    }

    @Test
    fun deleteCourse() = runBlocking {
        database.courseDao().upsert(
            Course(
                id = "ID1",
                name = "Name",
                teacherName = "Teacher Name",
                numberOfTopics = 1,
                iconUrl = "url"
            )
        )

        database.courseDao().upsert(
            Course(
                id = "ID2",
                name = "Name",
                teacherName = "Teacher Name",
                numberOfTopics = 1,
                iconUrl = "url"
            )
        )

        assertEquals(database.courseDao().count(), 2)

        database.courseDao().deleteAll()

        assertEquals(database.courseDao().count(), 0)
    }

    @Test
    fun insertBookmark() = runBlocking {
        assertEquals(database.bookmarkDao().count(), 0)

        database.bookmarkDao().upsert(
            Bookmark(
                id = "ID",
                isBookmark = true
            )
        )

        assertEquals(database.bookmarkDao().count(), 1)
    }

    @Test
    fun getBookmark() = runBlocking {
        val bookmark = Bookmark(
            id = "ID",
            isBookmark = false
        )
        database.bookmarkDao().upsert(bookmark)
        val result = database.bookmarkDao().find(bookmark.id)

        assertEquals(bookmark, result)
    }

    @Test
    fun deleteBookmark() = runBlocking {
        val bookmark1 = Bookmark(
            id = "ID1",
            isBookmark = false
        )

        val bookmark2 = Bookmark(
            id = "ID2",
            isBookmark = false
        )

        database.bookmarkDao().upsert(bookmark1)
        database.bookmarkDao().upsert(bookmark2)
        assertEquals(database.bookmarkDao().count(), 2)

        database.bookmarkDao().delete(bookmark2.id)

        assertEquals(database.bookmarkDao().count(), 1)
    }
}
