package top.suika.vm.util;

public final class LimitedStack<E>{

  private final E[] value;
  private int top = -1;
  private final int size;
  
  public LimitedStack(int size){
    this.value = (E[]) new Object[size];
    this.size = size;
  }
  
  public int count(){ return top + 1; }
  public int size(){ return size; }
  
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
