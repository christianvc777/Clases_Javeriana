class Padre{

  private void m1(){
    System.out.println("Desde el padre el m1()");
  }

  protected void m2(){
    System.out.println("Desde el padre el m2()");
  }
}
class Hija extends Padre{

  private void m1(){
      System.out.println("Desde la Hija m1()");
  }
  public void m2(){
      System.out.println("Desde la Hija m2()");    
  }
}

class Persona{
  public static void main(String[] args){

    Padre padre = new Padre();
    padre.m2();
    Padre hija = new Hija();
    hija.m2();
    
  }
}
