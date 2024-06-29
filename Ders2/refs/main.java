public class main{
	public static void main(String[] args){
	ArrayMaker myArray = new ArrayMaker();
	System.out.println(myArray.name);
	myArray.nameChanger();
	}

}

class ArrayMaker{
	String name = "almira";
	String[] names ={"ahmet","mehmet","veli","ali","ayşe","fatma","hayriye","zeynep"};


	public void nameChanger(){
	String nameholder = this.name;
	System.out.println(this.name);
	nameholder="arimla";
	System.out.println(this.name);
	}


}
