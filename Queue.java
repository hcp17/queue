package algoritmos;
//
public class Queue<Value> {
	Value head;
	Value tail;
	int size;
	Value arr[];

	public Queue(){
		head=null;
		tail=null;
		size=0;
		arr=(Value[])new Object [1];
	}
	int size(){
		return size;
	}
	Value peek(){
		return head;
	}
	void enqueue(Value x){
		if(size==0){
         arr[0]=x;
			head=tail=arr[0];
		}
		else if (size==arr.length){
			ResizeArr();
			arr[size]=x;
			tail=arr[size];
			}
		else if(tail==arr[arr.length-1]){
			arr[0]=x;
			tail=arr[0];
			}
      else if(arr[0]==null){
         for(int con=1;con<arr.length;con++){
            if(arr[con-1]==tail){
               arr[con]=x;
               tail=arr[con];
               break;
            }
         }
      }
		
		else{
			for(int con=0; con<=size;con++){
				if(arr[con]==null){
					arr[con]=x;
					tail=arr[con];
					break;
				}
			}
			    
		}	
				
		
		size++;
	}
	Value dequeue() throws Exception{
		if (size==0)
			throw new Exception();
		Value ret=head;
		if(head==arr[arr.length-1]){
			head=arr[0];
		    arr[arr.length-1]=null;
		    }
		else{ 
			for(int con=0; con<size;con++){
			if(arr[con]==head){
				head=arr[con+1];
				arr[con]=null;
				break;
			}
		}
			}
		size--;
		return ret;
	}
	  void ResizeArr(){
			Value temp[]=(Value[])new Object [size*2];
         int size_2=0;
         int i=0;
        if(head!=arr[0]){
        for (i=0;i<arr.length;i++){
           if(arr[i]==head ){
        	   temp[size_2]=arr[i];
               size_2++;
               break;
               
           }
        }i++;
        
           while(i<arr.length){
              temp[size_2]=arr[i];
              i++;
              size_2++;
           }
           for(int j=0;arr[j]!=tail;j++){
              temp[size_2]=arr[j];
              size_2++;
           }
           temp[size_2]=tail;
           tail=temp[size_2];
        }
        else{
        for(int k=0;k<size;k++)
           temp[k]=arr[k];
        }
			arr=temp;
		}
	  public static void main(String[] args){
		  Queue <Character>q=new Queue<Character>();
		  q.enqueue('a');
		  q.enqueue('b');
		  //q.enqueue('c');
		  //q.enqueue('d');
		  q.enqueue('e');
		  try{
			  q.dequeue();
			  q.dequeue();
			  }catch(Exception e){}
		  q.enqueue('ñ');
		  q.enqueue('p');
        q.enqueue('h');
        q.enqueue('r');
		  
	  }
	
}