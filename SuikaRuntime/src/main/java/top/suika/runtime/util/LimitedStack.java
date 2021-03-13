package top.suika.runtime.util;

/**
 * such a useless thing.
 *
 * @param <E> type of elements.
 */
public final class LimitedStack<E>{

  private final E[] value;
  private int top = -1;
  private final int capacity;
  
  public LimitedStack(int size){
    this.value = (E[]) new Object[size];
    this.capacity = size;
  }
  
  public int count(){ return top + 1; }
  public int capacity(){ return capacity; }
  
  public void push(E val){
    value[++top] = val;
  }
  
  public E pop(){
    return value[top--];
  }
  
  public E peek(){
    return value[top];
  }
  
}
