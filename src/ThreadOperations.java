public class ThreadOperations {

    // kullanıcıyı biraz bekletmek için oluşturulmuş metod
    public static void thread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
