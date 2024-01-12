public class TestDivisibilite{
   	
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
   
   
   
   	private static boolean estDivisiblePar7(int nombre){
   	    return false ;
   	    // A MODIFIER
   	}
   
    // nombre1 est divisible par nombre2
    private static boolean estDivisiblePar(int nombre1, int nombre2) {
   	    return false;  // A MODIFIER
   	}
   
    // nombre1 est le reste de la division de nombre2 par nombre3
    private static boolean estLeResteDeLaDivision(int nombre1, int nombre2, int nombre3){
   	    return false;  // A MODIFIER
   	}
   
    // un des nombres (n'importe lequel)  est le reste de la division des 2 autres nombres
    private static boolean unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(int nombre1, int nombre2, int nombre3){
   	    return false;  // A MODIFIER
   	}
   
   	public static void main(String [] args){
   	    int choix;
   	    do{
   	        System.out.println("1 -> Tester la méthode estDivisiblePar7");
            System.out.println("2 -> Tester la méthode estDivisiblePar");
            System.out.println("3 -> Tester la méthode estLeResteDeLaDivision");
            System.out.println("4 -> Tester la méthode unDesNombresEstLeResteDeLaDivisionDesDeuxAutres");
            System.out.println("Entrez votre choix :");
            choix=scanner.nextInt();
            switch(choix){
               case 1: testEstDivisiblePar7(); 
                  break;
               case 2: testEstDivisiblePar(); 
                  break;
               case 3: testEstLeResteDeLaDivision(); 
                  break;
               case 4: testUnDesNombresEstLeResteDeLaDivisionDesDeuxAutres(); 
                  break;
            
            }
   	    }while(choix >=1 && choix<=4);
   	}
   
   
   	private static void testEstDivisiblePar7(){
   	    if(! estDivisiblePar7(14)){
   	        System.out.println("Attention test : 14 a échoué");
            return;
   	    }
   	    if(estDivisiblePar7(15)){
            System.out.println("Attention test : 15 a échoué");
            return;
   	    }
   	    System.out.println("Tous les tests ont réussi!");
   	}
   
   	private static void testEstDivisiblePar(){
   	    if(!estDivisiblePar(8,2)){
   	        System.out.println("Attention test : 8 2 a échoué");
            return;
   	    }
   	    if(estDivisiblePar(8,3)){
   	        System.out.println("Attention test : 8 3 a échoué");
            return;
   	    }
   	    if(!estDivisiblePar(0,3)){
            System.out.println("Attention test : 0 3 a échoué");
            return;
   	    }
   	    try{
            if(estDivisiblePar(8,0)){
               System.out.println("Attention test : 8 0 a échoué");
               return;
            }
   	    } catch( ArithmeticException e){
               System.out.println("Attention test : 8 0");
               System.out.println("Division par 0 --> ArithmeticException!");
               return;
   	    }
   	    System.out.println("Tous les tests ont réussi!");
      
   	}
   
   	private static void testEstLeResteDeLaDivision(){
   	    if(!estLeResteDeLaDivision(2,8,3)){
            System.out.println("Attention test : 2 8 3 a échoué");
            return;
   	    }
   	    if(estLeResteDeLaDivision(1,8,3)){
   	        System.out.println("Attention test : 1 8 3 a échoué");
            return;
   	    }
   	    if(!estLeResteDeLaDivision(0,8,2)){
            System.out.println("Attention test : 0 8 2 a échoué");
            return;
   	    }
   	    if(!estLeResteDeLaDivision(0,0,2)){
            System.out.println("Attention test : 0 0 2 a échoué");
            return;
   	    }
   	    try{
            if(estLeResteDeLaDivision(1,1,0)){
                System.out.println("Attention test : 1 1 0 a échoué");
                return;
            }
   	    } catch( ArithmeticException e){
               System.out.println("Attention test : 1 1 0");
               System.out.println("Division par 0 --> ArithmeticException!");
					return;
   	    }
   	    System.out.println("Tous les tests ont réussi!");
      
   	}
   
   	private static void testUnDesNombresEstLeResteDeLaDivisionDesDeuxAutres(){
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(2,8,3)){
             System.out.println("Attention test : 2 8 3 a échoué");
             return;
         }
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(3,8,2)){
             System.out.println("Attention test : 3 8 2 a échoué");
             return;
         }
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(8,3,2)){
             System.out.println("Attention test : 8 3 2 a échoué");
             return;
         }
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(8,2,3)){
             System.out.println("Attention test : 8 2 3 a échoué");
             return;
         }
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(3,2,8)){
             System.out.println("Attention test : 3 2 8 a échoué");
             return;
         }
         if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(2,3,8)){
             System.out.println("Attention test : 2 3 8 a échoué");
             return;
         }
         if(unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(1,8,3)){
             System.out.println("Attention test : 1 8 3 a échoué");
             return;
         }
         try{
             if(unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(0,3,7)){
                 System.out.println("Attention test : 0 3 7 a échoué");
                 return;
             }
         } catch( ArithmeticException e){
                System.out.println("Attention test : 0 3 7 a échoué");
                return;
         }
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(0,8,2)){
                 System.out.println("Attention test : 0 8 2 a échoué");
                 return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 0 8 2 a échoué");
             return;
         }
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(0,2,8)){
                 System.out.println("Attention test : 0 2 8 a échoué");
                 return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 0 2 8 a échoué");
             return;
         }
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(8,0,2)){
                System.out.println("Attention test : 8 0 2 a échoué");
                return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 8 0 2 a échoué");
             return;
         }
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(2,0,8)){
                System.out.println("Attention test : 2 0 8 a échoué");
                return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 2 0 8 a échoué");
             return;
         }
         
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(8,2,0)){
                System.out.println("Attention test : 8 2 0 a échoué");
                return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 8 2 0 a échoué");
             return;
         }
         
         try{
             if(!unDesNombresEstLeResteDeLaDivisionDesDeuxAutres(2,8,0)){
                System.out.println("Attention test : 2 8 0 a échoué");
                return;
             }
         } catch( ArithmeticException e){
             System.out.println("Attention test : 2 8 0 a échoué");
             return;
         }
      // A CONTINUER
         System.out.println("Tous les tests ont réussi!");
      
   	}
}
