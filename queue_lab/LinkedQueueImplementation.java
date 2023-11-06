public class LinkedQueueImplementation<T> implements QueueInterface<T> {

    private LinkedItem<T> backQueue;
    private LinkedItem<T> frontQueue;
    private int queueSize;

    public LinkedQueueImplementation() {
        backQueue = null;
        frontQueue = null;
        queueSize = 0;
    }


     public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
        QueueInterface<String> queue = new LinkedQueueImplementation<String>();
        
        System.out.println("Adding States");
        
        queue.enqueue("Vermont");

        queue.enqueue("Virginia:");

        queue.enqueue("Washington");

        queue.enqueue("Utah");

        queue.enqueue("Texas");

        queue.enqueue("Tennessee");

        while (!queue.isEmpty()) {
            System.out.println("number of items in Queue :" + queue.size());
            System.out.println("Item removed: " + queue.dequeue());
        }
        System.exit(0);
    } 


    @Override
    public void enqueue(T item) {
           LinkedItem<T> newItem = new LinkedItem<T>(item, null);

        if (queueSize == 0) {
            backQueue = newItem;
            frontQueue = newItem;
            queueSize++;
        } 
        else { 
            backQueue.setNextItem(newItem);
            backQueue = newItem;
            queueSize++;
        }

        
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (queueSize == 0) {
            throw new QueueUnderflowException();
        }
        else {
            T newQueueItem = frontQueue.getLinkedItem();
            LinkedItem<T> nextItem = frontQueue.getNextItem();
            frontQueue = nextItem;
            if (frontQueue == null)
            backQueue = null;

            queueSize--;
            return newQueueItem;
            
        }
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
        return true;
        else
        return false;
        
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }
    


}
