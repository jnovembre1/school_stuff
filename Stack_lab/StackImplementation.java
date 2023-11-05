//Made by Joseph


public class StackImplementation<T>
    implements StackInterface {
    int itemsOnStack;
    private T[] stack;



    public StackImplementation (int initialSize) { 
    stack = (T [] ) new Object[initialSize];
    itemsOnStack = 0;

}



    private void expandArray() {
        T[] expandedStack;

        expandedStack = (T []) new Object[stack.length + 10];

        for (int item = 0; item < stack.length; item++) {
            expandedStack[item] = stack[item];
        }
        stack = expandedStack;
    }
    public void push(Object item) {
        if (stack.length == itemsOnStack) {
            System.out.println("Error, the stack is full."); //unsure if you wanted us to keep this error statement or not
                                                               //with the inclusion of expandedArray()
            expandArray();
        }
        else {
            stack[itemsOnStack] = (T) item;
            itemsOnStack++;
        }
    }



    @Override
    public Object peek() {
        if (stack.length == 0) {
            System.out.println("Stack is empty.");
            return stack[itemsOnStack];
            
        }
        else 
        return stack[itemsOnStack];
    }



    @Override
    public Object pop() {
        itemsOnStack--;
        return stack[itemsOnStack];
    }



    @Override
    public boolean isFull() {
        if (stack.length == itemsOnStack )
        {
            return true;
        }
        else {
            return false;
        }    }



    @Override
    public boolean isEmpty() {
        if (itemsOnStack == 0)
        return true;
        else
        return false;
    }

    
}