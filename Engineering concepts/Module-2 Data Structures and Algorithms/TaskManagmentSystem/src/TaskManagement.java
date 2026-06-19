class Task {
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
    }
}

public class TaskManagement {

    Node head;

    void add(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    Task search(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.taskId == id)
                return temp.task;
            temp = temp.next;
        }
        return null;
    }

    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task.taskId + " "
                    + temp.task.taskName + " "
                    + temp.task.status);
            temp = temp.next;
        }
    }

    void delete(int id) {
        if (head == null)
            return;

        if (head.task.taskId == id) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.task.taskId == id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}