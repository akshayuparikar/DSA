package dsa;

public class PriorityQueue {
	private int[] Q;
	private int rear, front, maxSize;

	public PriorityQueue(int size) {
		rear = -1;
		front = 0;
		maxSize = size;
		Q = new int[maxSize];
	}

	public boolean isEmpty() {
		return rear < front;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// Insert and maintain ascending order
	public void Enqueue(int e) {
		if (isFull()) {
			System.out.println("Queue is Full");
			return;
		}

		// Insert element
		rear++;
		Q[rear] = e;

		// Sort to maintain priority order (lowest first) 10,20,30,40
		for (int i = front; i < rear; i++) {
			for (int j = front; j < rear - i + front; j++) {
				if (Q[j] > Q[j + 1]) {
					int temp = Q[j];
					Q[j] = Q[j + 1];
					Q[j + 1] = temp;
				}
			}
		}
	}

	public int Dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}

		int temp = Q[front];
		front++;
		return temp;
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("Priority Queue Elements:");
		for (int i = front; i <= rear; i++) {
			System.out.print(Q[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(5);
		pq.Enqueue(70);
		pq.Enqueue(60);
		pq.Enqueue(50);
		pq.Enqueue(40);
		pq.Enqueue(30);
		pq.Enqueue(20);
		pq.Enqueue(10);

		pq.printQueue(); // should show ascending order: 10 20 30 40 70

		pq.Dequeue(); // removes 10
		pq.Dequeue(); // removes 20

		pq.printQueue(); // remaining: 30 40 70
	}
}
