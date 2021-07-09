fun main() = runBlocking {
    try {
        println("Iniciando recuperación de usuario")
        val user = fetchUserCoroutine("BEDU","KOTLIN")
//        updateUser(user)
        println(user)
    } catch (exception: Exception) {
        println("Error: $exception")
    }
}


data class User(
    val Username: String,
    val token: String,
    val age: Int,
    val gender: String,
    val credit: Long
)

interface Callback {
    fun onSuccess(user: User)
    fun onFailure(exception: Exception)
}

private fun fetchUser(callback: Callback) {
    Thread {
        Thread.sleep(3_000)

        callback.onSuccess(
            User(
            "BEDU",
            "783-43-E32B-648C",
            32,
            "Female",
            0
        ))
    }.start()
}

private suspend fun fetchUserCoroutine(username: String,password:String): User = suspendCancellableCoroutine {
        cancellableContinuation ->
    fetchUser(object : Callback {
        override fun onSuccess(user: User) {
            cancellableContinuation.resume(user)
        }

        override fun onFailure(exception: Exception) {
            cancellableContinuation.resumeWithException(exception)
        }
    })
}

