package dsa;

public class CircularQueue {

    int arr[];
    int size;
    int rear;
    int front;

    public CircularQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int result = arr[front];

        if (rear == front) {
            rear = front = -1;
   
        } else {
            front = (front + 1) % size;
        }

        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int i = front;
        System.out.print("Queue: ");
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.display();

        System.out.println("Peek: " + cq.peek());
        cq.dequeue();
        cq.dequeue();
        cq.display();
        cq.enqueue(50);
        cq.enqueue(60);
        cq.display();
    }
}
