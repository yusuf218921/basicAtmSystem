public class ThreadOperations {

    // kullanıcıyı biraz bekletmek için oluşturulmuş metod
    public static void thread_sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
