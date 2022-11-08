class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int wrongNumber = 561; //Вводим число, которое вызовет ошибку

        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;
        Worker worker = new Worker(listener, errorListener);
        worker.start(arr, wrongNumber);
    }
}