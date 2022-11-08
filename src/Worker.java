public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            if (i == 0) {
                arr[i] = 0;
            } else {
                arr[i] = i + arr[i-1];
            }

            if(arr[i] == number) {
                arr[i] = -1;
                errorCallback.onError("Task " + i + " is not done. Wrong number detected");
                System.out.println();
                continue;
            }

            System.out.println("Ячейка № " + (i) + " = " + arr[i]);
            callback.onDone("Task " + i + " is done");
            System.out.println();
        }
    }
}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String result);
}