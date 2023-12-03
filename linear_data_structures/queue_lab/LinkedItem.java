public class LinkedItem<T> {
    private T linkedItem;
    private LinkedItem<T> nextItem;

    public LinkedItem() {
        linkedItem = null;
        nextItem = null;
    }

    public LinkedItem(T linkedItem, LinkedItem<T> nextItem) {
        setLinkedItem(linkedItem);
        setNextItem(nextItem);
    }


    public T getLinkedItem() {
        return linkedItem;
    }

    public void setLinkedItem(T linkedItem) {
        this.linkedItem = linkedItem;
    }

    public LinkedItem<T> getNextItem() {
        return nextItem;
    }

    public void setNextItem(LinkedItem<T> nextItem) {
        this.nextItem = nextItem;
    }
}