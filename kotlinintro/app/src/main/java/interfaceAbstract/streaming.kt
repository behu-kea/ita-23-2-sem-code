import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/*
 * Instagram like service
 * https://behu.gitbook.io/ita23-2.-semester/cs101/05-interfaces-abstract#instagram-like-service
 */
@RequiresApi(Build.VERSION_CODES.O)
fun instagramCopyCat() {
    val nicePostTextContent = "Pretend this is a lot of text. Hi mom!"
    val nicePost = TextPost("John Doe", "Greetings world!", nicePostTextContent)
    nicePost.getLikesDislikes()
    println(nicePost.timestamp)
    nicePost.likePost()
    nicePost.getLikesDislikes()
    println()

    val awesomePicture = PhotoPost("Mrs. Claus", "Freezing North Pole", "some/path/image.png", 4096, "vintage")
    awesomePicture.getLikesDislikes()
    println(awesomePicture.timestamp)
    println(awesomePicture.filters)
}

@RequiresApi(Build.VERSION_CODES.O)
abstract class CommonPost(val uploader: String, val caption: String) {
    var likes: Int = 0
    var dislikes: Int = 0
    val timestamp: String

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setTimestamp(): String {
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        return LocalDateTime.now().format(dateFormatter)
    }
    init {
        timestamp = setTimestamp()
    }
    fun likePost() {
        likes += 1
    }
    fun dislikes() {
        dislikes += 1
    }
    fun getLikesDislikes() {
        println("Number of likes: ${this.likes} | Number of dislikes: ${this.dislikes}")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
class TextPost(
    uploader: String,
    caption: String,
    val textContent: String,
) : CommonPost(uploader, caption) {}


@RequiresApi(Build.VERSION_CODES.O)
class PhotoPost(
    uploader: String,
    caption: String,
    val path: String,
    val resolution: Int,
    val filters: String
) : CommonPost(uploader, caption) {}